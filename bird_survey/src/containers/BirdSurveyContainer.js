import React, {Component, Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import SurveyList from '../components/visits/SurveyList';
import Request from '../helpers/request';
import SurveyForm from '../components/visits/SurveyForm';

class BirdSurveyContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      birds: [],
      visits: [],
    }

      this.handleSurveyDelete=this.handleSurveyDelete.bind(this);
      this.handleBirdDelete=this.handleBirdDelete.bind(this);
      this.getSurveyBirds=this.getSurveyBirds.bind(this);
      this.handlePost=this.handlePost.bind(this);
  }

  componentDidMount(){
    this.getSurveyBirds();
  }
    
  getSurveyBirds(){
    const request = new Request();
    const birdPromise = request.get('/api/birds');
    const visitPromise = request.get('/api/visits');

    Promise.all([birdPromise,visitPromise])
    .then(data => {
      this.setState({
        birds: data[0],
        visits: data[1]
    })
  })
}



  findSurveyById(id){
    return this.state.visits.find((visit) => {
      return visit.id === parseInt(id);
    });
  }
  findBirdsBySurveyId(id){
    return this.state.birds.filter((birds) => {
      return birds.surveyVisit.id === parseInt(id);
    });
  }

  handleSurveyDelete(id){
    if(this.findBirdsBySurveyId(id).length>0){
      alert("Please delete the associated bird records first");
    } else {
      const request = new Request();
      const url = '/api/visits/' + id;
      request.delete(url)
      .then(()=> {
        this.getSurveyBirds();
        window.location = '/visits';
      })
      .catch(err => console.log(err));
    }
  }

  handleBirdDelete(bird){
    const request = new Request();
    const url = '/api/birds/' + bird.id;
    request.delete(url)
    .then(()=> this.getSurveyBirds())
    .catch(err => console.log(err));
  }
  handlePost(survey){
    const request = new Request();
    request.post('/api/visits', survey)
    .then((survey)=> window.location = '/visits/' + survey.id)
    .catch(err => console.log(err));
  }
 
  handlePatch(survey){
    const request = new Request();
    const url='/api/visits/' + survey.id
    request.patch(url, survey)
    .then(()=> window.location = '/visits')
    .catch(err => console.log(err));
  }
  handleBirdPost(bird){
    const request = new Request();
    request.post('/api/birds', bird)
    .then(()=> window.location = '/visits/'+ bird.surveyVisit.id)
    .catch(err => console.log(err));
  }

  handleBirdPatch(bird){
    const request = new Request();
    const url='/api/birds/' + bird.id
    request.patch(url, bird)
    .then(()=> 
      window.location = '/visits/'+ bird.surveyVisit.id)
    .catch(err => console.log(err));
  }

  render(){
    return(
      <Router>
      <Fragment>
      <Switch>
      <Route exact path="/visits/new" render={(props) => {
        return <SurveyForm surveys={this.state.visits} onCreate ={this.handlePost} onBirdCreate={this.handleBirdPost}/>
      }}/>
      <Route exact path="/visits/:id" render={(props) =>{
        const id = props.match.params.id;
        const survey = this.findSurveyById(id)|| {};
        const birds=this.findBirdsBySurveyId(id);
        return <SurveyForm key={survey.id} currSurvey={survey} onBirdUpdate={this.handleBirdPatch} onUpdate={this.handlePatch} onBirdCreate={this.handleBirdPost} currBirds={birds} onSurveyDelete={this.handleSurveyDelete} onBirdDelete={this.handleBirdDelete}/>
      }}/>

      <Route render={(props) =>{
        return <SurveyList surveys={this.state.visits}/>
      }}/>
      </Switch>
      </Fragment>
      </Router>
    )
  }

}

export default BirdSurveyContainer;

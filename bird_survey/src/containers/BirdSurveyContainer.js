import React, {Component, Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import SurveyList from '../components/visits/SurveyList';
import Request from '../helpers/request';
import Survey from '../components/visits/Survey';

class BirdSurveyContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      birds: [],
      visits: []
    }

      this.findSurveyById = this.findSurveyById.bind(this);
  }

  componentDidMount(){
    const request = new Request();
    // request.get('api/visits')
    // .then((data) => {
      // this.setState({visits: data});
    // })

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

  handleBirdDelete(id){
    const request = new Request();
    const url = '/api/birds/' + id;
    request.delete(url)
    .then(()=> window.location ='/birds')
  }

  handleSurveyDelete(id){
    const request = new Request();
    const url = '/api/visits/' + id;
    request.delete(url)
    .then(()=> window.location ='/surveys')
  }

  handlePost(bird){
    const request = new Request();
    request.post('/api/birds', bird)
    .then(()=> window.location = '/birds')
  }

  render(){
    return(
      <Router>
      <Fragment>
      <Switch>
      {/* <Route exact path="/visits/new" render={(props) => {
        return <SurveyForm surveys={this.state.visits} onCreate ={this.handlePost}/>
      }}/> */}
      <Route exact path="/visits/:id" render={(props) =>{
        const id = props.match.params.id;
        const survey = this.findSurveyById(id);
        return <Survey survey={survey} />
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

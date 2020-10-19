import React, {Component} from 'react';
import BirdList from '../birds/BirdList';
import Map from '../maps/Map';
import Bird from '../birds/Bird';

class SurveyForm extends Component {
    constructor(props){
        super(props);
        this.state={
            survey: [],

        }
        this.handleChange=this.handleChange.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this);
        this.handleDelete=this.handleDelete.bind(this);
    }
    componentDidMount(){
        if(this.props.currSurvey){
            this.setState({survey: this.props.currSurvey});
        }
    }
    handleChange(event){
        const propertyName= event.target.name;
        const survey = this.state.survey;
        survey[propertyName]= event.target.value;
        this.setState({survey:survey});
    }

    handleSubmit(event){
        event.preventDefault();
        if(this.props.currSurvey){
            this.props.onUpdate(this.state.survey);
        }
            this.props.onCreate(this.state.survey);
    }
    handleDelete(){
        this.props.onSurveyDelete(this.state.survey.id);
    }

    render(){

        return (
            <div>
                <button><a href="/visits" className="aHome">Home</a></button>
                <button>Text Entry</button>
                <button>Voice Entry</button>
                <button>Upload to Database</button>
                <button>Prev.</button>
                <button>Next</button>
            <form className="visit-container" onSubmit={this.handleSubmit} >
                <div className="visit-form">
                    <label>Project No. </label><input type="number" placeholder="Project Number" name="projectNumber" onChange={this.handleChange} defaultValue={this.state.survey.projectNumber} />
                    <label>Site Name </label><input type="text" placeholder="Site Name" name="siteName" onChange={this.handleChange} defaultValue={this.state.survey.siteName} />
                    <label>Surveyor Name </label><input type="text" placeholder="Surveyor" name="surveyor" onChange={this.handleChange} defaultValue={this.state.survey.surveyor}/>
                    <label>Survey Date </label><input type="text" placeholder="Survey Date" name="surveyDate" onChange={this.handleChange} defaultValue={this.state.survey.surveyDate} />
                    <label>Start Time </label><input type="text" placeholder="Start Time" name="startTime" onChange={this.handleChange} defaultValue={this.state.survey.startTime} />
                    <label>Finish Time </label><input type="text" placeholder="Finish Time" name="finishTime" onChange={this.handleChange} defaultValue={this.state.survey.finishTime}/>
                </div>
                <div className="visit-form">
                    Weather Details
                    <label>Cloud Cover </label><input type="number" placeholder="Cloud cover (eigths)" name="cloudCover" onChange={this.handleChange} defaultValue={this.state.survey.cloudCover} />
                    <label>Temperature </label><input type="number" placeholder="Temp. (degrees Celsius)" name="temperature" onChange={this.handleChange} defaultValue={this.state.survey.temperature} />
                    <label>Wind Speed </label><input type="number" placeholder="Wind speed (Beaufort)" name="windSpeed" onChange={this.handleChange} defaultValue={this.state.survey.windSpeed}/>
                    <label>Wind Direction </label><input type="text" placeholder="Wind direction" name="windDirection" onChange={this.handleChange} defaultValue={this.state.survey.windDirectionType} />
                    <label>Preciptiation </label><input type="text" placeholder="Preciptation" name="precipitation" onChange={this.handleChange} defaultValue={this.state.survey.precipitation} />
                </div>
                <button type="submit">Save</button>
            </form>
                <button onClick={this.handleDelete}>Delete</button>
                <Bird bird={{}} onBirdCreate={this.props.onBirdCreate} onBirdUpdate={this.props.onBirdUpdate} survey={this.props.currSurvey}/>
            <BirdList birds={this.props.currBirds} onBirdDelete={this.props.onBirdDelete} onBirdUpdate={this.props.onBirdUpdate} onBirdCreate={this.props.onBirdCreate}/>
            <Map/>
            </div>
          )
    }
}

export default SurveyForm;
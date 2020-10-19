import React, {Component, Fragment} from 'react';

class Bird extends Component {
	constructor(props){
        super(props);
        this.state={
            bird:{}
        }
        this.handleChange=this.handleChange.bind(this);
		this.handleSubmit=this.handleSubmit.bind(this);
		this.handleDelete=this.handleDelete.bind(this);
    }
    // componentDidMount(){
    //     if(this.props.bird){
    //         this.setState({bird: this.props.bird});
    //     }
    // }
    handleChange(event){
        const propertyName= event.target.name;
        const bird = this.state.bird;
        bird[propertyName]= event.target.value;
        this.setState({bird:bird});
    }

    handleSubmit(event){
        event.preventDefault();
        if(this.props.bird.id){
			this.props.onBirdUpdate(this.state.bird);
			console.log(this.state.bird);
		}
			this.props.onBirdCreate({...this.state.bird,surveyVisit: this.props.survey,countBirds: parseInt(this.state.bird.countBirds),
				latitude: parseFloat(this.state.bird.latitude),longitude: parseFloat(this.state.bird.longitude)});
	}

	handleDelete(){
		this.props.onBirdDelete(this.state.bird);
	}
	
	render(){
		return (
		<Fragment>
    		<form className="bird-container" onSubmit={this.handleSubmit} >
                    <input type="text" placeholder="Species" name="species" onChange={this.handleChange} defaultValue={this.props.bird.species} />
                    <input type="number" placeholder="Count of Birds" name="countBirds" onChange={this.handleChange} defaultValue={this.props.bird.countBirds} />
                    <input type="text" placeholder="Gender" name="gender" onChange={this.handleChange} defaultValue={this.props.bird.gender}/>
                    <input type="text" placeholder="Age" name="ageClass" onChange={this.handleChange} defaultValue={this.props.bird.ageClass} />
                    <input type="text" placeholder="Activity" name="activity" onChange={this.handleChange} defaultValue={this.props.bird.activity} />
                    <input type="text" placeholder="Comments" name="comments" onChange={this.handleChange} defaultValue={this.props.bird.comments}/>
					<input type="number" step="any" placeholder="Latitude" name="latitude" onChange={this.handleChange} defaultValue={this.props.bird.latitude} />
                    <input type="number" step="any" placeholder="Longitude" name="longitude" onChange={this.handleChange} defaultValue={this.props.bird.longitude}/>
				<button type="submit">Save</button>
			</form>
			<button onClick={this.handleDelete}>Delete</button>
		</Fragment>
		)
	}
}
export default Bird;
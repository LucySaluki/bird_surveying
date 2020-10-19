import React, {Component, Fragment} from 'react';

class Bird extends Component {
	constructor(props){
        super(props);
        this.state={
			bird:{},
			valueGender:"Select a value",
			valueAge:"Select a value",
			valueActivity: "Select a value",

        }
        this.handleChange=this.handleChange.bind(this);
		this.handleSubmit=this.handleSubmit.bind(this);
		this.handleDelete=this.handleDelete.bind(this);
    }
    componentDidMount(){
        if(this.props.bird){
			this.setState({bird: this.props.bird});
			this.setState({valueGender:this.props.bird.gender});
			this.setState({valueAge:this.props.bird.ageClass});
			this.setState({valueActivity:this.props.bird.activity});
        } 
    }
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
		} else {
			this.props.onBirdCreate({...this.state.bird,surveyVisit: this.props.survey,countBirds: parseInt(this.state.bird.countBirds),
				latitude: parseFloat(this.state.bird.latitude),longitude: parseFloat(this.state.bird.longitude)});}
	}

	handleDelete(){
		this.props.onBirdDelete(this.state.bird);
	}
	
	render(){
		return (
		<Fragment>
    		<form className="bird-container" onSubmit={this.handleSubmit} >
                    <input type="text" placeholder="Species" name="species" onChange={this.handleChange}  defaultValue={this.state.bird.species}/>
                    <input type="number" placeholder="Count of Birds" name="countBirds" onChange={this.handleChange}  defaultValue={this.state.bird.countBirds}/>
                    <select name="gender" value={this.state.valueGender} onChange={this.handleChange} defaultValue={this.state.bird.gender}>
                        <option disabled value="Select a value">Select a value</option>
                        <option value="FEMALE">Female</option>
                        <option value="MALE">Male</option>
                        <option value="MIXED">Mixed</option>
                        <option value="UNKNOWN">Unknown</option>
                    </select>
					<select name="ageClass" value={this.state.valueAge} onChange={this.handleChange} defaultValue={this.state.bird.age}>
                        <option disabled value="Select a value">Select a value</option>
						<option value="EGG">Egg</option>
                        <option value="IMMATURE">Immature</option>
                        <option value="JUVENILE">Juvenile</option>
						<option value="FIRST_YEAR">First year</option>
                        <option value="SECOND_YEAR">Second year</option>
                        <option value="ADULT">Adult</option>
						<option value="MIXED">Mixed</option>
                        <option value="UNKNOWN">Unknown</option>
                    </select>
					<select name="activity" value={this.state.valueActivity} onChange={this.handleChange} defaultValue={this.state.bird.activity}>
                        <option disabled value="Select a value">Select a value</option>
						<option value="FLYING">Flying</option>
                        <option value="SUMMERING">Summering only</option>
                        <option value="SUITABLE_HABITAT">Adult in suitable habitat</option>
						<option value="SINGING">Singing adult</option>
                        <option value="PAIR">Pair</option>
                        <option value="DISPLAY">Courtship/Display</option>
						<option value="TERRITORY">Territory</option>
                        <option value="AGITATED">Agitated</option>
						<option value="VISIT_NEST">Visiting suspected nest</option>
                        <option value="BUILD_NEST">Nest building</option>
                        <option value="INCUBATING">Incubating adult</option>
						<option value="DISTRACTION">Distraction display</option>
                        <option value="USED_NEST">Used nest</option>
                        <option value="OCCUPIED_NEST">Occupied nest</option>
						<option value="NEST_EGGS">Nest with eggs</option>
                        <option value="FOOD_FECAL">Adult with food/fecal sac</option>
						<option value="NEST_YOUNG">Nest with young</option>
                        <option value="FLEDGED">Fledged young</option>
                    </select>
					<input type="text" placeholder="Comments" name="comments" onChange={this.handleChange} defaultValue={this.state.bird.comments}/>
					<input type="number" step="any" placeholder="Latitude" name="latitude" onChange={this.handleChange}  defaultValue={this.state.bird.latitude}/>
                    <input type="number" step="any" placeholder="Longitude" name="longitude" onChange={this.handleChange}  defaultValue={this.state.bird.longitude}/>
				<button type="submit">Save</button>
			</form>
			<button onClick={this.handleDelete}>Delete</button>
		</Fragment>
		)
	}
}
export default Bird;
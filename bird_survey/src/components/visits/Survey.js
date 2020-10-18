import React, {Fragment} from 'react';
import {Link} from 'react-router-dom';

const Survey = (props) => {

		return (
		<Fragment>
    		<Link to = {"/visits/"+ props.survey.id} className="visit">
    			{props.survey.siteName} {props.survey.surveyDate}
    		</Link>
    		<p>Surveyor: {props.survey.surveyor}</p>
    		<p>Start Time: {props.survey.startTime}</p>
			<p>Finish Time: {props.survey.finishTime}</p>
    	</Fragment>
		)
	}

export default Survey;
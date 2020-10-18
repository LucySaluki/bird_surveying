import React from 'react';
import Survey from './Survey.js';


const SurveyList = (props) => {
    const surveys = props.surveys.map((survey) => {
			return (<li key={survey.id} className="visit-item">
				<Survey survey={survey} />
			</li>
		)
		})

	return (
		<div className="visit-component">
			<ul className="visit-list">
				{surveys}
			</ul>
		</div>

	)
}
 export default SurveyList;
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
		<ul className="visit-list">
			{surveys}
		</ul>

	)
}
 export default SurveyList;
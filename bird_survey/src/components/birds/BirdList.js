import React from 'react';
import Bird from './Bird.js';


const BirdList = (props) => {
    if (!props.birds){
        return <p>Please create a survey visit before creating a bird record</p>
    }
    const birds = props.birds.map((bird) => {
		return (<li key={bird.id} className="bird-item">
			<Bird bird={bird} onBirdDelete={props.onBirdDelete} onBirdUpdate={props.onBirdUpdate}/>
		</li>
	)
	})

	return (
		<ul >
			{birds}
		</ul>

	)
}
 export default BirdList;
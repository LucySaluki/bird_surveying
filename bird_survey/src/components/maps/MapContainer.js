import React,{Component} from 'react';
import { Map, Marker, Popup, TileLayer } from 'react-leaflet';


class MapContainer extends Component {
  constructor(props){
    super(props);
    this.state={
      position: [57.647340946019085,-4.58778027095832],
    }

  }

    render(){
 
      const birdPoints = this.props.birds.map(bird =>{
        return <Marker key={bird.id} position={[bird.latitude,bird.longitude]}>
          <Popup >Species: {bird.species}<br />
                  Count:{bird.countBirds}<br />
                  Gender:{bird.gender.toLowerCase()}<br />
                  Age:{bird.ageClass.toLowerCase()}<br />
                  Activity:{bird.activity.toLowerCase()}<br />
          </Popup>
        </Marker>
      
        })
      return(
        <Map onClick={this.props.onNewMarker} center={this.state.position} zoom={12} >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution="&copy; <a href=&quot;http://osm.org/copyright&quot;>OpenStreetMap</a> contributors"
        />
         {birdPoints} 
      </Map>
      )
  }
}
export default MapContainer;
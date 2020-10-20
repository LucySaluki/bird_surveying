import React,{Component} from 'react';
// import 'leaflet/dist/leaflet.css';
import { Map, Marker, Popup, TileLayer } from 'react-leaflet';
// import L from 'leaflet';

class MapContainer extends Component {
  constructor(props){
    super(props);
    this.state={
      position: [57.647340946019085,-4.58778027095832],
      markers:[]
    }
    this.openPopup=this.openPopup.bind(this);
  }
  addMarker = (e) => {
    const {markers} = this.state
    markers.push(e.latlng)
    this.setState({markers});
    console.log(e.latlng);
  }

  openPopup(event){
    console.log(event.target);
    window.setTimeout(()=>{
    event.target.leafletElement.openPopup();
    })
  }
    render(){
  //     delete L.Icon.Default.prototype._getIconUrl;
  //     L.Icon.Default.mergeOptions({
  //     iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
  //     iconUrl: require('leaflet/dist/images/marker-icon.png'),
  //     shadowUrl: require('leaflet/dist/images/marker-shadow.png')
  // });
      // console.log("re-rendering");
      const birdPoints = this.props.birds.map(bird =>{
        return <Marker key={bird.id} position={[bird.latitude,bird.longitude]}>
          <Popup >A pretty CSS3 popup.<br />Easily customizable.</Popup>
        </Marker>
      
        })
      return(
        <Map onClick={this.addMarker} center={this.state.position} zoom={12} >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution="&copy; <a href=&quot;http://osm.org/copyright&quot;>OpenStreetMap</a> contributors"
        />
         {birdPoints} 
        {this.state.markers.map((position, idx) => 
          <Marker key={`marker-${idx}`} position={position}>
          <Popup>
            <span>A pretty CSS3 popup. <br/> Easily customizable.</span>
          </Popup>
         </Marker>
        )}
      </Map>
      )
  }
}
export default MapContainer;
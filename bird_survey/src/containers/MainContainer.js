import React, {Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import NavHeader from '../components/NavHeader.js';
import BirdSurveyContainer from './BirdSurveyContainer.js';

const MainContainer = () => {
    return (
      <Router>
      <Fragment>
      <NavHeader/>
        <Switch>
          <Route path="/visits" component={BirdSurveyContainer}/>
        </Switch>
      </Fragment>
      </Router>
    )
}

export default MainContainer;

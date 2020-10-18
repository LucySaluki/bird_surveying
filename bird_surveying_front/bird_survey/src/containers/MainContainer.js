import React, {Fragment} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import NavHeader from '../components/NavHeader.js';

const MainContainer = () => {
    return (
      <Router>
      <Fragment>
      <NavHeader/>

      </Fragment>
      </Router>
    )
}

export default MainContainer;

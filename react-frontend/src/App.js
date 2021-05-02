import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListTenantComponent from './components/ListTenantComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateTenantComponent from './components/CreateTenantComponent';
import UpdateTenantComponent from './components/UpdateTenantComponent';
import ViewTenantComponent from './components/ViewTenantComponent';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListTenantComponent}></Route>
                          <Route path = "/tenants" component = {ListTenantComponent}></Route>
                          <Route path = "/add-tenant/:id" component = {CreateTenantComponent}></Route>
                          <Route path = "/tenant-details/:id" component = {ViewTenantComponent}></Route>
                          {/* <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route> */}
                    </Switch>
                </div>
              {/* <FooterComponent /> */}
        </Router>
    </div>
    
  );
}

export default App;

import React, { Component } from 'react'

import {Route, Router, Redirect, Switch} from "react-router-dom";
import Index from './containers/Index/Index'
import Callback from './services/Callback/Callback';
import Home from './containers/Home/Home'
import Profile from "./containers/Profile/Profile";
import Shop from "./containers/Shop/Shop";
import Auth from './services/Auth/Auth';
import history from './history';
import Layout from './components/Common/Layout/Layout';

const auth = new Auth();

class App extends Component {
    constructor(props){
      super(props);

    this.state = {
        data : [],
        isLoading : false,
        error : null,
      };
  }

    handleAuthentication = (nextState, replace) => {
        if (/access_token|id_token|error/.test(nextState.location.hash)) {
            auth.handleAuthentication();
        }
    };


  render() {
    return (
        <Router history={history}>
            <Switch>
                <Layout auth={auth} history={history}>
                    <Route exact path="/callback" render={(props) => {
                        this.handleAuthentication(props);
                        return <Callback {...props} />
                    }}/>
                    <Route exact path="/home" render={(props) =>  !auth.isAuthenticated() ? (<Redirect to="/"/>) : (<Home auth={auth} {...props}/>)} />
                    <Route exact path="/shop" render={(props) => !auth.isAuthenticated() ? (<Redirect to="/"/>) : (<Shop auth={auth} {...props}/>)} />
                    <Route path='/myprofile' render={(props) => !auth.isAuthenticated() ? (<Redirect to="/"/>) : (<Profile auth={auth} {...props}/>)} />
                    <Route path="/" render={(props) => auth.isAuthenticated() ? null : <Index auth={auth} {...props}/> } />
                </Layout>
            </Switch>
        </Router>
    );
  }
}


export default App

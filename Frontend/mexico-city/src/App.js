import React, { Component, Fragment } from 'react'
import { Navbar, Button } from 'react-bootstrap'

import Auth from './services/Auth/Auth';
import {Route, Router} from "react-router-dom";
import history from "./history";
import Home from './containers/Home/Home'
import Callback from './services/Callback/Callback';
import Index from './containers/Index/Index';
import Profile from './containers/Profile/Profile';


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
    }

    goTo(route) {
        this.props.history.replace(`/${route}`)
    }

    login() {
        auth.login();
    }

    logout() {
        auth.logout();
    }


    componentDidMount() {
        const { renewSession } = auth;

        if (localStorage.getItem('isLoggedIn') === 'true') {
            renewSession();
        }
    }


  render() {
    const { isAuthenticated } = auth;
    return (

        <div>
            <Navbar fluid>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#">Auth0 - React</a>
                    </Navbar.Brand>
                <Button onClick={this.goTo.bind(this, 'home')}>Home</Button>
                {
                    !isAuthenticated() && (
                        <Button
                            bsStyle="primary"
                            className="btn-margin"
                            onClick={this.login.bind(this)}
                        >
                            Log In
                        </Button>
                    )
                }
                {
                    isAuthenticated() && (
                        <Button
                            bsStyle="primary"
                            className="btn-margin"
                            onClick={this.logout.bind(this)}
                        >
                            Log Out
                        </Button>
                    )
                }

                    <Router history={history} component={App}>
                        <Fragment>
                            <Route path="/" compoent={<Home/>} />
                            <Route path="/home" render={(props) => <Index auth={auth} {...props} />} />
                            <Route path="/myprofile" render={(props) => <Profile auth={auth} {...props} />} />
                            <Route path="/callback" render={(props) => {
                                this.handleAuthentication(props);
                                return <Callback {...props} />
                            }}/>
                        </Fragment>
                    </Router>
                </Navbar.Header>
            </Navbar>
        </div>
    );
  }
}


{/*<Router>*/}
    {/*<Fragment>*/}
        {/*/!*<Route exact path="/" render={() => <Index userLogin={this.setUser} requireAuth={this.requireAuth}/>} />*!/*/}
        {/*/!*<Route exact path="/home" render={()=><Home user={user}/>}/>*!/*/}
    {/*</Fragment>*/}
{/*</Router>*/}

export default App

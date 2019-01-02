import React, { Component, Fragment } from 'react'
import {BrowserRouter as Router, Route} from 'react-router-dom'

import Home from './containers/Home/Home'
import Index from './containers/Index/Index'


class App extends Component {
    constructor(props){
      super(props);

    this.state = {
        data : [],
        isLoading : false,
        error : null,
        user : []
      };
  }

    goTo(route) {
        this.props.history.replace(`/${route}`)
    }

    login() {
        this.props.auth.login();
    }

    logout() {
        this.props.auth.logout();
    }

    componentDidMount() {
        const { renewSession } = this.props.auth;

        if (localStorage.getItem('isLoggedIn') === 'true') {
            renewSession();
        }
    }


  render() {
    let [user] = [this.state.user];
    let { isAuthenticated } = this.props.auth;

    return (
      <div>
          <Router>
            <Fragment>
              {/*<Route exact path="/" render={() => <Index userLogin={this.setUser} requireAuth={this.requireAuth}/>} />*/}
              {/*<Route exact path="/home" render={()=><Home user={user}/>}/>*/}
                <button onClick={this.goTo.bind(this, 'home')}>Home</button>
                {
                    !isAuthenticated() && (
                        <button
                            bsStyle="primary"
                            className="btn-margin"
                            onClick={this.login.bind(this)}
                        >
                            Log In
                        </button>
                    )
                }
                {
                    isAuthenticated() && (
                        <button
                            bsStyle="primary"
                            className="btn-margin"
                            onClick={this.logout.bind(this)}
                        >
                            Log Out
                        </button>
                    )
                }
            </Fragment>
          </Router>
      </div>
    );
  }
}



export default App

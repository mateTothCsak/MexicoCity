import React, { Component, Fragment } from 'react'
import {BrowserRouter as Router, Route} from 'react-router-dom'


import MyMainPage from './containers/MyMainPage/MyMainPage'
import Home from './containers/Home/Home'

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

  requireAuth=(nextState, replace)=>{
    let [user] = [this.state.user]
    if(user){
      // history.push('/home')
      // replace({
      //   pathname : '/home',
      //   state: { nextPathname: nextState.location.pathname }
      // })
    }
  }

  getUser=()=>{
    localStorage.getItem('user')
  }

  setUser=(user)=>{
    localStorage.setItem('user', user)
  }

  render() {
    let [user] = [this.state.user];

    return (
      <div>
          <Router>
            <Fragment>
              <Route exact path="/" render={() => <MyMainPage userLogin={this.setUser} requireAuth={this.requireAuth}/>} />
              <Route exact path="/home" render={()=><Home user={user}/>}/>
            </Fragment>
          </Router>
      </div>
    );
  }
}

// <Route path="protectedRoute" render={()=><Home user={user}/>} onEnter={this.requireAuth} />
export default App

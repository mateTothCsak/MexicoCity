import React, { Component, Fragment } from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';



import MyMainPage from './containers/MyMainPage/MyMainPage';
import Home from './containers/Home/Home';


// const HOME = 'http://localhost:8080/home';

class App extends Component {
    constructor(props){
      super(props);

    this.state = {
        data : [],
        user: [],
        isLoading : false,
        error : null,
      };
  }
  

  componentDidMount(){

    // fetch(HOME,{method: "GET"}, {mode: 'no-cors'})
    //   .then(response => {
    //     if(response.ok){
    //       return response.json();
    //     } else {
    //       throw new Error('Something went wrong...');
    //     }
    //   })
    //   .then(data => this.setState({ data , isLoading : false}))
    //   .catch(error => this.setState({error, isLoading: false}));
  }




  render() {
    let [ user] = [this.state.user];

    return (
      <div>
          <Router>
            <Fragment>
              <Route exact path="/" render={() => <MyMainPage/>} />
              <Route exact path="/home" render={() => <Home user={user}/>} />
            </Fragment>
          </Router>
      </div>
    );
  }
}

export default App;

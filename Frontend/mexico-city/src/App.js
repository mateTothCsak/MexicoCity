import React, { Component } from 'react';

import Layout from './components/Layout/Layout';
import MyMainPage from './containers/MyMainPage/MyMainPage';

const HOME = 'http://localhost:8080/home';

class App extends Component {
    constructor(props){
      super(props);

    this.state = {
        data: [],
        isLoading : false,
        error : null,
      };
  }
  

  componentDidMount(){
    // this.state({"isLoading" : true})

    fetch(HOME,{
      method: "GET",
    })
      .then(response => {
        if(response.ok){
          return response.json();
        } else {
          throw new Error('Something went wrong...');
        }
      })
      .then(data => this.setState({ data , isLoading : false}))
      .catch(error => this.setState({error, isLoading: false}));
  }


  render() {
    let [ data, loading, error ] = [this.state.data, this.state.isLoading, this.state.error];

    return (
      <div>
        <Layout>  
          <MyMainPage allData={data} loading={loading} error={error}/>
        </Layout> 
      </div>
    );
  }
}

export default App;

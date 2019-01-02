import React, {Component, Fragment} from 'react'

import Layout from '../../components/Layout/Layout'
import Rooster from '../../components/Rooster/Rooster'


const HOME = 'http://localhost:8080/home'

class Home extends Component {
    constructor(props){
        super(props);
        this.state = {
            data: [],
            isLoading : false,
            error : null,
          };
    }
    
    componentDidMount(){
    
    fetch(HOME,
        {method: "GET"})
        .then(response => {
          if(response.ok){
            return response.json();
          } else {
            throw new Error('Something went wrong...')
          }
        })
        .then(data => this.setState({ data , isLoading : false}))
        .catch(error => this.setState({error, isLoading: false}))
    }

    render() { 
        return (
            <Fragment>
                <Layout>
                <h2 style={{color : "white"}}>Top Roosters</h2>

                    {this.state.data.map(d => (
                        <Rooster
                        key={d.id} 
                        id={d.id} 
                        experience={d.experience}
                        level={d.level}
                        gold={d.gold}
                        wonMatches={d.wonMatches}
                        lostMatches={d.lostMatches}
                        image={d.image}/>)
                    )}

                </Layout>
            </Fragment>
        );
    }
}

 
export default Home
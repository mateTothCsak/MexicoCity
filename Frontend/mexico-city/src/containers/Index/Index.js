import React, {Component, Fragment} from 'react'

import Layout from '../../components/Common/Layout/Layout'
import Rooster from '../../components/Home/Rooster/Rooster'


const Index = 'http://localhost:8080/home';

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
    
    fetch(Index,
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
        let roosters =  this.state.data.map(d => (
                            <Rooster
                                key={d.id}
                                id={d.id}
                                experience={d.experience}
                                level={d.level}
                                gold={d.gold}
                                wonMatches={d.wonMatches}
                                lostMatches={d.lostMatches}
                                image={d.image}/>)
                        );

        return (
            <Fragment>
                <Layout>
                <h2 style={{color : "white"}}>Top Roosters</h2>
                    {roosters}
                </Layout>
            </Fragment>
        );
    }
}

 
export default Home
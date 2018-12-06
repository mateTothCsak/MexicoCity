import React, {Component} from 'react'

import Aux from '../../hoc/Aux'
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
    
    fetch(HOME,{
        method: "GET",
      })
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
        let transformedRooster = Object.keys(this.state.data)
                                    .map(d => {
                                            return <Rooster 
                                                        key={d.id} 
                                                        id={d.id} 
                                                        experience={d.experience}
                                                        level={d.level}
                                                        gold={d.gold}
                                                        roosterItems={d.roosterItems}
                                                        wonMatches={d.wonMatches}
                                                        lostMatches={d.lostMatches}
                                                        image={d.image}/>
                                        })

        return (
            <Aux>
                <Layout>
                    {transformedRooster}
                </Layout>
            </Aux>
        );
    }
}


// {this.state.data.map(d => (   <div style={{color : "white"}} key={d.id}> {d.id}</div>
// <img src={"../../assets/images/"+d.image} alt={d.id} height="150" width="100"/>

 
export default Home
import React, {Component, Fragment} from 'react'

import Rooster from '../../components/Home/Rooster/Rooster'
import UserProfile from "../../services/UserProfile/UserProfile";
import axios from 'axios';


class Home extends Component {
    constructor(props){
        super(props);
        this.state = {
            data: [],
            error : null,
          };
    }
    
    componentDidMount(){
        const { getAccessToken } = this.props.auth;
        const API_URL = 'http://localhost:8080/home';
        const headers = { 'Authorization': `Bearer ${getAccessToken()}`};

        axios.get(API_URL, { headers })
            .then(response => this.setState({ data: response.data }))
            .catch(error => this.setState({ error: error }));
    }

    render() {
        let roosters =  this.state.data.map(d => (
                            <Rooster
                                key={d.rooster.id}
                                name={d.name}
                                id={d.rooster.id}
                                experience={d.rooster.experience}
                                level={d.rooster.level}
                                gold={d.rooster.gold}
                                wonMatches={d.rooster.wonMatches}
                                lostMatches={d.rooster.lostMatches}
                                image={d.rooster.image}/>)
                        );

        return (
            <Fragment>
                    <UserProfile auth={this.props.auth} shortShow={true}/>
                    <h3 style={{color : "white"}}>Top Roosters</h3>
                    {roosters}
            </Fragment>
        );
    }
}

 
export default Home
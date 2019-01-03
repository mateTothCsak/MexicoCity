import React, {Component, Fragment} from 'react'

import Layout from '../../components/Common/Layout/Layout'
import Rooster from '../../components/Home/Rooster/Rooster'
import UserProfile from "../../services/UserProfile/UserProfile";
import axios from 'axios';


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
                <Layout auth={this.props.auth}>
                    <UserProfile auth={this.props.auth}/>
                    <h2 style={{color : "white"}}>Top Roosters</h2>
                    {roosters}
                </Layout>
            </Fragment>
        );
    }
}

 
export default Home
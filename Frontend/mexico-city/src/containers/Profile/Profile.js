import React, {Component, Fragment} from 'react'

import Layout from '../../components/Common/Layout/Layout'
import UserProfile from "../Home/Home";
import axios from "axios";



class Profile extends Component {
    constructor(props){
        super(props);
        this.state = {
            data: [],
            error : null,
        };
    }

    componentDidMount(){
        const { getAccessToken } = this.props.auth;
        const API_URL = 'http://localhost:8080/myprofile?id=1';
        const headers = { 'Authorization': `Bearer ${getAccessToken()}`};

        axios.get(API_URL, {headers})
            .then(response => this.setState({ data: response.data }))
            .catch(error => this.setState({ error: error }));

    }

    render() {

        return (
            <Fragment>
                <Layout auth={this.props.auth} history={this.props.history}>
                    <UserProfile auth={this.props.auth}/>
                    MyProfile
                </Layout>
            </Fragment>
        );
    }
}


export default Profile
import React, { Component, Fragment } from 'react';

import ProfileStats from "../../components/Profile/ProfileDetails/ProfileDetails";
import UserProfile from "../Home/Home";
import axios from "axios";


class Profile extends Component {
    constructor(props){
        super(props);
        this.state = {
            id : null,
            data: [],
            error : null,
        };
    }

    componentDidMount(){
        const { getAccessToken } = this.props.auth;
        const API_URL = 'http://localhost:8080/myprofile?id=2';
        // this.props.location.search
        const headers = { 'Authorization': `Bearer ${getAccessToken()}`};

        axios.get(API_URL, {headers})
            .then(response => this.setState({ data: response.data }))
            .catch(error => this.setState({ error: error }));

    }


    render() {
        let d = this.state.data;

        return (
            <Fragment>
                <UserProfile auth={this.props.auth}/>
                <h2>My Rooster</h2>
                {d.rooster ? <ProfileStats name={d.name} rooster={d.rooster}/> : "Loading"}
            </Fragment>
        );
    }
}


export default Profile
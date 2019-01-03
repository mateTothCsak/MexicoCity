import React, { Component, Fragment } from 'react';

import ProfileStats from "../../components/Profile/ProfileDetails/ProfileDetails";
import Layout from "../../components/Common/Layout/Layout";

const Index = 'http://localhost:8080/myprofile';

class Profile extends Component {
    constructor(props){
        super(props);
        this.state = {
            data: [],
            isLoading : false,
            error : null,
        };
    }

    componentDidMount(){

        fetch(Index + this.props.location.search,
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
        console.log(Index + this.props.location.search);
        let d = this.state.data;
        console.log(d);

        return (
            <Fragment>
                <Layout>
                    <h2>My Rooster</h2>
                    {d.rooster ? <ProfileStats name={d.name} rooster={d.rooster}/> : "Loading"}
                </Layout>
            </Fragment>
        );
    }
}


export default Profile


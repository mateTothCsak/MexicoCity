import React, {Component, Fragment} from 'react'

import Layout from '../../components/Common/Layout/Layout'
import UserProfile from "../Home/Home";


const ProfileRoute = 'http://localhost:8080/myprofile';

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

        fetch(ProfileRoute,
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
                <Layout auth={this.props.auth}>
                    <UserProfile auth={this.props.auth}/>
                    Logged In user
                </Layout>
            </Fragment>
        );
    }
}


export default Profile
import React, { Component } from 'react';
// import axios from 'axios';

import Aux from '../../hoc/Aux'
import Jumbotron from '../../components/Jumbotron/Jumbotron';
import InfoBox1 from '../../components/InfoBox/InfoBox1/InfoBox1';
import InfoBox2 from '../../components/InfoBox/InfoBox2/InfoBox2';
import Modal from '../../components/UI/Modal/Modal';
import Layout from '../../components/Layout/Layout';

const REGISTRATION_ROUTE = "http://localhost:8080/register";

class MyMainPage extends Component {
    constructor(props){
        super(props);
        this.state = {
            data: [],
            isLoading : false,
            displayModal : false,
            userLoggedIn : false,
            password : '',
            confirmedPassword: '',
            email : '',
            error : null,
          };
    }

    displayModal = () =>{
        this.setState({displayModal: true})
    }
   
    closeModal=()=>{
        this.setState({displayModal: false})
    }


    // sendRegistrationInfo=(regInfo)=>{
    //     axios.post(REGISTRATION_ROUTE, regInfo)
    //         .then(function(response){
    //         console.log(response);
    //         //Perform action based on response
    //     })
    //     .catch(function(error){
    //     console.log(error);
    //     //Perform action based on error
    //     });
    // }
        
    // sendRegistrationInfo=(regInfo)=> {
    //     fetch('https://api.github.com/gists', {
    //       method: 'post',
    //       body: JSON.stringify(opts)
    //     }).then(function(response) {
    //       return response.json();
    //     }).then(function(data) {
    //       ChromeSamples.log('Created Gist:', data.html_url);
    //     });
    //   }

    sendRegistrationInfo=(regInfo)=>{
        fetch(REGISTRATION_ROUTE,
                {method: "post"}, 
                {mode: 'no-cors'},
                {body : regInfo})
        .then(response => {
            if(response.ok){
            return response.json()
            } else {
            throw new Error('Something went wrong...');
            }
        })
        .then(data => this.setState({ data , isLoading : false}))
        .catch(error => this.setState({error, isLoading: false}));
    }

    // user logged in ? state.field

    render() { 
        let [displayModal, email, password] = [this.state.displayModal, this.state.email, this.state.password];

        return (     
            <Aux>
                <Layout displayModal={this.displayModal}>
                    <Modal 
                        show={displayModal} 
                        modalClosed={this.closeModal}
                        sendRegistrationInfo={this.sendRegistrationInfo}
                        >
                    </Modal>
                    
                    <div style={{ color : "white"}}>{email} {password}</div>
                    <Jumbotron/>
                    <InfoBox1></InfoBox1>
                    <InfoBox2></InfoBox2>
                </Layout>
            </Aux>
          );
    }
}
 
export default MyMainPage;

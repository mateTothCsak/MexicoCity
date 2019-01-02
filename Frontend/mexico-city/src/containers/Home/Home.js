import React, { Component, Fragment } from 'react'
import axios from 'axios'

import Layout from '../../components/Common/Layout/Layout'
import Jumbotron from '../../components/Index/Jumbotron/Jumbotron'
import InfoBox1 from '../../components/Index/InfoBox/InfoBox1/InfoBox1'
import InfoBox2 from '../../components/Index/InfoBox/InfoBox2/InfoBox2'

import RegistrationModal from '../../components/Common/UI/Modal/RegistrationModal'
import LoginModal from '../../components/Common/UI/Modal/LoginModal'


class Home extends Component {
    constructor(props){
        super(props)
        this.state = {
            data: [],
            isLoading : false,
            displayRegModal : false,
            displayLogModal : false,

            successfulLogin : false,
            successfulRegistration : false,

            password : '',
            confirmedPassword: '',
            email : '',
            error : null,
          }
    }

    displayRegModal = () =>{
        this.setState({displayRegModal: true})
    }
   
    closeRegModal=()=>{
        this.setState({displayRegModal: false})
    }

    displayLogModal = () =>{
        this.setState({displayLogModal: true})
    }
   
    closeLogModal=()=>{
        this.setState({displayLogModal: false})
    }

    registrationSuccessful=()=>{
        this.setState({ successfulRegistration : true })
    }

    registrationNotSuccessful=()=>{
        this.setState({ successfulRegistration : false })
    }

    loginSuccessful=()=>{
        this.setState({ successfulLogin:  true})
        this.props.userLogin()
        // this.props.requireAuth()
    }

    loginNotSuccessful=()=>{
        this.setState({ successfulLogin:  false})
    }

    sendSubmitednInfo=(regInfo, route)=>{
        axios.post(route, regInfo)
            .then(function(response){
            console.log(response);
        }).then(data=> this.setState({data}))
        .catch(function(error){
        console.log(error)
        })
    }


    render() { 
        let [displayRegModal, displayLogModal, succReg] = [this.state.displayRegModal, this.state.displayLogModal, this.state.successFulRegistration]
        let successReg = ''

        if(succReg){
            successReg = "Your registration was successful. It's time to log in now. "
        }

        return (     
            <Fragment>
                <Layout

                    displayRegModal={this.displayRegModal} 
                    displayLogModal={this.displayLogModal}>
                    <RegistrationModal 
                        show={displayRegModal} 
                        modalClosed={this.closeRegModal}
                        sendRegInfo={this.sendSubmitednInfo}
                        registrationSuccessful={this.registrationSuccessful}
                    />
                    <LoginModal
                        show={displayLogModal} 
                        modalClosed={this.closeLogModal}
                        sendLogInfo={this.sendSubmitednInfo}
                        loginSuccessful={this.loginSuccessful}
                    />

                    <p style={{color: "green"}}>{successReg}</p>
                    <Jumbotron/>
                    <InfoBox1></InfoBox1>
                    <InfoBox2></InfoBox2>
                </Layout>
            </Fragment>
          )
    }
}

 
export default Home
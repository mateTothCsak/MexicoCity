import React, { Component, Fragment } from 'react'

import classes from './Modal.css'
import Backdrop from '../Backdrop/Backdrop'
import InputField from '../InputField/InputField'


const REGISTRATION_ROUTE = "http://localhost:8080/register"

class RegistrationModal extends Component {

    constructor(props){
        super(props);
        this.state = {
            isLoading : false,
            displayRegModal : false,

            email : '',
            password : '', 
            confirmedPassword : '',
            error : null,
          }
    }

    displayRegModal = () =>{
        this.setState({displayRegModal: true})
    }
   
    closeRegModal=()=>{
        this.setState({displayRegModal: false})
    }
       
    //TODO: implement valid registration (does not exist in database)
    verifyRegistartionInfo=(email, password)=>{
        this.setState({email: email, password : password})
        // let regInfo ={
        //     "email" : email,
        //     "password" : password
        // }

        return true;
    }


    handleRegSubmit=(event)=>{
        event.preventDefault()

        let [email, password, confirmedPassword] = [this.state.email, this.state.password, this.state.confirmedPassword]

        if(!email){
            return this.setState({error : "Please enter your email address"})
        }
        if(!password){
            return this.setState({error : "Please enter your password"})
        }
        if(password !== confirmedPassword){
            return this.setState({error: "Passwords should match"})
        }
        let isVerified = this.verifyRegistartionInfo(email, password)
        if(isVerified){
            let regInfo ={
                "email" : email,
                "password" : password
            }
            this.props.sendRegInfo(regInfo, REGISTRATION_ROUTE)
            this.props.modalClosed()
            this.props.registrationSuccessful()
            this.setState({ error: '' })
        }
    }


    handleEmailChange=(event)=>{
        this.setState({email: event.target.value})
    }

    handlePassChange=(event)=>{
        this.setState({password: event.target.value})
    }

    handleConfPassChange=(event)=>{
        this.setState({confirmedPassword: event.target.value})
    }

    render() { 
        let [error] = [this.state.error]
        let showError;

        if(error){
            showError = error
        }
        
        return (   
            <Fragment>
                <Backdrop show={this.props.show} clicked={this.props.modalClosed}/>
                <div 
                    className={classes.Modal}
                    style={{transform : this.props.show ? 'translateY(0)' : 'translateY(-100vh)',
                    opacity : this.props.show ? '1' : '0'
                    }}>
                    <form onSubmit={this.handleRegSubmit}>
                        <label>Registration</label>
                        <InputField label="Email" type="text" changing={this.handleEmailChange}/>
                        <InputField label="Password" type="password" changing={this.handlePassChange}/>
                        <InputField label="Confirm Password" type="password" changing={this.handleConfPassChange}/>
                        <input type="submit" value="Register"/>
                        {showError}
                    </form>
                </div>
            </Fragment>
          );
    }
}

export default RegistrationModal
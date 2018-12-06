import React, { Component } from 'react';
import axios from 'axios';

import classes from './Modal.css';
import Aux from '../../../hoc/Aux';
import Backdrop from '../Backdrop/Backdrop';
import InputField from '../InputField/InputField';

// classbased component
// form field compones 

const REGISTRATION_ROUTE = "http://localhost:8080/register";

class Modal extends Component {

    constructor(props){
        super(props);
        this.state = {
            isLoading : false,
            displayModal : false,

            email : '',
            password : '', 
            confirmedPassword : '',
            error : null,
          };
    }

    displayModal = () =>{
        this.setState({displayModal: true})
    }
   
    closeModal=()=>{
        this.setState({displayModal: false})
    }
       
    verifyRegistartionInfo=(email, password)=>{
        this.setState({email: email, password : password})
        let regInfo ={
            "email" : email,
            "password" : password
        }

        this.sendRegistrationInfo(regInfo)
    }

    sendRegistrationInfo=(regInfo)=>{
        axios.post(REGISTRATION_ROUTE, regInfo)
            .then(function(response){
            console.log(response);
            return true;
        })
        .catch(function(error){
        console.log(error);
        //Perform action based on error
        });
    }

    handleMySubmit=(event)=>{
        event.preventDefault()

        let [email, password, confirmedPassword] = [this.state.email, this.state.password, this.state.confirmedPassword]

        if(!email){
            return this.setState({error : "Please enter your email address"})
        }
        if(!password){
            return this.setState({error : "Please enter your password"})
        }
        if(password !== confirmedPassword){
            console.log("something went wrong")
            return this.setState({error: "Passwords should match"})
        }

        let isRegVerified = this.verifyRegistartionInfo(email, password)
        if(isRegVerified){
            let regInfo ={
                "email" : email,
                "password" : password
            }
            this.props.sendRegistrationInfo(regInfo)
            this.props.modalClosed()
            return this.setState({ error: '' });
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
            showError = error;
        }
        
        return (   
            <Aux>
            <Backdrop show={this.props.show} clicked={this.props.modalClosed}/>
            <div 
                className={classes.Modal}
                style={{transform : this.props.show ? 'translateY(0)' : 'translateY(-100vh)',
                opacity : this.props.show ? '1' : '0'
                }}>
                <form onSubmit={this.handleMySubmit}>
                    <label>Registration</label>
                    <InputField label="Email" type="text" changing={this.handleEmailChange}/>
                    <InputField label="Password" type="password" changing={this.handlePassChange}/>
                    <InputField label="Password" type="password" changing={this.handleConfPassChange}/>
                    <input type="submit" value="Register"/>
                    {showError}
                </form>
            </div>
        </Aux>
          );
    }
}

export default Modal
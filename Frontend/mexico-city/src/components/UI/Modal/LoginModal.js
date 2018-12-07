import React, { Component, Fragment } from 'react'

import classes from './Modal.css'
import Backdrop from '../Backdrop/Backdrop'
import InputField from '../InputField/InputField'

const LOGIN_ROUTE = "http://localhost:8080/login"

class LoginModal extends Component {

    constructor(props){
        super(props);
        this.state = {
            isLoading : false,
            displayLogModal : false,

            email : '',
            password : '', 
            error : null,
          };
    }

    displayLogModal = () =>{
        this.setState({displayLogModal: true})
    }
   
    closeLogModal=()=>{
        this.setState({displayLogModal: false})
    }
       
    //TODO: implement valid login (does not exist in database)
    verifyRegistartionInfo=(email, password)=>{
        this.setState({email: email, password : password})
        // let regInfo ={
        //     "email" : email,
        //     "password" : password
        // }
        // if(Response.ok){
        return true;
        // } else{
        //     this.setState({error: "Password or email not correct"})
        // }
    }

    handleLogSubmit=(event)=>{
        event.preventDefault()

        let [email, password] = [this.state.email, this.state.password]

        if(!email){
            return this.setState({error : "Please enter your email address"})
        }
        if(!password){
            return this.setState({error : "Please enter your password"})
        }

        let isLogVerified = this.verifyRegistartionInfo(email, password)
        if(isLogVerified){
            let regInfo ={
                "email" : email,
                "password" : password
            }

            this.props.sendLogInfo(regInfo, LOGIN_ROUTE)
            this.props.modalClosed()
            this.props.loginSuccessful()
            this.setState({ error: '' })
            
        }
    }


    handleEmailChange=(event)=>{
        this.setState({email: event.target.value})
    }

    handlePassChange=(event)=>{
        this.setState({password: event.target.value})
    }


    render() { 
        let [error] = [this.state.error]
        // let showError;

        if(error){
            return this.setState({error : "Please enter your email address"})
        }
        
        return (   
            <Fragment>
                <Backdrop show={this.props.show} clicked={this.props.modalClosed}/>
                <div 
                    className={classes.Modal}
                    style={{transform : this.props.show ? 'translateY(0)' : 'translateY(-100vh)',
                    opacity : this.props.show ? '1' : '0'
                    }}>
                    <form onSubmit={this.handleLogSubmit}>
                        <label>Login</label>
                        <InputField label="Email" type="text" changing={this.handleEmailChange}/>
                        <InputField label="Password" type="password" changing={this.handlePassChange}/>
                        <input type="submit" value="Login"/>
                        {error}
                    </form>
                </div>
            </Fragment>
          );
    }
}

export default LoginModal
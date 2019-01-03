import React,{Component, Fragment} from 'react'

import classes from './NavigationItems.css'
import NavigationItem from './NavigationItem/NavigationItem'


class NavigationItems extends Component {

    login=()=>{
        this.props.auth.login();
    };


    logout=()=>{
        this.props.auth.logout()
    };


    componentDidMount() {
        const { renewSession } = this.props.auth;

        if (localStorage.getItem('isLoggedIn') === 'true') {
            renewSession();
        }
    }


    render() {
        const {isAuthenticated} = this.props.auth;
        let button = "";
        if(!isAuthenticated()){
            button = <li onClick={this.login}><NavigationItem>Login</NavigationItem></li>;
        } else{
            button = <li onClick={this.logout}><NavigationItem>Logout</NavigationItem></li>;
        }


        return (
            <ul className={classes.NavigationItems}>
                {
                    isAuthenticated() && (
                        <Fragment>
                            <li><NavigationItem link={"/myprofile"}>MyProfile</NavigationItem></li>
                            <li><NavigationItem link={"/shop"}>Shop</NavigationItem></li>
                        </Fragment>
                    )
                }
                {button}
            </ul>
        )
    }
}


export default NavigationItems

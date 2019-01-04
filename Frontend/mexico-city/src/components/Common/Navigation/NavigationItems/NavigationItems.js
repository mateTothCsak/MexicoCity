import React,{Component, Fragment} from 'react'

import classes from './NavigationItems.css'
import NavigationItem from './NavigationItem/NavigationItem'


class NavigationItems extends Component {

    goTo=(route)=> {
        this.props.history.replace(`/${route}`)
    };

    replace=(route)=>{
        this.props.history.replace(`/${route}`)
    }


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
                            <li onClick={()=>this.replace('myprofile')}><NavigationItem>MyProfile</NavigationItem></li>
                            <li onClick={()=>this.replace('shop')}><NavigationItem>Shop</NavigationItem></li>
                        </Fragment>
                    )
                }
                {button}
            </ul>
        )
    }
}


export default NavigationItems

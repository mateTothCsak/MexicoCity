import React,{Component, Fragment} from 'react'
import { Link } from 'react-router-dom';


import classes from './NavigationItems.css'
import NavigationItem from './NavigationItem/NavigationItem'


class NavigationItems extends Component {

    goTo=(route)=> {
        this.props.history.replace(`/${route}`)
    };

    push=(route)=>{
        // this.props.history.replace(`/${route}`)
        this.props.history.push(`/${route}`)
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
                            <li onClick={()=>this.push('myprofile?id=1')}><NavigationItem>MyProfile</NavigationItem></li>
                            {/*<li><NavigationItem>Shop</NavigationItem></li>*/}
                            {/*<Link*/}
                                {/*exact*/}
                                {/*to={{pathname: '/myprofile?id=2'}}>*/}
                                {/*MyProfile*/}
                            {/*</Link>*/}

                        </Fragment>
                    )
                }
                {button}
            </ul>
        )
    }
}


export default NavigationItems

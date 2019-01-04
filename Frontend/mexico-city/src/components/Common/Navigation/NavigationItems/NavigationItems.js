import React from 'react'

import classes from './NavigationItems.css'
import NavigationItem from './NavigationItem/NavigationItem'

const navigationItems = (props) => ( 
    <ul className={classes.NavigationItems}>

        <NavigationItem><button onClick={props.displayLogModal}>Login</button></NavigationItem>
        <NavigationItem><button onClick={props.displayRegModal}>Registration</button></NavigationItem>
    </ul>   
);


export default navigationItems

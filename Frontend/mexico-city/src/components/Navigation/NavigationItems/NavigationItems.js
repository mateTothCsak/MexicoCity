import React from 'react';

import classes from './NavigationItems.css';
import NavigationItem from './NavigationItem/NavigationItem';

const navigationItems = (props) => ( 
    <ul className={classes.NavigationItems}>

        <NavigationItem><button onClick={props.displayModal}>Login</button></NavigationItem>
        <NavigationItem><button onClick={props.displayModal}>Registration</button></NavigationItem>
    </ul>   
);

// <NavigationItem link="/home" clicked={props.displayModal}>Registration</NavigationItem>

export default navigationItems;

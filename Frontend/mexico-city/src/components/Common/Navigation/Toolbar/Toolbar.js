import React from 'react';

import classes from './Toolbar.css';
import Logo from '../../Logo/Logo'
import NavigationItems from '../NavigationItems/NavigationItems';


const toolbar = (props) => (
    <header className={classes.Toolbar}>
        <div className={classes.Logo} >
            <a href="/">
                <Logo/>
            </a>
        </div>
        <nav>
            <NavigationItems displayRegModal={props.displayRegModal} displayLogModal={props.displayLogModal}/>
        </nav>
    </header>
)
 
export default toolbar;

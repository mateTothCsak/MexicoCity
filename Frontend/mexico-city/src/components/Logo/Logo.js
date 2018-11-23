import React from 'react';

import mexCityLogo from '../../assets/images/mexico-city-logo-1.png';
import classes from './Logo.css';


const logo = (props) => (  
    <div className={classes.Logo} style={{height: props.height}}>
        <img src={mexCityLogo} alt="MexicoCity"></img>    
    </div>
);

 
export default logo;
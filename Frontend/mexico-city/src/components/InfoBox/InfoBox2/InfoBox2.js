import React from 'react';

import classes from './InfoBox2.css';
import Bag from '../../../assets/images/anywhere.png';


const infoBox2 = () =>(
    <div className={classes.Container}>
        <div className={[classes.InfoBox, classes.LeftContent].join(' ')}> 
            <img src={Bag} height="200" alt="MexicoLearn"></img>
        </div>
        <div className={classes.RightContent}>
            <h2>Learn anytime, anywhere.</h2>
            <p>Commutes more productive with our Mobile App.</p>
            <p>Download them and see it got the highest accolades.</p>
        </div>
        
    </div>

);
 
export default infoBox2;
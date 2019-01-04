import React from 'react';

import classes from './InfoBox1.css';
import Timer from "../../../../assets/images/timer.png";



const infoBox1 = () =>(
    <div className={classes.Container}>
        <div className={[classes.InfoBox, classes.LeftContent].join(' ')}> 
            <h2>The best new way to learn math</h2>
            <p>Learning with MexicoCity is fun and addictive.</p>
            <p>Earn points for correct answers, race against your friends while the clock is ticking.</p>
            <p>Our bite-sized lessons are effective, and we have proof that it works.</p>
        </div>
        <div className={classes.RightContent}>
            <img src={Timer} alt="GoodToLearn"/>
        </div>
    </div>

);
 
export default infoBox1;
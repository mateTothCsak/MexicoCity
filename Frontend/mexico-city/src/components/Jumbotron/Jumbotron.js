import React from 'react';

import roosterCartoon from '../../assets/images/pipi5.png';
import classes from './Jumbotron.css';
import Button from '../UI/Button/Button';


const jumbotron = () => (
    <div className={classes.Jumbotron}>
        <div className={classes.leftContent}><img src={roosterCartoon} alt="MexicoCity"></img></div>
        <div className={classes.rightContent}>
            <h4>Become a math genius in a day</h4>
            <Button className={[classes.Button, ]}>Play Now</Button>
        </div>
        
        
    </div>
  );
 


export default jumbotron;
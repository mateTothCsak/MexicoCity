import React from 'react'

import classes from './Rooster.css'

const rooster = (props) => {

    return ( 
        <div className={classes.MyRooster}>
            <div> {props.id}</div>
            <div> {props.experience}</div>

            <img src={require('../../../assets/images/'+props.image)} alt={props.id} height="150" width="100"/>
        </div>
     )
}
 
export default rooster
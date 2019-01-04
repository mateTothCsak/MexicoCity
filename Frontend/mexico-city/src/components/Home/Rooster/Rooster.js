import React from 'react'

import classes from './Rooster.css'

const rooster = (props) => {

    return ( 
        <div className={classes.MyRooster}>
            <div> {props.name}</div>
            <div>ID# {props.id}</div>
            <div className={classes.statContainer}>
                <div> Won mathches: {props.wonMatches}</div>
                <div> Win ratio: {props.winRatio}</div>
            </div>
            <img src={require('../../../assets/images/'+props.image)} alt={props.id} height="150" width="120"/>
        </div>
     )
}
 
export default rooster
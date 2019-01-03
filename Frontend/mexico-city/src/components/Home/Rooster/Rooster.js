import React from 'react'

import classes from './Rooster.css'

const rooster = (props) => {

    return ( 
        <div className={classes.MyRooster}>
            <div> {props.id}</div>
            <div> {props.name}</div>
            <div className={classes.statContainer}>
                <div> Won mathches: {props.wonMatches}</div>
                <div> Win ratio: {props.winRatio}</div>
            </div>
        </div>
     )
}
 
export default rooster
import React from 'react'

import classes from './ProfileStatistics.css'

const profileStatistics = (props) => {


    return (
        <div className={classes.rightContainer}>
            <p>Level: {props.rooster.level}</p>
            <p>Experience: {props.rooster.experience}</p>
            <p>Gold: {props.rooster.gold}</p>
            <p>Won mathches: {props.rooster.wonMatches}</p>
            <p>Lost Matches: {props.rooster.lostMatches}</p>
            <p>Win ratio: {props.rooster.winRatio}</p>
            <p>Id: {props.rooster.id}</p>

        </div>
    )
}

export default profileStatistics


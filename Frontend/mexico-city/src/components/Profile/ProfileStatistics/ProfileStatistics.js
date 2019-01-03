import React from 'react'

import classes from './ProfileStatistics.css'

const profileStatistics = (props) => {


    return (
        <div className={classes.rightContainer}>
            <table>
                <tr>
                    <td>Level:</td>
                    <td>{props.rooster.level}</td>
                </tr>
                <tr>
                    <td>Experience:</td>
                    <td>{props.rooster.experience}</td>
                </tr>
                <tr>
                    <td>Gold:</td>
                    <td>{props.rooster.gold}</td>
                </tr>
                <tr>
                    <td>Won Matches:</td>
                    <td>{props.rooster.wonMatches}</td>
                </tr>
                <tr>
                    <td>Lost Matches:</td>
                    <td>{props.rooster.lostMatches}</td>
                </tr>
                <tr>
                    <td>Win Ratio:</td>
                    <td>{props.rooster.winRatio}</td>
                </tr>
                <tr>
                    <td>Id:</td>
                    <td>{props.rooster.id}</td>
                </tr>
            </table>
        </div>
    )
}

export default profileStatistics


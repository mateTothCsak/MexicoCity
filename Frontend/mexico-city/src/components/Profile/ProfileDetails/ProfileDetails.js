import React from 'react'
import ProfilePicture from '../ProfilePicture/ProfilePicture'
import ProfileStatistics from '../ProfileStatistics/ProfileStatistics'

import classes from './ProfileDetails.css'

const profileDetails = (props) => {


    return (
        <div>
            <div className={classes.container}>
                <ProfilePicture image={props.rooster.image} id={props.rooster.id} name={props.name}/>
                <ProfileStatistics rooster={props.rooster}/>
            </div>
        </div>
    )
}

export default profileDetails
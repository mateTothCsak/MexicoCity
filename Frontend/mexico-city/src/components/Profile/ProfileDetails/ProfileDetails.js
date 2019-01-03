import React from 'react'
import ProfilePicture from '../ProfilePicture/ProfilePicture'
import ProfileStatistics from '../ProfileStatistics/ProfileStatistics'

import classes from './ProfileDetails.css'

const profileDetails = (props) => {


    return (
        <div>
            <ProfilePicture image={props.rooster.image} id={props.rooster.id} name={props.name}/>
            <ProfileStatistics rooster={props.rooster}/>
        </div>
    )
}

export default profileDetails
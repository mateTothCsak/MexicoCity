import React from 'react'

import classes from './ProfilePicture.css'

const profilePicture = (props) => {


    return (
        <div className={classes.leftContainer}>
            <img src={require('../../../assets/images/'+props.image)} alt={props.id} height="150" width="100"/>
            <p>{props.name}</p>
        </div>
    )
}

export default profilePicture





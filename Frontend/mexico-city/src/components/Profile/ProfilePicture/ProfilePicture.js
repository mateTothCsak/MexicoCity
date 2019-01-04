import React from 'react'

import classes from './ProfilePicture.css'

const profilePicture = (props) => {


    return (
        <div className={classes.leftContainer}>
            <img src={require('../../../assets/images/'+props.image)} alt={props.id}/>
            <p>{props.name}</p>
        </div>
    )
}

export default profilePicture





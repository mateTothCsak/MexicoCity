import React from 'react'


const item = (props) => {

    return (
        <div >
            <div> {props.name}</div>
            <div> {props.id}</div>
        </div>
    )
}

export default item
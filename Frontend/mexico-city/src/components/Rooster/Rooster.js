import React, { Fragment } from 'react';

const rooster = (props) => {
    return ( 
        <Fragment key={props.id+1000}>
            <div style={{color : "white"}} key={props.key}> {props.id}</div>
            <img src={"../../assets/images/"+props.image} alt={props.id} height="150" width="100"/>
        </Fragment>
     );
}
 
export default rooster;
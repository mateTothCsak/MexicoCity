import React, { Fragment }from 'react';


const inputField = (props) => {
    return (
        <Fragment>
            {props.label}
            <label> 
                <input type={props.type} onChange={props.changing}/>    
            </label>
        </Fragment>
     );



}
 
export default inputField;
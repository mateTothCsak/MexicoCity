import React from 'react';

import classes from './FooterItem.css';


const footerItem = (props) => (  
    <li className={classes.FooterItem}>
        <a
            href={props.link}
            className={props.active ? classes.active : null}>{props.children}
        </a>
    </li>
);
 
export default footerItem;
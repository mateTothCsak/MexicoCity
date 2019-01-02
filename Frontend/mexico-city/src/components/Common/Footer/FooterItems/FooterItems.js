import React from 'react';

import classes from './FooterItems.css';
import FooterItem from '../FooterItem/FooterItem';

const footerItems = () => (  
        <ul className={classes.FooterItems}>
            <FooterItem link="/"> About us</FooterItem>
            <FooterItem link="/"> Products</FooterItem>
            <FooterItem link="/"> Apps</FooterItem>
            <FooterItem link="/"> Help & Support</FooterItem>
            <FooterItem link="/"> Privacy & Terms</FooterItem>
        </ul>
);
 
export default footerItems;
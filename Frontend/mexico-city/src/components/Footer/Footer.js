import React from 'react';

import classes from './Footer.css';
// import Logo from '../../Logo/Logo'
import FooterItems from '../Footer/FooterItems/FooterItems';


const footer = () => (
    <footer className={classes.Footer}>
        <nav>
            <FooterItems/>
        </nav>
    </footer>
)
 

// <div className={classes.Logo}>
// </div>


export default footer;
import React, { Fragment } from 'react';

import classes from './Layout.css';
import Toolbar from '../Navigation/Toolbar/Toolbar';
import Footer from '../Footer/Footer';

const layout = (props) => (

    <Fragment>
        <Toolbar displayRegModal={props.displayRegModal} displayLogModal={props.displayLogModal}/>
        <main className={classes.Content}>
            {props.children}
        </main>
        <Footer/>
    </Fragment>
);

export default layout;

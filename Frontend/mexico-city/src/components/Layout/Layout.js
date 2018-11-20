import React from 'react';
import Aux from '../../hoc/Aux';
import classes from './Layout.css';

const layout = (props) => (
    <Aux>
        <div> Navbar </div>
        <div> MexicoCity - Jumbotron </div>
        <div> Info1 </div>
        <div> Info2 </div>
        <div> Footer </div>
        <main className={classes.Content}>
            {props.children}
        </main>
    </Aux>
);

export default layout;

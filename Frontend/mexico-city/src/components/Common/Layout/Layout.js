import React, {Component, Fragment } from 'react';

import classes from './Layout.css';
import Toolbar from '../Navigation/Toolbar/Toolbar';
import Footer from '../Footer/Footer';

class Layout extends Component {
    render() {
        return (
            <Fragment>
                <Toolbar auth={this.props.auth} history={this.props.history}/>
                <main className={classes.Content}>
                    {this.props.children}
                </main>
                <Footer/>
            </Fragment>
        )
    }

};

export default Layout;

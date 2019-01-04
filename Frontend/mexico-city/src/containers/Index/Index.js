import React, { Component, Fragment } from 'react'

import Layout from '../../components/Common/Layout/Layout'
import Jumbotron from '../../components/Index/Jumbotron/Jumbotron'
import InfoBox1 from '../../components/Index/InfoBox/InfoBox1/InfoBox1'
import InfoBox2 from '../../components/Index/InfoBox/InfoBox2/InfoBox2'




class Index extends Component {

    render() {
        return (
            <Fragment>
               <Layout auth={this.props.auth}>
                   <Jumbotron/>
                   <InfoBox1/>
                   <InfoBox2/>
                </Layout>
            </Fragment>
          )
    }
}

 
export default Index
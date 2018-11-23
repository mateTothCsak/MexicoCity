import React from 'react';

import Aux from '../../hoc/Aux'
import Jumbotron from '../../components/Jumbotron/Jumbotron';
import InfoBox1 from '../../components/InfoBox/InfoBox1/InfoBox1';
import InfoBox2 from '../../components/InfoBox/InfoBox2/InfoBox2';
import Footer from '../../components/Footer/Footer';

const myMainPage = (props) => {
    if(props.error){
        return <p>{props.error}</p>
    }

    if(props.loading){
        return <p>Loading...</p>;
    }

    return(
        <Aux>
            <Jumbotron/>
            <InfoBox1></InfoBox1>
            <InfoBox2></InfoBox2>
            <Footer></Footer>  
        </Aux>
        )
};

// render staff dynamically
// {props.allData.map(d => <div key={d.id}>{d.id}</div>)}

 
export default myMainPage;
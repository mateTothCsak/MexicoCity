import React, {Component, Fragment} from 'react';
import axios from 'axios';
import Item from '../../components/Shop/Item/Item';

class Shop extends Component{
    constructor(props){
        super(props);
        this.state = {
            data: [],
            error : null,
        };
    }


    componentDidMount(){
        const { getAccessToken } = this.props.auth;
        const API_URL = 'http://localhost:8080/shop';
        const headers = { 'Authorization': `Bearer ${getAccessToken()}`};

        axios.get(API_URL, { headers })
            .then(response => this.setState({ data: response.data }))
            .catch(error => this.setState({ error: error }));
    }


    render() {
        let shopItems = this.state.data.map(d=> (
            <Item
                name={d.name}
                id={d.id}
            />
        ));

        return (
            <Fragment>
                <div style={{color: "white"}}>{shopItems}</div>
            </Fragment>
        )

    }


};

export default Shop;

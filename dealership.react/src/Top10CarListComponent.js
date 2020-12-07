import React, { Component } from 'react';
import CarListView from './CarListView';

class Top10CarListComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            carList: [],
            error: false,
            isLoaded: false,
        }
    }

    getResponseJSON(response) {
        return response.json();
    }

    componentDidMount() {
        let requestHeaders = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        };
        let requestUrl = '/cars/top10';

        fetch(requestUrl, {
            headers: requestHeaders
        })
            .then(response => response.json())
            .then(json => {
                this.setState(
                    {
                        carList: json,
                        error: false,
                        isLoaded: true,
                    }
                )
            })
            .catch(response => {
                this.setState(
                    {
                        isLoaded: false,
                        carList: [],
                        error: true,
                    })
            }
            );
    }
    render() {
        if (this.state.error) {
            return <div>Error....</div>;
        } else if (!this.state.isLoaded) {
            return <div>Loading....</div>;
        } else {
            console.log(this.state.carList);
            return <CarListView carList={this.state.carList} />;
        }
    }
}

export default Top10CarListComponent;
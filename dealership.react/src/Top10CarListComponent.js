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

    getHttpRequestData(requestUrl) {
        let requestHeaders = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        };

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

    componentDidMount() {
        let requestUrl = '/cars/top10';
        this.getHttpRequestData(requestUrl);
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
import React, { Component } from 'react';
import CarListView from './CarListView';

class FindCarComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { carList: [], carRegistrationNumber: '' };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label htmlFor="carRegistrationNumber">Registration #:</label>
                    <input id="carRegistrationNumber" onChange={this.handleChange} value={this.state.carRegistrationNumber} />
                    <button>Search</button>
                </form>
                <CarListView carList={this.state.carList} />
            </div>
        );
    }

    handleChange(eventArgs) {
        this.setState({ carRegistrationNumber: eventArgs.target.value });
    }

    handleSubmit(eventArgs) {
        eventArgs.preventDefault();
        if (!this.state.carRegistrationNumber.length)// if input is blank
        {
            return;
        }
        let requestUrl = `/cars/reg/${this.state.carRegistrationNumber}?timestamp=${Date.now()}`;
        this.getHttpRequestData(requestUrl);
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


}

export default FindCarComponent;

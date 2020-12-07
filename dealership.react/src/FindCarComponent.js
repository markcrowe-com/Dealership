import React, { Component } from 'react';
import CarListView from './CarListView';

class FindCarComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { car: [], carRegistrationNumber: '' };
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
                <CarListView items={this.state.items} />
            </div>
        );
    }



    handleSubmit(eventArgs) {
        eventArgs.preventDefault();
        if (!this.state.carRegistrationNumber.length)// if input is blank
        {
            return;
        }
        let carRegistrationNumber = this.state.carRegistrationNumber;
        let requestUrl = `/cars/reg${carRegistrationNumber}?timestamp=${Date.now()}`;
        getHttpRequestData(requestUrl);
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

//import GuestSearchResultComponent from './GuestSearchResultComponent';

let serviceUrl = 'entities.guests/';
let serviceUrlJsonHeaders = {
    'Content-Type': 'application/json',
    'Accept': 'application/json'
};

class GuestSearchComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { items: [], text: '' };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleChange(e) {
        this.setState({ text: e.target.value });
    }

    handleSubmit(e) {
        e.preventDefault();
        if (!this.state.text.length)// if input is blank
        {
            return;
        }
        let guestId = this.state.text;
        let url = `${serviceUrl}${guestId}?timestamp=${Date.now()}`;

        fetch(url, {
            headers: serviceUrlJsonHeaders

        })
            .then(result => result.json())
            .then(json => {
                this.setState(
                    {
                        items: json,
                        text: this.state.text
                    }
                );
            })
            .catch(() => {
                this.setState(
                    {
                        items: [],
                        text: "Failed"//being economic with limited time, if nothing exists or a connection error, printing failure message to the text box. Didn't habe time to make a proper GUI 
                    }
                );
            })
            ;
    }
}

export default GuestSearchComponent;
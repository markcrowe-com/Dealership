import React, { Component } from 'react';

class CarListView extends Component {
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
        let requestUrl = '/cars/';

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
        var { carList, error, isLoaded } = this.state;
        if (error) {
            return <div>Error....</div>;
        } else if (!isLoaded) {
            return <div>Loading....</div>;
        } else {
            return (
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Registration Number</th>
                            <th>Value</th>
                            <th>Owner</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            carList.map(car =>
                                <tr>
                                    <td>{car.id}</td>
                                    <td>{car.registrationNumber}</td>
                                    <td>{car.value}</td>
                                    <td>{car.ownerName}</td>
                                </tr>)
                        }
                    </tbody>
                </table>
            );
        }
    }
}

export default CarListView;
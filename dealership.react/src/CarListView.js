import React, { Component } from 'react';

class CarListView extends Component {

    render() {
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
                        this.props.carList.map(car =>
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

export default CarListView;
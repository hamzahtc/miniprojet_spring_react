import React, { Component } from 'react'

export default class Client extends Component {
    render() {
        return (
                <tr>
                <td>{this.props.cli.nom}</td>
                <td>{this.props.cli.prenom}</td>
                <td><button type="button" class="btn btn-light" onClick={this.props.delClient.bind(this,this.props.cli.id)}>Delete</button></td>
                </tr>
        )
    }
}

import React, { Component } from 'react'

export default class Produit extends Component {
    render() {
        return (
          
                <tr>
                <td>{this.props.prod.designation}</td>
                <td>{this.props.prod.prix}</td>
                <td><button type="button" class="btn btn-light" onClick={this.props.delProduit.bind(this,this.props.prod.id)}>Delete</button></td>
                </tr>
        )
    }
}

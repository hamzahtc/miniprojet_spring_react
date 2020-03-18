import React, { Component } from 'react'
import axios from 'axios';

export default class AddProduit extends Component {
    state={
        designation:'',
        prix:''
    }
    addProd = (e) => {
        e.preventDefault();
        const produit = {
          designation : this.state.designation,
          prix : this.state.prix
        }
        axios.post('http://localhost:8070/produit',produit)
        .then(res => this.props.addtoother(produit))
        .then(this.setState({
            designation:'',
            prix:''
        }))

    }
    onChangeInput = (e) => {
        this.setState({
          [e.target.name] : e.target.value
        })
      }
    render() {
        return (
            <div>
                <form onSubmit={this.addProd}>
                <div class="form-group">
                    <label>Designation</label>
                    <input type="text" value={this.state.designation} class="form-control" name="designation" onChange={this.onChangeInput}/>
                </div>
                <div class="form-group">
                    <label >Prix</label>
                    <input type="number" value={this.state.prix} class="form-control" name="prix" onChange={this.onChangeInput}/>
                </div>
               
                <button type="submit" class="btn btn-dark">Ajouter</button>
                </form>
            </div>
        )
    }
}

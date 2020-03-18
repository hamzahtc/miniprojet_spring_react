import React, { Component } from 'react'
import axios from 'axios';

export default class AddClient extends Component {
    state={
        nom:'',
        prenom:''
    }
    addClient = (e) => {
        e.preventDefault();
        const client = {
          nom : this.state.nom,
          prenom : this.state.prenom
        }
        axios.post('http://localhost:8070/client',client)
        .then(res => this.props.addtoother(client))
        .then(this.setState({
            nom:'',
            prenom:''
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
                <form onSubmit={this.addClient}>
                <div class="form-group">
                    <label>Nom</label>
                    <input type="text" value={this.state.nom} class="form-control" name="nom" onChange={this.onChangeInput}/>
                </div>
                <div class="form-group">
                    <label >Prenom</label>
                    <input type="text" value={this.state.prenom} class="form-control" name="prenom" onChange={this.onChangeInput}/>
                </div>
               
                <button type="submit" class="btn btn-dark">Ajouter</button>
                </form>
            </div>
        )
    }
}

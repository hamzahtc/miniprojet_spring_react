import React, { Component } from 'react'
import Client from './Client';
import axios from 'axios';
import AddClient from './AddClient';

export default class Clients extends Component {
    state={
        clients:[],
        show: false
    }
    componentDidMount(){
        axios.get('http://localhost:8070/client')
      .then(res => this.setState({
        clients : res.data
      }));
    }
    deleteProduit = (id) =>{
        axios.delete('http://localhost:8070/client/'+id)
        .then(console.log("deleted"))
        .then(this.setState({
            clients:this.state.clients.filter(client => client.id !== id)
        }))
    }
    addclienttostate = (cli) => {
        this.setState({
            clients : [cli, ...this.state.clients]
        })
    }
    showForm = () => {
      this.setState({
        show: !this.state.show
      })
    }
    render() {
        return (
            <div>
              <div className="row">
              <div className="col-md-3">
                <div style={{position: "fixed"}}>
                  <button class="btn btn-light" style={{marginBottom:20}} onClick={this.showForm}>Nouveau Client</button>
                  { this.state.show ? <AddClient addtoother={this.addclienttostate}></AddClient> : null }
                </div>
                
              </div>
              <div className="col-md-9">
                <table class="table table-hover table-dark">
                  <thead className="thead-light">
                    <tr>
                      <th scope="col">Nom</th>
                      <th scope="col">Prenom</th>
                      <th scope="col"></th>
                    </tr>
                  </thead>
                  <tbody>
                  {
                              this.state.clients.map(client => {
                                      return(
                                        <Client cli={client} delClient={this.deleteProduit}></Client>
                                      )
                                    })
                                  
                  }
                    
                  </tbody>
                </table>
              </div>
              </div>


               

            </div>
        )
    }
}

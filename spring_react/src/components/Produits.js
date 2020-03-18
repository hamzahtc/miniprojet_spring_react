import React, { Component } from 'react'
import axios from 'axios';
import Produit from './Produit';
import AddProduit from './AddProduit';

export default class Produits extends Component {
    state={
        produits:[],
        show: false
    }
    componentDidMount(){
        axios.get('http://localhost:8070/produit')
      .then(res => this.setState({
        produits : res.data
      }));
    }
    deleteProduit = (id) =>{
        axios.delete('http://localhost:8070/produit/'+id)
        .then(console.log("deleted"))
        .then(this.setState({
            produits:this.state.produits.filter(produit => produit.id !== id)
        }))
    }
    addprodtostate = (prod) => {
        this.setState({
            produits : [prod, ...this.state.produits]
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
                       <button class="btn btn-light" style={{marginBottom:20}} onClick={this.showForm}>Nouveau Produit</button>
                { this.state.show ? <AddProduit addtoother={this.addprodtostate}></AddProduit> : null }  
                    </div>
                 
                  </div>  
                  <div className="col-md-9">
                <table class="table table-hover table-dark">
                                <thead className="thead-light">
                                  <tr>
                                    <th scope="col">Designation</th>
                                    <th scope="col">Prix</th>
                                    <th scope="col"></th>
                                  </tr>
                                </thead>
                                <tbody>
                                {
                                            this.state.produits.map(produit => {
                                                    return(
                                                      <Produit prod={produit} delProduit={this.deleteProduit}></Produit>
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

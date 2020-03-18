import React, { Component } from 'react'
import { Link } from 'react-router-dom'

export default class Navbar extends Component {
    render() {
        return (
            <div style={{marginBottom:20}}>
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                 <a class="navbar-brand" href="#">Mini-Projet</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                 <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                <span class="nav-link"><Link style={{color:'white'}} to="/">Accueil</Link></span>
                </li>
                <li class="nav-item">
                <span class="nav-link"><Link style={{color:'white'}} to="/produits">Produits</Link></span>
                </li>
                <li class="nav-item">
                <span class="nav-link"><Link style={{color:'white'}} to="/clients">Clients</Link></span>
                </li>
                </ul>
                </div>
                </nav>
            </div>       
        )
    }
}

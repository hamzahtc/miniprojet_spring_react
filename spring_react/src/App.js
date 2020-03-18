import React from 'react';
import {BrowserRouter as Router,Route} from "react-router-dom";

//import 'bootstrap/dist/css/bootstrap.min/css';
import './App.css';
//import Produits from './components/Produits';
import Produits from './components/Produits';
import Clients from './components/Clients';
import Accueil from './components/Accueil';
import Navbar from './components/Navbar';
import AddProduit from './components/AddProduit';
import AddClient from './components/AddClient';
class App extends React.Component {
 
	render() {

    
		return (
      <div className="container">
          <Router>
             <Navbar></Navbar>
             <Route path="/" component={Accueil} exact />   
            <Route path="/produits" component={Produits}/>             
            <Route path="/clients" component={Clients}/>
            </Router>
        </div>
			
		);
 }
 }
export default App;



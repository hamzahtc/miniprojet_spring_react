package winterspring.example.winterspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import winterspring.example.winterspring.model.Produit;
import winterspring.example.winterspring.service.ProduitService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	
	@PostMapping("/produit")
	public ResponseEntity<Produit> createProduit(@RequestBody Produit produit){
		return ResponseEntity.ok().body(this.produitService.createProduit(produit));
	}
	@GetMapping("/produit")
	public ResponseEntity<List<Produit>> getAllProduit(){
		return ResponseEntity.ok().body(produitService.getAllProduit());
	}
	
	@GetMapping("/produit/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable long id){
		return ResponseEntity.ok().body(this.produitService.getProduitById(id));
	}
	
	@PutMapping("/produit/{id}")
	public ResponseEntity<Produit> updateProduit(@PathVariable long id, @RequestBody Produit produit){
		produit.setId(id);
		return ResponseEntity.ok().body(this.produitService.updateProduit(produit));
	}
	
	@DeleteMapping("/produit/{id}")
	public HttpStatus deleteProduit(@PathVariable long id) {
		this.produitService.deleteProduit(id);
		return HttpStatus.OK;
	}
	
	
}

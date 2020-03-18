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

import winterspring.example.winterspring.model.Commande;
import winterspring.example.winterspring.service.CommandService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class CommandeController {

	@Autowired
	private CommandService commandService;
	
	@PostMapping("/commande")
	public ResponseEntity<Commande> createCommande(@RequestBody Commande commande){
		return ResponseEntity.ok().body(this.commandService.createCommande(commande));
	}
	@GetMapping("/commande")
	public ResponseEntity<List<Commande>> getAllCommande(){
		return ResponseEntity.ok().body(commandService.getAllCommande());
	}
	
	@GetMapping("/commande/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable long id){
		return ResponseEntity.ok().body(this.commandService.getCommandeById(id));
		
	}
	
	@PutMapping("/commande/{id}")
	public ResponseEntity<Commande> updateCommande(@PathVariable long id, @RequestBody Commande commande){
		commande.setId(id);
		return ResponseEntity.ok().body(this.commandService.updateCommande(commande));
	}
	
	@DeleteMapping("/commande/{id}")
	public HttpStatus deleteProduit(@PathVariable long id) {
		this.commandService.deleteCommande(id);;
		return HttpStatus.OK;
	}
}

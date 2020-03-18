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

import winterspring.example.winterspring.model.Client;
import winterspring.example.winterspring.service.ClientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public ResponseEntity<List<Client>> getAllClient() {
		return ResponseEntity.ok().body(this.clientService.getAllClient());
	}
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.clientService.getClientById(id));
	}
	
	@PostMapping("/client")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		return ResponseEntity.ok().body(this.clientService.createClient(client));
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client client){
		client.setId(id);
		return ResponseEntity.ok().body(this.clientService.updateClient(client));
	}
	
	@DeleteMapping("/client/{id}")
	public HttpStatus deleteClient(@PathVariable long id) {
		this.clientService.deleteClient(id);
		return HttpStatus.OK;
	}
	



}

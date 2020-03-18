package winterspring.example.winterspring.service;

import java.util.List;

import winterspring.example.winterspring.model.Commande;

public interface CommandService {
	Commande createCommande(Commande commande);
	Commande updateCommande(Commande commande);
	List<Commande> getAllCommande();
	Commande getCommandeById(long CommandeId);
	void deleteCommande(long CommandeId);
}

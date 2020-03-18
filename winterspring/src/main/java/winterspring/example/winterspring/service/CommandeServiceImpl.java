package winterspring.example.winterspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import winterspring.example.winterspring.exception.RessourceNotFoundException;
import winterspring.example.winterspring.model.Commande;
import winterspring.example.winterspring.model.Produit;
import winterspring.example.winterspring.repository.CommandeRepository;

@Service
@Transactional
public class CommandeServiceImpl implements CommandService{

	@Autowired
	private CommandeRepository commandRepository;
	
	@Override
	public Commande createCommande(Commande commande) {
		return commandRepository.save(commande);

	}

	@Override
	public Commande updateCommande(Commande commande) {
		Optional<Commande> commandeDb = this.commandRepository.findById(commande.getId());
		if(commandeDb.isPresent()) {
			Commande commandeUpdate = commandeDb.get();
			commandeUpdate.setId(commande.getId());
			commandeUpdate.setQuantite(commande.getQuantite());
			commandeUpdate.setEtat(commande.isEtat());
			commandRepository.save(commandeUpdate);
			return commandeUpdate;
		}
		else
		{
			throw new RessourceNotFoundException("Erreur");
		}
	}

	@Override
	public List<Commande> getAllCommande() {
		return this.commandRepository.findAll();
	}

	@Override
	public Commande getCommandeById(long CommandeId) {
		Optional<Commande> commandeDb = this.commandRepository.findById(CommandeId);
		if(commandeDb.isPresent()) {
			return commandeDb.get();
		}
		else
		{
			throw new RessourceNotFoundException("Rah malqitsh l commande");
		}
	}

	@Override
	public void deleteCommande(long CommandeId) {
		Optional<Commande> commandeDb = this.commandRepository.findById(CommandeId);
		if(commandeDb.isPresent()) {
			this.commandRepository.delete(commandeDb.get());
		}
		else
		{
			throw new RessourceNotFoundException("Rah ma deleteet walo, sir qra mzyen");
		}
		
	}

}

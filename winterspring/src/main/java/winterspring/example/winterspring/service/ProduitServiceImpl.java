package winterspring.example.winterspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import winterspring.example.winterspring.exception.RessourceNotFoundException;
import winterspring.example.winterspring.model.Produit;
import winterspring.example.winterspring.repository.ProduitRepository;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService{

	
	@Autowired
	private ProduitRepository produitrepository;
	
	@Override
	public Produit createProduit(Produit produit) {
		return produitrepository.save(produit);
	}

	@Override
	public Produit updateProduit(Produit produit) {
		Optional<Produit> produitDb = this.produitrepository.findById(produit.getId());
		if(produitDb.isPresent()) {
			Produit produitUpdate = produitDb.get();
			produitUpdate.setId(produit.getId());
			produitUpdate.setDesignation(produit.getDesignation());
			produitUpdate.setPrix(produit.getPrix());
			produitrepository.save(produitUpdate);
			return produitUpdate;
		}
		else
		{
			throw new RessourceNotFoundException("Erreur");
		}
		
	}

	@Override
	public List<Produit> getAllProduit() {
		return this.produitrepository.findAll();
	}

	@Override
	public Produit getProduitById(long ProduitId) {
		Optional<Produit> produitDb = this.produitrepository.findById(ProduitId);
		if(produitDb.isPresent()) {
			return produitDb.get();
		}
		else
		{
			throw new RessourceNotFoundException("Rah malqitsh l produit");
		}
	}
	
	@Override
	public void deleteProduit(long ProduitId) {
		Optional<Produit> produitDb = this.produitrepository.findById(ProduitId);
		if(produitDb.isPresent()) {
			this.produitrepository.delete(produitDb.get());
		}
		else
		{
			throw new RessourceNotFoundException("Rah ma deleteet walo, sir qra mzyen");
		}
		
	}

}

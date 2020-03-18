package winterspring.example.winterspring.service;

import java.util.List;

import winterspring.example.winterspring.model.Produit;

public interface ProduitService {

	Produit createProduit(Produit produit);
	Produit updateProduit(Produit produit);
	List<Produit> getAllProduit();
	Produit getProduitById(long ProduitId);
	void deleteProduit(long ProduitId);
	
}

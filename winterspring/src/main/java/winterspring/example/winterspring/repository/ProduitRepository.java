package winterspring.example.winterspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import winterspring.example.winterspring.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}

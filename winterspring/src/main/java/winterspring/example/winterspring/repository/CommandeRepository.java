package winterspring.example.winterspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import winterspring.example.winterspring.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}

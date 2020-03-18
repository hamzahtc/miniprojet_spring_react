package winterspring.example.winterspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import winterspring.example.winterspring.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}

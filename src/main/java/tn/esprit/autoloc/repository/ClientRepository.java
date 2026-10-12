package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domaine.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}

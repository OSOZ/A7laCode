package ma.emi.rm.consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emi.rm.model.entities.Inventaire;

public interface InventaireRepository extends JpaRepository<Inventaire, Integer>{
	
}

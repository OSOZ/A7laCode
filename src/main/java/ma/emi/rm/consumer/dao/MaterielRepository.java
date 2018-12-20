package ma.emi.rm.consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emi.rm.model.entities.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Integer>{
	
}

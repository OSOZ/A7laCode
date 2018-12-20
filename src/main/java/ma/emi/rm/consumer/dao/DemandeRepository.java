package ma.emi.rm.consumer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.emi.rm.model.entities.Demande;
import ma.emi.rm.model.entities.Enseignant;

public interface DemandeRepository extends JpaRepository<Demande, Integer>{
	
	@Query("select e from Demande e where e.enseignant = :enseignant")
	public List<Demande> demandeForEnseignant(@Param("enseignant") Enseignant enseignant);
}

package ma.emi.rm.consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.emi.rm.model.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
	
	@Query("select e from Enseignant e where e.email = :email")
	public Enseignant findByEmail(@Param("email") String email);
	
}

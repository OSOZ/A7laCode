package ma.emi.rm.business.enseignant;

import ma.emi.rm.model.entities.Enseignant;

public interface EnseignantService {
	public Enseignant findEnseignantByEmail(String email);
	public Enseignant saveEnseignant(Enseignant admin);
}

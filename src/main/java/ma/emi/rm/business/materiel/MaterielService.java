package ma.emi.rm.business.materiel;

import ma.emi.rm.model.entities.Materiel;

public interface MaterielService {
	public Materiel addMateriel(Materiel materiel);
	public Materiel searchMateriel(Integer materielId);
}

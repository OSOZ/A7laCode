package ma.emi.rm.business.inventaire;

import java.util.List;

import ma.emi.rm.model.entities.Inventaire;
import ma.emi.rm.model.entities.Materiel;

public interface InventaireService {
	public List<Inventaire> getAllInventaire();
	public Inventaire addInventaire(Inventaire inventaire);
	public Inventaire editInventaire(Inventaire inventaire);
	public void deleteInventaire(Integer inventaireId);	
	public Inventaire searchInventaire(Integer inventaireId);
	public List<Materiel> getAllByIdInventaire(Integer inventaireId);
	
}
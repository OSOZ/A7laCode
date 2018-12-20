package ma.emi.rm.business.inventaire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emi.rm.consumer.dao.InventaireRepository;
import ma.emi.rm.model.entities.Inventaire;
import ma.emi.rm.model.entities.Materiel;

@Service
public class InventaireServiceImpl implements InventaireService{
	@Autowired
	private InventaireRepository inventaireRepository;
	
	public List<Inventaire> getAllInventaire()
	{
		return inventaireRepository.findAll();
	}
	public Inventaire addInventaire(Inventaire inventaire)
	{
		return inventaireRepository.save(inventaire);
	}
	public Inventaire editInventaire(Inventaire inventaire)
	{
		return inventaireRepository.save(inventaire);
	}
	public Inventaire searchInventaire(Integer inventaireId)
	{
		return inventaireRepository.getOne(inventaireId);
	}
	
	public List<Materiel> getAllByIdInventaire(Integer inventaireId)
	{
		Inventaire inventaire = searchInventaire(inventaireId);
		return inventaire.getMateriels();
	}
	@Override
	public void deleteInventaire(Integer inventaireId) {
		Inventaire inventaire = searchInventaire(inventaireId);
		inventaireRepository.delete(inventaire);
	}
}

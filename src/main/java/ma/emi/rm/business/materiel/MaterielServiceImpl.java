package ma.emi.rm.business.materiel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emi.rm.consumer.dao.MaterielRepository;
import ma.emi.rm.model.entities.Materiel;

@Service
public class MaterielServiceImpl implements MaterielService{
	@Autowired
	private MaterielRepository materielRepository;

	@Override
	public Materiel addMateriel(Materiel materiel) {
		materiel.setDisponible(true);
		return materielRepository.save(materiel);
	}

	@Override
	public Materiel searchMateriel(Integer materielId) {
		// TODO Auto-generated method stub
		return materielRepository.getOne(materielId);
	}
	
	
}

package ma.emi.rm.business.demande;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emi.rm.consumer.dao.DemandeRepository;
import ma.emi.rm.model.entities.Demande;
import ma.emi.rm.model.entities.Enseignant;
import ma.emi.rm.utils.SendMail;

@Service
public class DemandeServiceImpl implements DemandeService {
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private SendMail sendMail;
	
	@Override
	public List<Demande> demandesEnseignant(Integer enseignantId) {
		
		return demandeRepository.findAll();
	}

	@Override
	public void demanderMateriel(ByteArrayInputStream out ,String enseignantMail) throws UnsupportedEncodingException {
		sendMail.sendEmail(out,enseignantMail);
	}

	@Override
	public List<Demande> demandeForEnseignant(Enseignant enseignant) {
		return demandeRepository.demandeForEnseignant(enseignant);
	}

}

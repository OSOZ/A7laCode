package ma.emi.rm.business.enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.emi.rm.consumer.dao.EnseignantRepository;
import ma.emi.rm.model.entities.Enseignant;

@Service
public class EnseignantServiceImpl implements EnseignantService {
	
	@Autowired
	private EnseignantRepository enseignantRepository;
	
	private BCryptPasswordEncoder bcryptPasswordEncode = new BCryptPasswordEncoder();
	@Override
	public Enseignant findEnseignantByEmail(String email) {
		return enseignantRepository.findByEmail(email);
	}

	@Override
	public Enseignant saveEnseignant(Enseignant e) {
		e.setPassword(bcryptPasswordEncode.encode(e.getPassword()));
		return enseignantRepository.save(e);
	}

}

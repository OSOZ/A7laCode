package ma.emi.rm.business.demande;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import ma.emi.rm.model.entities.Demande;
import ma.emi.rm.model.entities.Enseignant;
//a7laCommit
public interface DemandeService {
	public List<Demande> demandesEnseignant(Integer enseignantId);
	public void demanderMateriel(ByteArrayInputStream out,String enseignantMail) throws UnsupportedEncodingException;
	public List<Demande> demandeForEnseignant(Enseignant enseignant);
}

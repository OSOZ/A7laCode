package ma.emi.rm.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEMANDES")
public class Demande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer demandeId;
	@ManyToOne
	@JoinColumn(name = "enseignantId")
	private Enseignant enseignant;
	private Date dateDemande;
	private String etat;
	
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Integer getDemandeId() {
		return demandeId;
	}
	public void setDemandeId(Integer demandeId) {
		this.demandeId = demandeId;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
}

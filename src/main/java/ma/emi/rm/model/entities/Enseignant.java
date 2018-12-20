package ma.emi.rm.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ENSEIGNENTS")
public class Enseignant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enseignantId;
	private String firstName;
	private String LastName;
	private String email;
	private String password;
	private String role;
	@OneToMany(targetEntity = Demande.class, fetch = FetchType.LAZY, mappedBy = "enseignant", cascade = CascadeType.ALL)
	private List<Enseignant> enseignantDemandes = new ArrayList<>();

	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String firstName, String lastName, String email, String password, String role,
			List<Enseignant> enseignantDemandes) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enseignantDemandes = enseignantDemandes;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnseignantId() {
		return enseignantId;
	}

	public void setEnseignantId(Integer enseignantId) {
		this.enseignantId = enseignantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Enseignant> getEnseignantDemandes() {
		return enseignantDemandes;
	}

	public void setEnseignantDemandes(List<Enseignant> enseignantDemandes) {
		this.enseignantDemandes = enseignantDemandes;
	}

}

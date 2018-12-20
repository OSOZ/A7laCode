package ma.emi.rm.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import ma.emi.rm.utils.BooleanTFConverter;

@Entity
@Table(name = "MATERIELS")
public class Materiel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materielId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "disponible")
	@Convert(converter=BooleanTFConverter.class)
	private boolean disponible;
	@Column(name = "LIEU")
	private String lieu;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATENTREE")
	private Date dateDentree;
	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDateDentree() {
		return dateDentree;
	}

	public void setDateDentree(Date dateDentree) {
		this.dateDentree = dateDentree;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	
	@Column(name = "REF")
	private String ref;
	@ManyToOne
	@JoinColumn(name = "INVENTAIRE_ID")
	private Inventaire inventaire;

	public Materiel(int materielId, String ref) {
		super();
		this.materielId = materielId;
		this.ref = ref;
	}

	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaterielId() {
		return materielId;
	}

	public void setMaterielId(int materielId) {
		this.materielId = materielId;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
}

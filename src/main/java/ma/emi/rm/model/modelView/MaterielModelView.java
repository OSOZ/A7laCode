package ma.emi.rm.model.modelView;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MaterielModelView {
	private String ref;
	private Integer inventaireId;
	private Date dateDentree;
	private String lieu;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getDateDentree() {
		return dateDentree;
	}
	public void setDateDentree(Date dateDentree) {
		this.dateDentree = dateDentree;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Integer getInventaireId() {
		return inventaireId;
	}
	public void setInventaireId(Integer inventaireId) {
		this.inventaireId = inventaireId;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public MaterielModelView() {
		super();
		// TODO Auto-generated constructor stub
	}
}


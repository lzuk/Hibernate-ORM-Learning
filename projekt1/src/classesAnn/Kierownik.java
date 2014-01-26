package classesAnn;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="KIEROWNIK")
@PrimaryKeyJoinColumn(name="ID_KIEROWNIK")
@ForeignKey(name="FK_OSOBA_KIER")
public class Kierownik extends Osoba implements Serializable {
	@OneToMany
	@JoinColumn(name="ID_KIEROWNIK")
	@ForeignKey(name="FK_KIER_PROJ")
	@Cascade(CascadeType.SAVE_UPDATE)
	Set<Projekt> projekty;

	public Set<Projekt> getProjekty() {
		return projekty;
	}

	public void setProjekty(Set<Projekt> projekty) {
		this.projekty = projekty;
	}
}

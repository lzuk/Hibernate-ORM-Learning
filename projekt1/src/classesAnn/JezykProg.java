package classesAnn;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="JEZYKPROG")
public class JezykProg implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ID_JEZYKPROG")
    private int id;
    String nazwa;

    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_JEZYKPROG")
    @ForeignKey(name="FK_JEZYKP_JEZYK")
	Set<Jezyk> jezyki;
    
    @OneToMany
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_JEZYKPROG")
    @ForeignKey(name="FK_JEZYKP_ZAP")
	Set<Zapotrzebowanie> zapotrzebowanie;
        
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public Set<Jezyk> getJezyki() {
		return jezyki;
	}
	public void setJezyki(Set<Jezyk> jezyki) {
		this.jezyki = jezyki;
	}
	public Set<Zapotrzebowanie> getZapotrzebowanie() {
		return zapotrzebowanie;
	}
	public void setZapotrzebowanie(Set<Zapotrzebowanie> zapotrzebowanie) {
		this.zapotrzebowanie = zapotrzebowanie;
	}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

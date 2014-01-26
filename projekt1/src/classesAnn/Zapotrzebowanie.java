package classesAnn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="ZAPOTRZEBOWANIE")
public class Zapotrzebowanie implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ID_ZAPOTRZEBOWANIE")
    private int id;
	int osoboGodz;
	int stonienZnaj;
	
	@ManyToOne
	@JoinColumn(name="ID_PROJEKT")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	Projekt projekt;
	
	@ManyToOne
	@JoinColumn(name="ID_JEZYKPROG")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	JezykProg jezykProg;
		
	public int getOsoboGodz() {
		return osoboGodz;
	}
	public void setOsoboGodz(int osoboGodz) {
		this.osoboGodz = osoboGodz;
	}
	public int getStonienZnaj() {
		return stonienZnaj;
	}
	public void setStonienZnaj(int stonienZnaj) {
		this.stonienZnaj = stonienZnaj;
	}
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	public JezykProg getJezykProg() {
		return jezykProg;
	}
	public void setJezykProg(JezykProg jezykProg) {
		this.jezykProg = jezykProg;
	}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
	
}

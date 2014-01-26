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
@Table(name="JEZYK")
public class Jezyk implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ID_JEZYK")
    private int id;
	private int stopienZnaj;
	private String uwagi;
	
	@ManyToOne
	@JoinColumn(name="ID_PROGRAMISTA")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Programista programista;
	
	@ManyToOne
	@JoinColumn(name="ID_JEZYKPROG")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private JezykProg jezykProg;
	
	public JezykProg getJezykProg() {
		return jezykProg;
	}
	public void setJezykProg(JezykProg jezykProg) {
		this.jezykProg = jezykProg;
	}
	public int getStopienZnaj() {
		return stopienZnaj;
	}
	public void setStopienZnaj(int stopienZnaj) {
		this.stopienZnaj = stopienZnaj;
	}
	public String getUwagi() {
		return uwagi;
	}
	public void setUwagi(String uwagi) {
		this.uwagi = uwagi;
	}
	public Programista getProgramista() {
		return programista;
	}
	public void setProgramista(Programista programista) {
		this.programista = programista;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

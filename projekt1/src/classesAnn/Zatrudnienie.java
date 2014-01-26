package classesAnn;

import java.io.Serializable;
import java.util.Calendar;

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
@Table(name="ZATRUDNIENIE")
public class Zatrudnienie implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ID_ZATRUDNIENIE")
    private int id;
	Calendar od;
	Calendar doo;
	int procent;
	
	@ManyToOne
	@JoinColumn(name="ID_PROJEKT")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	Projekt projekt;
	
	@ManyToOne
	@JoinColumn(name="ID_PROGRAMISTA")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	Programista programista;
	
	public Calendar getOd() {
		return od;
	}
	public void setOd(Calendar od) {
		this.od = od;
	}
	public Calendar getDoo() {
		return doo;
	}
	public void setDoo(Calendar doo) {
		this.doo = doo;
	}
	public int getProcent() {
		return procent;
	}
	public void setProcent(int procent) {
		this.procent = procent;
	}
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	public Programista getProgramista() {
		return programista;
	}
	public void setProgramista(Programista programista) {
		this.programista = programista;
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

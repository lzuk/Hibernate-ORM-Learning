package classes;

import java.io.Serializable;
import java.util.Calendar;

public class Zatrudnienie implements Serializable {
    private int id;
	Calendar od;
	Calendar doo;
	int procent;
	Projekt projekt;
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

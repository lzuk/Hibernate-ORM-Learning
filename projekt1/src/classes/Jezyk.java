package classes;

import java.io.Serializable;

public class Jezyk implements Serializable {
    private int id;
	private int stopienZnaj;
	private String uwagi;
	private Programista programista;
	JezykProg jezykProg;
	
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

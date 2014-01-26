package classes;

import java.io.Serializable;

public class Zapotrzebowanie implements Serializable {
    private int id;
	int osoboGodz;
	int stonienZnaj;
	Projekt projekt;
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

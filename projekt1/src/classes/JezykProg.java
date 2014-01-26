package classes;

import java.io.Serializable;
import java.util.Set;

public class JezykProg implements Serializable {
    private int id;
    String nazwa;
	Set<Jezyk> jezyki;
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

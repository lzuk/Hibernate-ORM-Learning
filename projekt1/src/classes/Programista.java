package classes;

import java.io.Serializable;
import java.util.Set;

public class Programista extends Osoba implements Serializable{
	private Set<Jezyk> jezyki;
	private Set<Zatrudnienie> zatrudnienie;

    public Set<Jezyk> getJezyki() {
        return jezyki;
    }

    public void setJezyki(Set<Jezyk> jezyki) {
        this.jezyki = jezyki;
    }
    public Set<Zatrudnienie> getZatrudnienie() {
        return zatrudnienie;
    }

    public void setZatrudnienie(Set<Zatrudnienie> zatrudnienie) {
        this.zatrudnienie = zatrudnienie;
    }
}

package classes;

import java.io.Serializable;
import java.util.Set;

public class Kierownik extends Osoba implements Serializable {
	Set<Projekt> projekty;

	public Set<Projekt> getProjekty() {
		return projekty;
	}

	public void setProjekty(Set<Projekt> projekty) {
		this.projekty = projekty;
	}
}

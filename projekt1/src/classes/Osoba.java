package classes;

import java.io.Serializable;

public class Osoba implements Serializable{
    private int id;
	 String imie;
	 String nazwisko;
	 
	 public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}

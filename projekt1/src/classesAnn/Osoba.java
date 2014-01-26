package classesAnn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="OSOBA")
@Inheritance(strategy=InheritanceType.JOINED)
public class Osoba implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="ID_OSOBA")
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

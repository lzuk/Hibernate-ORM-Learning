package classesAnn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="PROJEKT")
public class Projekt implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ID_PROJEKT")
    private int id;
	private String nazwa;
	private String opis;
	private Calendar dataPocz;
	private Calendar dataKon;
	
	@ManyToOne
	@JoinColumn(name="ID_KIEROWNIK")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Kierownik kierownik;
	
	@OneToMany
	@JoinColumn(name="ID_PROJEKT")
	@ForeignKey(name="FK_PROJ_ZAP")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Zapotrzebowanie> zapotrzebowanie;
	
	@OneToMany
	@JoinColumn(name="ID_PROJEKT")
	@ForeignKey(name="FK_PROJ_ZAT")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Zatrudnienie> zatrudnienie;

    /**
     * @return the nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * @param nazwa the nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * @return the dataPocz
     */
    public Calendar getDataPocz() {
        return dataPocz;
    }

    /**
     * @param dataPocz the dataPocz to set
     */
    public void setDataPocz(Calendar dataPocz) {
        this.dataPocz = dataPocz;
    }

    /**
     * @return the dataKon
     */
    public Calendar getDataKon() {
        return dataKon;
    }

    /**
     * @param dataKon the dataKon to set
     */
    public void setDataKon(Calendar dataKon) {
        this.dataKon = dataKon;
    }

    /**
     * @return the kierownik
     */
    public Kierownik getKierownik() {
        return kierownik;
    }

    /**
     * @param kierownik the kierownik to set
     */
    public void setKierownik(Kierownik kierownik) {
        this.kierownik = kierownik;
    }

    /**
     * @return the zapotrzebowanie
     */
    public Set<Zapotrzebowanie> getZapotrzebowanie() {
        return zapotrzebowanie;
    }

    /**
     * @param zapotrzebowanie the zapotrzebowanie to set
     */
    public void setZapotrzebowanie(Set<Zapotrzebowanie> zapotrzebowanie) {
        this.zapotrzebowanie = zapotrzebowanie;
    }

    /**
     * @return the zatrudnienie
     */
    public Set<Zatrudnienie> getZatrudnienie() {
        return zatrudnienie;
    }

    /**
     * @param zatrudnienie the zatrudnienie to set
     */
    public void setZatrudnienie(Set<Zatrudnienie> zatrudnienie) {
        this.zatrudnienie = zatrudnienie;
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

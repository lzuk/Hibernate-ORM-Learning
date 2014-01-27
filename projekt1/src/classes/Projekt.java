package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class Projekt implements Serializable {
    private int id;
	private String nazwa;
	private String opis;
	private Calendar dataPocz;
	private Calendar dataKon;
	private Kierownik kierownik;
	private Set<Zapotrzebowanie> zapotrzebowanie;
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

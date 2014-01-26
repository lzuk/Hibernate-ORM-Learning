package classesAnn;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="PROGRAMISTA")
@PrimaryKeyJoinColumn(name="ID_PROGRAMISTA")
@ForeignKey(name="FK_OSOBA_PROGR")
public class Programista extends Osoba implements Serializable{
	@OneToMany
	@JoinColumn(name="ID_PROGRAMISTA")
	@ForeignKey(name="FK_PROGR_JEZYK")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Jezyk> jezyki;
	
	@OneToMany
	@JoinColumn(name="ID_PROGRAMISTA")
	@ForeignKey(name="FK_PROGR_ZAT")
	@Cascade(CascadeType.SAVE_UPDATE)
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

package edu.rsvier.springmvc.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bestand", catalog = "cursisttraject_relatiebeheer")
public class Bestand implements java.io.Serializable {

    private int id;
    private byte[] bestand;
    private Set<Materiaal> materialen;
    private Set<Toets> toetsen;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    @Column(name = "bestand", nullable = false)
    public byte[] getBestand() {
        return this.bestand;
    }

    public void setBestand(byte[] bestand) {
        this.setBestand(bestand);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestand")
    public Set<Materiaal> getMaterialen() {
        return this.materialen;
    }

    public void setMaterialen(Set<Materiaal> materialen) {
        this.materialen = materialen;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestand")
    public Set<Toets> getToetsen() {
        return this.toetsen;
    }

    public void setToetsen(Set<Toets> toetsen) {
        this.toetsen = toetsen;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}

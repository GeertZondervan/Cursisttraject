package edu.rsvier.springmvc.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bestand", catalog = "cursisttraject_relatiebeheer"
)
public class Bestand implements java.io.Serializable {

    private int id;
    private byte[] bestand;
    private Set<Materiaal> materialen = new HashSet<Materiaal>(0);
    private Set<Toets> toetsen = new HashSet<Toets>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "bestand", nullable = false)
    public byte[] getBestand() {
        return this.bestand;
    }

    public void setBestand(byte[] bestand) {
        this.bestand = bestand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestand", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    public Set<Materiaal> getMaterialen() {
        return this.materialen;
    }

    public void setMaterialen(Set<Materiaal> materialen) {
        this.materialen = materialen;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestand", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    public Set<Toets> getToetsen() {
        return this.toetsen;
    }

    public void setToetsen(Set<Toets> toetsen) {
        this.toetsen = toetsen;
    }

    public String toString() {
        return ("Bestand: " + id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Bestand)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Bestand other = (Bestand) obj;

        if (!Arrays.equals(this.bestand, other.bestand)) {
            return false;
        }
        if (this.materialen != other.materialen && (this.materialen == null || !this.materialen.equals(other.materialen))) {
            return false;
        }
        if (this.toetsen != other.toetsen && (this.toetsen == null || !this.toetsen.equals(other.toetsen))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Arrays.hashCode(this.bestand);
        hash = 47 * hash + (this.materialen != null ? this.materialen.hashCode() : 0);
        hash = 47 * hash + (this.toetsen != null ? this.toetsen.hashCode() : 0);
        return hash;
    }

}

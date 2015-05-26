package edu.rsvier.springmvc.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "module", catalog = "cursisttraject_relatiebeheer")
public class Module implements java.io.Serializable {

    private Integer id;
    private Traject traject;
    private String omschrijving;
    private Integer lengteInWeken;
    private Set<Expertise> expertises = new HashSet<Expertise>(0);
    private Set<Toets> toetsen = new HashSet<Toets>(0);
    private Set<Materiaal> materialen = new HashSet<Materiaal>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "traject_id", nullable = false)
    public Traject getTraject() {
        return this.traject;
    }

    public void setTraject(Traject traject) {
        this.traject = traject;
    }

    @Column(name = "omschrijving", length = 16777215)
    public String getOmschrijving() {
        return this.omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Column(name = "lengte_in_weken")
    public Integer getLengteInWeken() {
        return this.lengteInWeken;
    }

    public void setLengteInWeken(Integer lengteInWeken) {
        this.lengteInWeken = lengteInWeken;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    public Set<Expertise> getExpertises() {
        return this.expertises;
    }

    public void setExpertises(Set<Expertise> expertises) {
        this.expertises = expertises;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    public Set<Toets> getToetsen() {
        return this.toetsen;
    }

    public void setToetsen(Set<Toets> toetsen) {
        this.toetsen = toetsen;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "materiaal_has_module",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "materiaal_id")
    )
    public Set<Materiaal> getMaterialen() {
        return materialen;
    }

    public void setMaterialen(Set<Materiaal> materialen) {
        this.materialen = materialen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Module)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Module other = (Module) obj;
        //Wiemer: checken alleen op traject.naam ivm de dateobjecten die maar niet gelijk willen zijn, ondanks dat ze dat wel zijn. problemen met het vergelijken van embedded objects
        if (this.traject.getNaam() != other.traject.getNaam() && (this.traject.getNaam() == null || !this.traject.getNaam().equals(other.traject.getNaam()))) {
            return false;
        }
        if ((this.omschrijving == null) ? (other.omschrijving != null) : !this.omschrijving.equals(other.omschrijving)) {
            return false;
        }
        if (this.lengteInWeken != other.lengteInWeken && (this.lengteInWeken == null || !this.lengteInWeken.equals(other.lengteInWeken))) {
            return false;
        }
        if (this.expertises != other.expertises && (this.expertises == null || !this.expertises.equals(other.expertises))) {
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
        hash = 31 * hash + (this.traject.getNaam() != null ? this.traject.getNaam().hashCode() : 0);
        hash = 31 * hash + (this.omschrijving != null ? this.omschrijving.hashCode() : 0);
        hash = 31 * hash + (this.lengteInWeken != null ? this.lengteInWeken.hashCode() : 0);
        hash = 31 * hash + (this.expertises != null ? this.expertises.hashCode() : 0);
        hash = 31 * hash + (this.toetsen != null ? this.toetsen.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Module{" + "id=" + id + ", traject=" + traject + ", omschrijving=" + omschrijving + ", lengteInWeken=" + lengteInWeken + '}';
    }

}

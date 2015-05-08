package edu.rsvier.springmvc.model;

import java.sql.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "traject", catalog = "cursisttraject_relatiebeheer"
)
public class Traject implements java.io.Serializable {

    private Integer id;
    private String naam;
    private String omschrijving;
    private Date startdatum;
    private Date sluitingsdatum;
    private Set<Module> modules = new HashSet<Module>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "naam", nullable = false, length = 45)
    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Column(name = "omschrijving", length = 65535)
    public String getOmschrijving() {
        return this.omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

   
    @Column(name = "startdatum", length = 10)
    public Date getStartdatum() {
        
        return this.startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    
    @Column(name = "sluitingsdatum", length = 10)
    public Date getSluitingsdatum() {
        return this.sluitingsdatum;
    }

    public void setSluitingsdatum(Date sluitingsdatum) {
        this.sluitingsdatum = sluitingsdatum;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "traject", cascade = {CascadeType.ALL})
    public Set<Module> getModules() {
        return this.modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return ("Traject: " + this.getNaam() + " : " + this.getOmschrijving() + " " + this.getStartdatum() + " " + this.getSluitingsdatum());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Traject)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Traject other = (Traject) obj;

        if ((this.naam == null) ? (other.naam != null) : !this.naam.equals(other.naam)) {
            return false;
        }
        if ((this.omschrijving == null) ? (other.omschrijving != null) : !this.omschrijving.equals(other.omschrijving)) {
            return false;
        }
        if (this.startdatum.toString() != other.startdatum.toString() && (this.startdatum.toString() == null || !this.startdatum.toString().equals(other.startdatum.toString()))) {
            return false;
        }
       
        if (this.modules != other.modules && (this.modules == null || !this.modules.equals(other.modules))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.naam != null ? this.naam.hashCode() : 0);
        hash = 47 * hash + (this.omschrijving != null ? this.omschrijving.hashCode() : 0);
        hash = 47 * hash + (this.startdatum != null ? this.startdatum.hashCode() : 0);
        hash = 47 * hash + (this.sluitingsdatum != null ? this.sluitingsdatum.hashCode() : 0);
        hash = 47 * hash + (this.modules != null ? this.modules.hashCode() : 0);
        return hash;
    }

}

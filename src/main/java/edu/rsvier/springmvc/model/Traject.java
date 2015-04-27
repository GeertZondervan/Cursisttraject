package edu.rsvier.springmvc.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "traject", catalog = "cursisttraject_relatiebeheer")
public class Traject implements java.io.Serializable {

    private Integer id;
    private String naam;
    private String omschrijving;
    private Date startdatum;
    private Date sluitingsdatum;
    private Set<Module> modules;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "startdatum", length = 10)
    public Date getStartdatum() {
        return this.startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "sluitingsdatum", length = 10)
    public Date getSluitingsdatum() {
        return this.sluitingsdatum;
    }

    public void setSluitingsdatum(Date sluitingsdatum) {
        this.sluitingsdatum = sluitingsdatum;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "traject")
    public Set<Module> getModules() {
        return this.modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}

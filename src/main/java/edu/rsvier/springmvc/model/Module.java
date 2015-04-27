package edu.rsvier.springmvc.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "module", catalog = "cursisttraject_relatiebeheer"
)
public class Module implements java.io.Serializable {

    private Integer id;
    private Traject traject;
    private String omschrijving;
    private Integer lengteInWeken;
    private Set<Expertise> expertises;
    private Set<Toets> toetsen;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
    public Set<Expertise> getExpertises() {
        return this.expertises;
    }

    public void setExpertises(Set<Expertise> expertises) {
        this.expertises = expertises;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
    public Set<Toets> getToetsen() {
        return this.toetsen;
    }

    public void setToetsen(Set<Toets> toetsen) {
        this.toetsen = toetsen;
    }

}

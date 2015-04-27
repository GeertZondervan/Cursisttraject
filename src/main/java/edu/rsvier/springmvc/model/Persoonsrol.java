package edu.rsvier.springmvc.model;
// Generated 26-apr-2015 12:53:00 by Hibernate Tools 4.3.1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persoonsrol", catalog = "cursisttraject_relatiebeheer"
)
public class Persoonsrol implements java.io.Serializable {

    private Integer id;
    private Persoon persoon;
    private Rol rol;
    private Date begindatum;
    private Date einddatum;
    private Set<ToetsResultaat> toetsResultaten;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persoon_id", nullable = false)
    public Persoon getPersoon() {
        return this.persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", nullable = false)
    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "begindatum", nullable = false, length = 10)
    public Date getBegindatum() {
        return this.begindatum;
    }

    public void setBegindatum(Date begindatum) {
        this.begindatum = begindatum;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "einddatum", length = 10)
    public Date getEinddatum() {
        return this.einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persoonsrol")
    public Set<ToetsResultaat> getToetsResultaten() {
        return this.toetsResultaten;
    }

    public void setToetsResultaten(Set<ToetsResultaat> toetsResultaten) {
        this.toetsResultaten = toetsResultaten;
    }

}

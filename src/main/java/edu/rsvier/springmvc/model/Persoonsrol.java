package edu.rsvier.springmvc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persoonsrol", catalog = "cursisttraject_relatiebeheer")
public class Persoonsrol implements java.io.Serializable {

    private PersoonsrolId id;
    private Persoon persoon;
    private Rol rol;
    private Date einddatum;
    private Set<ToetsResultaat> toetsResultaten = new HashSet<ToetsResultaat>(0);

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "persoonId", column = @Column(name = "persoon_id", nullable = false)),
        @AttributeOverride(name = "rolId", column = @Column(name = "rol_id", nullable = false)),
        @AttributeOverride(name = "begindatum", column = @Column(name = "begindatum", nullable = false, length = 10))})
    public PersoonsrolId getId() {
        return this.id;
    }

    public void setId(PersoonsrolId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "persoon_id", nullable = false, insertable = false, updatable = false)
    public Persoon getPersoon() {
        return this.persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "rol_id", nullable = false, insertable = false, updatable = false)
    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "einddatum", length = 10)
    public Date getEinddatum() {
        return this.einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persoonsrol", cascade = {CascadeType.ALL})
    public Set<ToetsResultaat> getToetsResultaten() {
        return this.toetsResultaten;
    }

    public void setToetsResultaten(Set<ToetsResultaat> toetsResultaten) {
        this.toetsResultaten = toetsResultaten;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persoonsrol other = (Persoonsrol) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.persoon != other.persoon && (this.persoon == null || !this.persoon.equals(other.persoon))) {
            return false;
        }
        if (this.rol != other.rol && (this.rol == null || !this.rol.equals(other.rol))) {
            return false;
        }

        if (this.toetsResultaten != other.toetsResultaten && (this.toetsResultaten == null || !this.toetsResultaten.equals(other.toetsResultaten))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persoonsrol{" + "id=" + id + ", persoon=" + persoon + ", rol=" + rol + ", einddatum=" + einddatum + ", toetsResultaten=" + toetsResultaten + '}';
    }

}

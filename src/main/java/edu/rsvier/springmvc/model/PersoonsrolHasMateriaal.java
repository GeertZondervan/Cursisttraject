package edu.rsvier.springmvc.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persoonsrol_has_materiaal", catalog = "cursisttraject_relatiebeheer")
public class PersoonsrolHasMateriaal implements java.io.Serializable {

    private PersoonsrolHasMateriaalId id;
    private Persoonsrol persoonsrol;
    private Materiaal materiaal;
    private Character cursistBezit;

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "persoonsrolPersoonId", column = @Column(name = "persoonsrol_persoon_id", nullable = false)),
        @AttributeOverride(name = "persoonsrolRolId", column = @Column(name = "persoonsrol_rol_id", nullable = false)),
        @AttributeOverride(name = "persoonsrolBegindatum", column = @Column(name = "persoonsrol_begindatum", nullable = false, length = 10)),
        @AttributeOverride(name = "materiaalId", column = @Column(name = "materiaal_id", nullable = false))})
    public PersoonsrolHasMateriaalId getId() {
        return this.id;
    }

    public void setId(PersoonsrolHasMateriaalId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "persoonsrol_persoon_id", referencedColumnName = "persoon_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "persoonsrol_rol_id", referencedColumnName = "rol_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "persoonsrol_begindatum", referencedColumnName = "begindatum", nullable = false, insertable = false, updatable = false)})
    public Persoonsrol getPersoonsrol() {
        return persoonsrol;
    }

    public void setPersoonsrol(Persoonsrol persoonsrol) {
        this.persoonsrol = persoonsrol;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "materiaal_id", nullable = false, insertable = false, updatable = false)
    public Materiaal getMateriaal() {
        return this.materiaal;
    }

    public void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }

    @Column(name = "cursist_bezit", length = 1)
    public Character getCursistBezit() {
        return this.cursistBezit;
    }

    public void setCursistBezit(Character cursistBezit) {
        this.cursistBezit = cursistBezit;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.persoonsrol != null ? this.persoonsrol.hashCode() : 0);
        hash = 79 * hash + (this.materiaal != null ? this.materiaal.hashCode() : 0);
        hash = 79 * hash + (this.cursistBezit != null ? this.cursistBezit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PersoonsrolHasMateriaal)) {
            return false;
        }
        final PersoonsrolHasMateriaal other = (PersoonsrolHasMateriaal) obj;
        if (this.persoonsrol != other.persoonsrol && (this.persoonsrol == null || !this.persoonsrol.equals(other.persoonsrol))) {
            return false;
        }
        if (this.materiaal != other.materiaal && (this.materiaal == null || !this.materiaal.equals(other.materiaal))) {
            return false;
        }
        if (this.cursistBezit != other.cursistBezit && (this.cursistBezit == null || !this.cursistBezit.equals(other.cursistBezit))) {
            return false;
        }
        return true;
    }

}

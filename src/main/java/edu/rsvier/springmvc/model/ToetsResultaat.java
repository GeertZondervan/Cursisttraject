package edu.rsvier.springmvc.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "toets_resultaat", catalog = "cursisttraject_relatiebeheer"
)
public class ToetsResultaat implements java.io.Serializable {

    private ToetsResultaatId id;
    private Persoonsrol persoonsrol;
    private Toets toets;
    private Date datum;
    private float resultaat;

    public ToetsResultaat() {
    }

    public ToetsResultaat(ToetsResultaatId id, Persoonsrol persoonsrol, Toets toets, Date datum, float resultaat) {
        this.id = id;
        this.persoonsrol = persoonsrol;
        this.toets = toets;
        this.datum = datum;
        this.resultaat = resultaat;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "persoonsrolPersoonId", column = @Column(name = "persoonsrol_persoon_id", nullable = false)),
        @AttributeOverride(name = "persoonsrolRolId", column = @Column(name = "persoonsrol_rol_id", nullable = false)),
        @AttributeOverride(name = "persoonsrolBegindatum", column = @Column(name = "persoonsrol_begindatum", nullable = false, length = 10)),
        @AttributeOverride(name = "toetsId", column = @Column(name = "toets_id", nullable = false))})
    public ToetsResultaatId getId() {
        return this.id;
    }

    public void setId(ToetsResultaatId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "persoonsrol_persoon_id", referencedColumnName = "persoon_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "persoonsrol_rol_id", referencedColumnName = "rol_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "persoonsrol_begindatum", referencedColumnName = "begindatum", nullable = false, insertable = false, updatable = false)})
    public Persoonsrol getPersoonsrol() {
        return this.persoonsrol;
    }

    public void setPersoonsrol(Persoonsrol persoonsrol) {
        this.persoonsrol = persoonsrol;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "toets_id", nullable = false, insertable = false, updatable = false)
    public Toets getToets() {
        return this.toets;
    }

    public void setToets(Toets toets) {
        this.toets = toets;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datum", nullable = false, length = 10)
    public Date getDatum() {
        return this.datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Column(name = "resultaat", nullable = false, precision = 12, scale = 0)
    public float getResultaat() {
        return this.resultaat;
    }

    public void setResultaat(float resultaat) {
        this.resultaat = resultaat;
    }

    @Override
    public String toString() {
        return "ToetsResultaat{" + "id=" + id + ", persoonsrol=" + persoonsrol + ", toets=" + toets + ", datum=" + datum + ", resultaat=" + resultaat + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ToetsResultaat other = (ToetsResultaat) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
//        if (this.persoonsrol != other.persoonsrol && (this.persoonsrol == null || !this.persoonsrol.equals(other.persoonsrol))) {
//            return false;
//        }
//        if (this.toets != other.toets && (this.toets == null || !this.toets.equals(other.toets))) {
//            return false;
//        }
        if (this.datum != other.datum && (this.datum == null || !this.datum.equals(other.datum))) {
            return false;
        }
        if (Float.floatToIntBits(this.resultaat) != Float.floatToIntBits(other.resultaat)) {
            return false;
        }
        return true;
    }

}

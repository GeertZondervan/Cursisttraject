package edu.rsvier.springmvc.model;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "persoonsrolId", column = @Column(name = "persoonsrol_id", nullable = false)),
        @AttributeOverride(name = "toetsId", column = @Column(name = "toets_id", nullable = false))})
    public ToetsResultaatId getId() {
        return this.id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persoonsrol_id", nullable = false, insertable = false, updatable = false)
    public Persoonsrol getPersoonsrol() {
        return this.persoonsrol;
    }

    public void setPersoonsrol(Persoonsrol persoonsrol) {
        this.persoonsrol = persoonsrol;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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

}

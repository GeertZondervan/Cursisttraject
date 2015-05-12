package edu.rsvier.springmvc.model;

import java.sql.Date;
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
@Table(name = "persoonsrol_has_traject", catalog = "cursisttraject_relatiebeheer"
)
public class PersoonsrolHasTraject implements java.io.Serializable {

    private PersoonsrolHasTrajectId id;
    private Date begindatum;
    private Date einddatum;
    private Character succesvolAfgerond;
    private Persoonsrol persoonsrol;
    private Traject traject;

    public PersoonsrolHasTraject() {
    }

    public PersoonsrolHasTraject(PersoonsrolHasTrajectId id, Date begindatum) {
        this.id = id;
        this.begindatum = begindatum;
    }

    public PersoonsrolHasTraject(PersoonsrolHasTrajectId id, Date begindatum, Date einddatum, Character succesvolAfgerond) {
        this.id = id;
        this.begindatum = begindatum;
        this.einddatum = einddatum;
        this.succesvolAfgerond = succesvolAfgerond;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "persoonsrolPersoonId", column = @Column(name = "persoonsrol_persoon_id", nullable = false)),
        @AttributeOverride(name = "persoonsrolRolId", column = @Column(name = "persoonsrol_rol_id", nullable = false)),
        @AttributeOverride(name = "persoonsrolBegindatum", column = @Column(name = "persoonsrol_begindatum", nullable = false, length = 10)),
        @AttributeOverride(name = "trajectId", column = @Column(name = "traject_id", nullable = false))})
    public PersoonsrolHasTrajectId getId() {
        return this.id;
    }

    public void setId(PersoonsrolHasTrajectId id) {
        this.id = id;
    }

    @Column(name = "begindatum", nullable = false, length = 10)
    public Date getBegindatum() {
        return this.begindatum;
    }

    public void setBegindatum(Date begindatum) {
        this.begindatum = begindatum;
    }

    @Column(name = "einddatum", length = 10)
    public Date getEinddatum() {
        return this.einddatum;
    }

    public void setEinddatum(Date einddatum) {
        this.einddatum = einddatum;
    }

    @Column(name = "succesvol_afgerond", length = 1)
    public Character getSuccesvolAfgerond() {
        return this.succesvolAfgerond;
    }

    public void setSuccesvolAfgerond(Character succesvolAfgerond) {
        this.succesvolAfgerond = succesvolAfgerond;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "traject_id", nullable = false, insertable = false, updatable = false)
    public Traject getTraject() {
        return traject;
    }

    public void setTraject(Traject traject) {
        this.traject = traject;
    }

}
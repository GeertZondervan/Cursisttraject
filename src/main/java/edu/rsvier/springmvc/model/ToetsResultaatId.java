package edu.rsvier.springmvc.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
public class ToetsResultaatId implements java.io.Serializable {

    private int persoonsrolPersoonId;
    private int persoonsrolRolId;
    private LocalDate persoonsrolBegindatum;
    private int toetsId;

    public ToetsResultaatId() {
    }

    public ToetsResultaatId(int persoonsrolPersoonId, int persoonsrolRolId, LocalDate persoonsrolBegindatum, int toetsId) {
        this.persoonsrolPersoonId = persoonsrolPersoonId;
        this.persoonsrolRolId = persoonsrolRolId;
        this.persoonsrolBegindatum = persoonsrolBegindatum;
        this.toetsId = toetsId;
    }

    @Column(name = "persoonsrol_persoon_id", nullable = false)
    public int getPersoonsrolPersoonId() {
        return this.persoonsrolPersoonId;
    }

    public void setPersoonsrolPersoonId(int persoonsrolPersoonId) {
        this.persoonsrolPersoonId = persoonsrolPersoonId;
    }

    @Column(name = "persoonsrol_rol_id", nullable = false)
    public int getPersoonsrolRolId() {
        return this.persoonsrolRolId;
    }

    public void setPersoonsrolRolId(int persoonsrolRolId) {
        this.persoonsrolRolId = persoonsrolRolId;
    }

    @Convert(converter = LocalDatePersistenceConverter.class)
    @Column(name = "persoonsrol_begindatum", nullable = false, length = 10)
    public LocalDate getPersoonsrolBegindatum() {
        return this.persoonsrolBegindatum;
    }

    public void setPersoonsrolBegindatum(LocalDate persoonsrolBegindatum) {
        this.persoonsrolBegindatum = persoonsrolBegindatum;
    }

    @Column(name = "toets_id", nullable = false)
    public int getToetsId() {
        return this.toetsId;
    }

    public void setToetsId(int toetsId) {
        this.toetsId = toetsId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ToetsResultaatId)) {
            System.out.println("niet de juiste class");
            return false;
        }
        ToetsResultaatId castOther = (ToetsResultaatId) other;

        return (this.getPersoonsrolPersoonId() == castOther.getPersoonsrolPersoonId())
                && (this.getPersoonsrolRolId() == castOther.getPersoonsrolRolId())
                && ((this.getPersoonsrolBegindatum() == castOther.getPersoonsrolBegindatum()) || (this.getPersoonsrolBegindatum() != null && castOther.getPersoonsrolBegindatum() != null && this.getPersoonsrolBegindatum().equals(castOther.getPersoonsrolBegindatum())))
                && (this.getToetsId() == castOther.getToetsId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getPersoonsrolPersoonId();
        result = 37 * result + this.getPersoonsrolRolId();
        result = 37 * result + (getPersoonsrolBegindatum() == null ? 0 : this.getPersoonsrolBegindatum().hashCode());
        result = 37 * result + this.getToetsId();
        return result;
    }

}

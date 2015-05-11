package edu.rsvier.springmvc.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersoonsrolHasMateriaalId implements java.io.Serializable {

    private int persoonsrolPersoonId;
    private int persoonsrolRolId;
    private Date persoonsrolBegindatum;
    private int materiaalId;

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

    @Column(name = "persoonsrol_begindatum", nullable = false, length = 10)
    public Date getPersoonsrolBegindatum() {
        return this.persoonsrolBegindatum;
    }

    public void setPersoonsrolBegindatum(Date persoonsrolBegindatum) {
        this.persoonsrolBegindatum = persoonsrolBegindatum;
    }

    @Column(name = "materiaal_id", nullable = false)
    public int getMateriaalId() {
        return this.materiaalId;
    }

    public void setMateriaalId(int materiaalId) {
        this.materiaalId = materiaalId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof PersoonsrolHasMateriaalId)) {
            return false;
        }
        PersoonsrolHasMateriaalId castOther = (PersoonsrolHasMateriaalId) other;

        return (this.getPersoonsrolPersoonId() == castOther.getPersoonsrolPersoonId())
                && (this.getPersoonsrolRolId() == castOther.getPersoonsrolRolId())
                && ((this.getPersoonsrolBegindatum() == castOther.getPersoonsrolBegindatum()) || (this.getPersoonsrolBegindatum() != null && castOther.getPersoonsrolBegindatum() != null && this.getPersoonsrolBegindatum().equals(castOther.getPersoonsrolBegindatum())))
                && (this.getMateriaalId() == castOther.getMateriaalId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getPersoonsrolPersoonId();
        result = 37 * result + this.getPersoonsrolRolId();
        result = 37 * result + (getPersoonsrolBegindatum() == null ? 0 : this.getPersoonsrolBegindatum().hashCode());
        result = 37 * result + this.getMateriaalId();
        return result;
    }

}

package edu.rsvier.springmvc.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersoonsrolId implements java.io.Serializable {

    private int persoonId;
    private int rolId;
    private Date begindatum;

    public PersoonsrolId() {
    }

    public PersoonsrolId(int persoonId, int rolId, Date begindatum) {
        this.persoonId = persoonId;
        this.rolId = rolId;
        this.begindatum = begindatum;
    }

    @Column(name = "persoon_id", nullable = false)
    public int getPersoonId() {
        return this.persoonId;
    }

    public void setPersoonId(int persoonId) {
        this.persoonId = persoonId;
    }

    @Column(name = "rol_id", nullable = false)
    public int getRolId() {
        return this.rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Column(name = "begindatum", nullable = false, length = 10)
    public Date getBegindatum() {
        return this.begindatum;
    }

    public void setBegindatum(Date begindatum) {
        this.begindatum = begindatum;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof PersoonsrolId)) {
            System.out.println("niet de juiste class");
            return false;
        }
        PersoonsrolId castOther = (PersoonsrolId) other;

        return (this.getPersoonId() == castOther.getPersoonId())
                && (this.getRolId() == castOther.getRolId())
                && ((this.getBegindatum() == castOther.getBegindatum()) || (this.getBegindatum() != null && castOther.getBegindatum() != null && this.getBegindatum().equals(castOther.getBegindatum())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getPersoonId();
        result = 37 * result + this.getRolId();
        result = 37 * result + (getBegindatum() == null ? 0 : this.getBegindatum().hashCode());
        return result;
    }

}

package edu.rsvier.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ToetsResultaatId implements java.io.Serializable {

    private int persoonsrolId;
    private int toetsId;

    @Column(name = "persoonsrol_id", nullable = false)
    public int getPersoonsrolId() {
        return this.persoonsrolId;
    }

    public void setPersoonsrolId(int persoonsrolId) {
        this.persoonsrolId = persoonsrolId;
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
            return false;
        }
        ToetsResultaatId castOther = (ToetsResultaatId) other;

        return (this.getPersoonsrolId() == castOther.getPersoonsrolId())
                && (this.getToetsId() == castOther.getToetsId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getPersoonsrolId();
        result = 37 * result + this.getToetsId();
        return result;
    }

}

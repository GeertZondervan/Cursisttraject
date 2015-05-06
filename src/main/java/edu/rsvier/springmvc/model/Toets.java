package edu.rsvier.springmvc.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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

@Entity
@Table(name = "toets", catalog = "cursisttraject_relatiebeheer"
)
public class Toets implements java.io.Serializable {

    private Integer id;
    private Bestand bestand;
    private Module module;
    private String naam;
    private String stof;
    private String status;
    private String omschrijving;
    private Float minimumResultaat;
    private Set<ToetsResultaat> toetsResultaten = new HashSet<ToetsResultaat>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bestand_id")
    public Bestand getBestand() {
        return this.bestand;
    }

    public void setBestand(Bestand bestand) {
        this.bestand = bestand;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Column(name = "naam", nullable = false, length = 20)
    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Column(name = "stof", length = 16777215)
    public String getStof() {
        return this.stof;
    }

    public void setStof(String stof) {
        this.stof = stof;
    }

    @Column(name = "status", length = 20)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "omschrijving", length = 16777215)
    public String getOmschrijving() {
        return this.omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Column(name = "minimum_resultaat", precision = 12, scale = 0)
    public Float getMinimumResultaat() {
        return this.minimumResultaat;
    }

    public void setMinimumResultaat(Float minimumResultaat) {
        this.minimumResultaat = minimumResultaat;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "toets", cascade = {CascadeType.ALL})
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
        final Toets other = (Toets) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.bestand != other.bestand && (this.bestand == null || !this.bestand.equals(other.bestand))) {
            return false;
        }

//        if (this.module != other.module && (this.module == null || !this.module.equals(other.module))) {
//            return false;
//        }
        if ((this.naam == null) ? (other.naam != null) : !this.naam.equals(other.naam)) {
            return false;
        }
        if ((this.stof == null) ? (other.stof != null) : !this.stof.equals(other.stof)) {
            return false;
        }
        if ((this.status == null) ? (other.status != null) : !this.status.equals(other.status)) {
            return false;
        }
        if ((this.omschrijving == null) ? (other.omschrijving != null) : !this.omschrijving.equals(other.omschrijving)) {
            return false;
        }
        if (this.minimumResultaat != other.minimumResultaat && (this.minimumResultaat == null || !this.minimumResultaat.equals(other.minimumResultaat))) {
            return false;
        }
        if (this.toetsResultaten != other.toetsResultaten && (this.toetsResultaten == null || !this.toetsResultaten.equals(other.toetsResultaten))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Toets{" + "id=" + id + ", bestand=" + bestand + ", module=" + module + ", naam=" + naam + ", stof=" + stof + ", status=" + status + ", omschrijving=" + omschrijving + ", minimumResultaat=" + minimumResultaat + ", toetsResultaten=" + toetsResultaten + '}';
    }

}

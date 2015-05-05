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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "persoon", catalog = "cursisttraject_relatiebeheer")
public class Persoon implements java.io.Serializable {

    private Integer id;
    private String voornaam;
    private String achternaam;
    private Set<Persoonsrol> persoonsrollen = new HashSet<Persoonsrol>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "voornaam", nullable = false, length = 45)
    public String getVoornaam() {
        return this.voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    @Column(name = "achternaam", nullable = false, length = 45)
    public String getAchternaam() {
        return this.achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon", cascade = {CascadeType.ALL})
    public Set<Persoonsrol> getPersoonsrollen() {
        return this.persoonsrollen;
    }

    public void setPersoonsrollen(Set<Persoonsrol> persoonsrollen) {
        this.persoonsrollen = persoonsrollen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persoon other = (Persoon) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.voornaam == null) ? (other.voornaam != null) : !this.voornaam.equals(other.voornaam)) {
            return false;
        }
        if ((this.achternaam == null) ? (other.achternaam != null) : !this.achternaam.equals(other.achternaam)) {
            return false;
        }
        if (this.persoonsrollen != other.persoonsrollen && (this.persoonsrollen == null || !this.persoonsrollen.equals(other.persoonsrollen))) {
            return false;
        }
        return true;
    }
   
    
    
    public String toString(){
        return ("Persoon: " + voornaam + ", " + achternaam);
    }

}

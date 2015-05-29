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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persoon", catalog = "cursisttraject_relatiebeheer")
public class Persoon implements java.io.Serializable {

    private Integer id; 
    @Size(min = 2, max = 45)
    private String voornaam;
    @Size(min = 2, max = 45)
    private String achternaam;
    
    
   
    
    private Set<Persoonsrol> persoonsrollen = new HashSet<Persoonsrol>(0);
    private Set<Expertise> expertises = new HashSet<Expertise>(0);
    private Set<String> rolNamen = new HashSet<String>();

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
    
   

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "persoon", cascade = {CascadeType.ALL})
    public Set<Persoonsrol> getPersoonsrollen() {
        return this.persoonsrollen;
    }

    public void setPersoonsrollen(Set<Persoonsrol> persoonsrollen) {
        this.persoonsrollen = persoonsrollen;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "persoon_has_expertise",
            joinColumns = @JoinColumn(name = "persoon_id"),
            inverseJoinColumns = @JoinColumn(name = "expertise_id")
    )
    public Set<Expertise> getExpertises() {
        return expertises;
    }

    public void setExpertises(Set<Expertise> expertises) {
        this.expertises = expertises;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.voornaam != null ? this.voornaam.hashCode() : 0);
        hash = 53 * hash + (this.achternaam != null ? this.achternaam.hashCode() : 0);
        //hash = 53 * hash + (this.persoonsrollen != null ? this.persoonsrollen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Persoon)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Persoon other = (Persoon) obj;

        if ((this.voornaam == null) ? (other.getVoornaam() != null) : !this.voornaam.equals(other.getVoornaam())) {
            return false;
        }
        if ((this.achternaam == null) ? (other.getAchternaam() != null) : !this.achternaam.equals(other.getAchternaam())) {
            return false;
        }
        if (this.persoonsrollen != other.persoonsrollen && (this.persoonsrollen == null || !this.persoonsrollen.equals(other.persoonsrollen))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return (voornaam + ", " + achternaam);
    }

    
    


}

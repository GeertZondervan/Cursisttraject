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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expertise", catalog = "cursisttraject_relatiebeheer")
public class Expertise implements java.io.Serializable {

    private Integer id;
    private Module module;
    private String naam;
    private String omschrijving;
    private Set<Persoon> personen = new HashSet<Persoon>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
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

    @Column(name = "omschrijving")
    public String getOmschrijving() {
        return this.omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "persoon_has_expertise",
            joinColumns = @JoinColumn(name = "expertise_id"),
            inverseJoinColumns = @JoinColumn(name = "persoon_id")
    )
    public Set<Persoon> getPersonen() {
        return personen;
    }

    public void setPersonen(Set<Persoon> personen) {
        this.personen = personen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Expertise)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Expertise other = (Expertise) obj;

        if ((this.naam == null) ? (other.naam != null) : !this.naam.equals(other.naam)) {
            return false;
        }
        
//        if((this.module.getOmschrijving() == null) ? (other.module.getOmschrijving() == null) : !this.module.getOmschrijving().equals(other.module.getOmschrijving())) 
//            return false;       
        
        if ((this.omschrijving == null) ? (other.omschrijving != null) : !this.omschrijving.equals(other.omschrijving)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.naam != null ? this.naam.hashCode() : 0);
        //hash = 79 * hash + (this.module.getOmschrijving() != null ? this.module.getOmschrijving().hashCode() : 0);
        hash = 79 * hash + (this.omschrijving != null ? this.omschrijving.hashCode() : 0);
        return hash;
    }

    public String toString() {
        return ("Expertise: " + getNaam() + ", " + getOmschrijving() + ", " + getModule() + ", " + getId());
    }
}

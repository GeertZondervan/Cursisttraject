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
@Table(name = "rol", catalog = "cursisttraject_relatiebeheer"
)
public class Rol implements java.io.Serializable {

    private Integer id;
    private String naam;
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

    @Column(name = "naam", nullable = false, length = 15)
    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = {CascadeType.ALL})
    public Set<Persoonsrol> getPersoonsrollen() {
        return this.persoonsrollen;
    }

    public void setPersoonsrollen(Set<Persoonsrol> persoonsrollen) {
        this.persoonsrollen = persoonsrollen;
    }

    @Override
    public String toString() {
        return (this.getNaam());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Rol)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Rol other = (Rol) obj;

        if ((this.naam == null) ? (other.getNaam() != null) : !this.naam.equals(other.getNaam())) {
            return false;
        }
//        if (!(this.persoonsrollen.equals(other.persoonsrollen))) {
//            
//            return false;
//        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.naam != null ? this.naam.hashCode() : 0);
        return hash;
    }

}

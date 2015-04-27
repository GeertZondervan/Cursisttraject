package edu.rsvier.springmvc.model;

import java.util.Set;
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
    private Set<Persoonsrol> persoonsrollen;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    @Column(name = "naam", nullable = false, length = 15)
    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    public Set<Persoonsrol> getPersoonsrollen() {
        return this.persoonsrollen;
    }

    public void setPersoonsrollen(Set<Persoonsrol> persoonsrollen) {
        this.persoonsrollen = persoonsrollen;
    }

}

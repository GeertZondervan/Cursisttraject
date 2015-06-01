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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materiaal", catalog = "cursisttraject_relatiebeheer")

public class Materiaal implements java.io.Serializable {

    private Integer id;
    private Bestand bestand;
    private String titel;
    private String auteur;
    private String omschrijving;
    private String url;
    private Integer isbn13;
    private Integer isbn10;
    private Set<Module> modules = new HashSet<Module>(0);
    private Set<PersoonsrolHasMateriaal> heeftPersoonsrollen = new HashSet<PersoonsrolHasMateriaal>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "bestand_id")
    public Bestand getBestand() {
        return this.bestand;
    }

    public void setBestand(Bestand bestand) {
        this.bestand = bestand;
    }

    @Column(name = "titel", nullable = false, length = 45)
    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Column(name = "auteur", length = 45)
    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Column(name = "omschrijving", length = 16777215)
    public String getOmschrijving() {
        return this.omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Column(name = "url", length = 500)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "isbn13")
    public Integer getIsbn13() {
        return this.isbn13;
    }

    public void setIsbn13(Integer isbn13) {
        this.isbn13 = isbn13;
    }

    @Column(name = "isbn10")
    public Integer getIsbn10() {
        return this.isbn10;
    }

    public void setIsbn10(Integer isbn10) {
        this.isbn10 = isbn10;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "materiaal_has_module",
            joinColumns = @JoinColumn(name = "materiaal_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "materiaal", cascade = {CascadeType.ALL})
    public Set<PersoonsrolHasMateriaal> getHeeftPersoonsrollen() {
        return heeftPersoonsrollen;
    }

    public void setHeeftPersoonsrollen(Set<PersoonsrolHasMateriaal> heeftPersoonsrollen) {
        this.heeftPersoonsrollen = heeftPersoonsrollen;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Materiaal)) {
            System.out.println("niet de juiste class");
            return false;
        }
        final Materiaal other = (Materiaal) obj;

        if (this.bestand != other.bestand && (this.bestand == null || !this.bestand.equals(other.bestand))) {
            return false;
        }
        if ((this.titel == null) ? (other.titel != null) : !this.titel.equals(other.titel)) {
            return false;
        }
        if ((this.auteur == null) ? (other.auteur != null) : !this.auteur.equals(other.auteur)) {
            return false;
        }
        if ((this.omschrijving == null) ? (other.omschrijving != null) : !this.omschrijving.equals(other.omschrijving)) {
            return false;
        }
        if ((this.url == null) ? (other.url != null) : !this.url.equals(other.url)) {
            return false;
        }
        if (this.isbn13 != other.isbn13 && (this.isbn13 == null || !this.isbn13.equals(other.isbn13))) {
            return false;
        }
        if (this.isbn10 != other.isbn10 && (this.isbn10 == null || !this.isbn10.equals(other.isbn10))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.bestand != null ? this.bestand.hashCode() : 0);
        hash = 17 * hash + (this.titel != null ? this.titel.hashCode() : 0);
        hash = 17 * hash + (this.auteur != null ? this.auteur.hashCode() : 0);
        hash = 17 * hash + (this.omschrijving != null ? this.omschrijving.hashCode() : 0);
        hash = 17 * hash + (this.url != null ? this.url.hashCode() : 0);
        hash = 17 * hash + (this.isbn13 != null ? this.isbn13.hashCode() : 0);
        hash = 17 * hash + (this.isbn10 != null ? this.isbn10.hashCode() : 0);
        return hash;
    }
}

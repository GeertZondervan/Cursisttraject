package edu.rsvier.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materiaal other = (Materiaal) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
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

}

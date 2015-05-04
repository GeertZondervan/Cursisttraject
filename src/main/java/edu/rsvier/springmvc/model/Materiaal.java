package edu.rsvier.springmvc.model;
// Generated 29-apr-2015 14:52:58 by Hibernate Tools 4.3.1

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

/**
 * Materiaal generated by hbm2java
 */
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

}

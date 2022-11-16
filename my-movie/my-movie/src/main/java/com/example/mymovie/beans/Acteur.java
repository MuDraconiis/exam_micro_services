package com.example.mymovie.beans;

import io.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;
import java.util.List;

public class Acteur {
    //nom, prénom date de naissance et un filmographie

    @ApiModelProperty(notes = "Nom de l'acteur",name="nom",required=true,value="test nom")
    private String nom;
    @ApiModelProperty(notes = "Prénom de l'acteur",name="prenom",required=true,value="test prenom")
    private String prenom;
    @ApiModelProperty(notes = "date de naissance de l'acteur",name="date_naissance",required=true,value="test date_naissance")
    private String date_naissance;
    @ApiModelProperty(notes = "filmographie de l'acteur",name="filmographie",required=true,value="test filmographie")
    private List<Film> filmographie;

    public Acteur(String nom, String prenom, String date_naissance, List<Film> filmographie) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.filmographie = filmographie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public List<Film> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(List<Film> filmographie) {
        this.filmographie = filmographie;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", filmographie=" + filmographie +
                '}';
    }
}

package com.example.mymovie.beans;

import io.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;

public class Film {
 //   titre, réalisateur, acteur principal et date de sortie

    @ApiModelProperty(notes = "Titre du film",name="titre",required=true,value="test titre")
    private String titre;
    @ApiModelProperty(notes = "realisateur du film",name="realisateur",required=true,value="test realisateur")
    private String realisateur;
    @ApiModelProperty(notes = "acteur principal du film",name="acteur_principal",required=true,value="test acteur principal")
    private Acteur acteur_principal;
    @ApiModelProperty(notes = "date sortie du film",name="date_sortie",required=true,value="test date sortie")
    private String date_sortie;

    public Film(String titre, String realisateur, Acteur acteur_principal, String date_sortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteur_principal = acteur_principal;
        this.date_sortie = date_sortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur getActeur_principal() {
        return acteur_principal;
    }

    public void setActeur_principal(Acteur acteur_principal) {
        this.acteur_principal = acteur_principal;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", acteur_principal=" + acteur_principal +
                ", date_sortie=" + date_sortie +
                '}';
    }
}

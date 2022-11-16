package com.example.mymovie.controller;

import com.example.mymovie.beans.Acteur;
import com.example.mymovie.beans.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "ActeurServiceController", description = "REST Apis related to Acteur Entity!!!!")
@RestController
public class ActeurServiceController {

    List<Acteur> acteurs;

    public ActeurServiceController() {

        List<Acteur> acteurs = new ArrayList<>();
        List<Film> films = new ArrayList<>();

        /*Film trainspotting = new Film("Trainspotting", "Danny Boyle", null, new SimpleDateFormat("19/06/1996"));
        Film starwars = new Film("Star Wars 1", "George Lucas", null, new SimpleDateFormat("13/10/1999"));

        Acteur ewan = new Acteur("McGregor", "Ewan", new SimpleDateFormat("31/03/1971"), null);

        trainspotting.setActeur_principal(ewan);
        starwars.setActeur_principal(ewan);

        films.add(trainspotting);
        films.add(starwars);

        ewan.setFilmographie(films);*/

        Acteur liam = new Acteur("Neeson", "Liam", "07/06/1952", null);
        Acteur ewan = new Acteur("McGregor", "Ewan","31/03/1971", null);

        acteurs.add(ewan);
        acteurs.add(liam);

        this.acteurs= acteurs;
    }

    @ApiOperation(value = "Get list of acteurs in the System ", response = Iterable.class, tags = "listActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/listActeurs", method = RequestMethod.GET)
    public List<Acteur> listActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get acteur by nom ", response = Acteur.class, tags = "getByNom")
    @RequestMapping(value = "/acteur/{nom}", method = RequestMethod.GET)
    public Acteur getByNom(@PathVariable String nom) {
        return acteurs.stream().filter(x -> x.getNom().equals(nom)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get acteurs du film by titre film ", response = Acteur.class, tags = "getByTitreFilm")
    @RequestMapping(value = "/acteursDuFilm/{titrefilm}", method = RequestMethod.GET)
    public List<Acteur> getActeursByTitreFilm(@PathVariable String titre) {
      //  return acteurs.stream().filter(x -> x.getNom().equals(nom)).collect(Collectors.toList()).get(0);
        return null;
    }

    @ApiOperation(value = "Update acteur in list", response = Acteur.class, tags = "update")
    @RequestMapping(value = "/updateActeur/{nom}", method = RequestMethod.GET)
    public List<Acteur> update(@PathVariable String nom) {
        for (int i = 0; i < acteurs.size(); i++) {
            Acteur acteur = acteurs.get(i);
            if(acteur.getNom().equals(nom)) {
                acteur.setNom("patate");
                acteur.setPrenom("patate");
                acteurs.set(i, acteur);
            }
        }
        return acteurs;
    }

    @ApiOperation(value = "Delete acteur by nom ", response = Acteur.class, tags = "delete")
    @RequestMapping(value = "/deleteActeur/{nom}", method = RequestMethod.GET)
    public List<Acteur> delete(@PathVariable String nom){
        for (int i = 0; i < acteurs.size(); i++) {
            Acteur acteur = acteurs.get(i);
            if(acteur.getNom().equals(nom)) acteurs.remove(acteur);
        }
        return acteurs;
    }
}

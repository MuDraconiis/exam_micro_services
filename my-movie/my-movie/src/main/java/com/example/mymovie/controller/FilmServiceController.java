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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "FilmServiceController", description = "REST Apis related to Film Entity!!!!")
@RestController
public class FilmServiceController {

    List<Film> films;

    public FilmServiceController() {
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

        Film trainspotting = new Film("Trainspotting", "Danny Boyle", null, "19/06/1996");
        Film starwars = new Film("Star Wars 1", "George Lucas", null, "13/10/1999");

        films.add(trainspotting);
        films.add(starwars);

        this.films = films;

    }

    @ApiOperation(value = "Get list of films in the System ", response = Iterable.class, tags = "listFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/listFilms", method = RequestMethod.GET)
    public List<Film> listFilms(){
        return films;
    }

    @ApiOperation(value = "Get film by titre ", response = Film.class, tags = "getByTitre")
    @RequestMapping(value = "/film/{titre}", method = RequestMethod.GET)
    public Film getByTitre(@PathVariable String titre) {
        return films.stream().filter(x -> x.getTitre().equals(titre)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get film by date sortie ", response = Film.class, tags = "getByAnneeSortie")
    @RequestMapping(value = "/film/{date_sortie}", method = RequestMethod.GET)
    public List<Film> getByAnneeSortie(@PathVariable String date_sortie) {
        List<Film> lesfilms= new ArrayList<>();

        for (int i = 0; i < films.size(); i++) {
            Film film = films.get(i);
            String date = film.getDate_sortie();
            String annee = date.substring(date.length()-4);

            if(annee.equals(date_sortie)) lesfilms.add(film);
        }

        return lesfilms;
    }

    @ApiOperation(value = "Update film in list", response = Film.class, tags = "update")
    @RequestMapping(value = "/updateFilm/{titre}", method = RequestMethod.GET)
    public List<Film> update(@PathVariable String titre) {
        for (int i = 0; i < films.size(); i++) {
            Film film = films.get(i);
            if(film.getTitre().equals(titre)) {
                film.setTitre("Welcome to patate Land");
                films.set(i, film);
            }
        }
        return films;
    }

    @ApiOperation(value = "Delete film by titre ", response = Film.class, tags = "delete")
    @RequestMapping(value = "/deleteFilm/{titre}", method = RequestMethod.GET)
    public List<Film> delete(@PathVariable String titre){
        for (int i = 0; i < films.size(); i++) {
            Film film = films.get(i);
            if(film.getTitre().equals(titre)) films.remove(film);
        }
        return films;
    }

}

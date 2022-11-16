package com.howtodoinjava.example.apigateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Api
public class MovieController {
	
	@Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get list of acteurs in the System ", response = Iterable.class, tags = "listActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/acteurs", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeurs()
    {

        String response = restTemplate.exchange("http://my-movie/listActeurs",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return " [ Liste des acteurs " + response+" ]";
    }

    @ApiOperation(value = "Get list of films in the System ", response = Iterable.class, tags = "listFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/films", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getFilms()
    {

        String response = restTemplate.exchange("http://my-movie/listFilms",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return " [ Liste des films " + response+" ]";
    }


    @ApiOperation(value="")
    @RequestMapping(value = "/acteur/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeurByNom(@PathVariable String nom)
    {
        String response = restTemplate.exchange("http://my-movie/acteur/{nom}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, nom).getBody();
 
        System.out.println("Response Body " + response);
 
        return " [ Acteurs Details " + response+" ]";
    }

    @ApiOperation(value="")
    @RequestMapping(value = "/acteursDuFilm/{titrefilm}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeursByTitre(@PathVariable String titre)
    {
        String response = restTemplate.exchange("http://my-movie/acteursDuFilm/{titrefilm}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, titre).getBody();

        System.out.println("Response Body " + response);

        return " [ Acteurs du film " + response+" ]";
    }

    @ApiOperation(value="")
    @RequestMapping(value = "/updateActeur/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getUpdateActeur(@PathVariable String nom)
    {
        String response = restTemplate.exchange("http://my-movie/updateActeur/{nom}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, nom).getBody();

        System.out.println("Response Body " + response);

        return " [ Acteurs  " + response+" ]";
    }

    @ApiOperation(value="")
    @RequestMapping(value = "/deleteActeur/{nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getDeleteActeur(@PathVariable String nom)
    {
        String response = restTemplate.exchange("http://my-movie/deleteActeur/{nom}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, nom).getBody();

        System.out.println("Response Body " + response);

        return " [ Acteurs  " + response+" ]";
    }

    @ApiOperation(value="")
    @RequestMapping(value = "/film/{titre}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getFilmByTitre(@PathVariable String titre)
    {
        String response = restTemplate.exchange("http://my-movie/film/{titre}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, titre).getBody();

        System.out.println("Response Body " + response);

        return " [ Films Details " + response+" ]";
    }

    @ApiOperation(value="")
    @RequestMapping(value = "/film/{date_sortie}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getFilmByAnnee(@PathVariable String date_sortie)
    {
        String response = restTemplate.exchange("http://my-movie/film/{date_sortie}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, date_sortie).getBody();

        System.out.println("Response Body " + response);

        return " [ Films Details " + response+" ]";
    }

    @ApiOperation(value="")
    @RequestMapping(value = "/updateFilm/{titre}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getUpdateFilm(@PathVariable String titre)
    {
        String response = restTemplate.exchange("http://my-movie/updateFilm/{titre}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, titre).getBody();

        System.out.println("Response Body " + response);

        return " [ Films  " + response+" ]";
    }


    @ApiOperation(value="")
    @RequestMapping(value = "/deleteFilm/{titre}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getDeleteFilm(@PathVariable String titre)
    {
        String response = restTemplate.exchange("http://my-movie/deleteFilm/{titre}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, titre).getBody();

        System.out.println("Response Body " + response);

        return " [ Films  " + response+" ]";
    }
    public String  fallbackMethod(){
    	
    	return "Fallback response:: erreur quelque part";
    }
 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.stasiuk.automation.rest.steps.serenity;

import com.apiRequests.URLBuilder;
import com.apiResponses.CharacterResponse;
import com.apiResponses.FilmResponse;
import com.apiResponses.PlanetResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class ApiSteps {

    CharacterResponse characterResponse;
    PlanetResponse planetResponse;
    FilmResponse filmResponse;



    @Step("Find character by id {0}")
    public void  findCharacterById(String id) throws Exception {
       characterResponse =  SerenityRest.with().get(URLBuilder.people(id)).then()
                .assertThat().statusCode(200)
                .extract().as(CharacterResponse.class);
    }

    @Step("Get name of character")
    public String getCharacterName() throws Exception {
        return characterResponse.getName();
    }

    @Step("Find planet by id {0}")
    public void  findPlanet() throws Exception {
        planetResponse = SerenityRest.with().get(characterResponse.getHomeworld()).then()
                .assertThat().statusCode(200)
                .extract().as(PlanetResponse.class);
    }

    @Step("Get planet name")
    public String getPlanetName() throws Exception {
         return planetResponse.getName();
    }

    @Step("Get planet name")
    public String getPlanetPopilation() throws Exception {
        return planetResponse.getPopulation();
    }

    @Step("Find films")
    public void findFilm(int filmNum) throws Exception {
        filmResponse = SerenityRest.with().get(planetResponse.getFilms().get(filmNum - 1)).then()
                .assertThat().statusCode(200)
                .extract().as(FilmResponse.class);
    }

    @Step("Get film name")
    public String getFilmName() throws Exception {
        return filmResponse.getTitle();
    }

    @Step("Is character with id {0} in film's list")
    public boolean isCharacterInFilm (String id) {
        for ( String character : filmResponse.getCharacters()) {
            if (character.equals(URLBuilder.people(id))) return true;
        }
        return false;
        }

    @Step("Is planet {0} in film's list")
    public boolean isPlanetInFilm (String id) {
        for ( String planet : filmResponse.getPlanets()) {
            if (planet.equals(characterResponse.getHomeworld())) return true;
        }
        return false;
    }

    }











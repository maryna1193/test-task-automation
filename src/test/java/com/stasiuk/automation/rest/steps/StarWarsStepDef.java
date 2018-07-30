package com.stasiuk.automation.rest.steps;


import com.stasiuk.automation.rest.steps.serenity.ApiSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;


public class StarWarsStepDef {

    @Steps
    ApiSteps api;

    @Given("^an character (.*) with id (.*)$")
    public void an_character__with_id(String name, String id) throws Exception {
        Serenity.setSessionVariable("characterId").to(id);
        api.findCharacterById(id);
        assertThat(api.getCharacterName()).as("Is the name correct?" +
                " present?").isEqualTo(name);

    }

    @Given("^his planet is (.*) with population (.*)$")
    public void his_planet_with_population(String planet, String population) throws Exception {
        Serenity.setSessionVariable("planetName").to(planet);
        api.findPlanet();
        assertThat(api.getPlanetName()).as("Is the planet's name correct?").isEqualTo(planet);
        assertThat(api.getPlanetPopilation()).as("Is the planet's population correct?").isEqualTo(population);
    }

    @When("^I find (\\d+)st film for his planet$")
    public void i_find_film_for_his_planet(int filmNumber) throws Exception {
        api.findFilm(filmNumber);
    }

    @Then("^film (.*) is displayed$")
    public void film_is_displayed(String title) throws Exception {
        assertThat(api.getFilmName()).as("Is the film's name correct?").isEqualTo(title);
    }

    @Then("^character and his planet belong to that film$")
    public void character_and_his_planet_belong_to_that_film() throws Exception {
        assertThat(api.isCharacterInFilm(Serenity.sessionVariableCalled("characterId"))).as("Is character in film?").isTrue();
        assertThat(api.isPlanetInFilm(Serenity.sessionVariableCalled("planetName"))).as("Is planet in film?").isTrue();
    }
}

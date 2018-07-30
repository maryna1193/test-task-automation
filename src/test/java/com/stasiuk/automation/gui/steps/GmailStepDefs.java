package com.stasiuk.automation.gui.steps;


import com.stasiuk.automation.gui.steps.serenity.LoginSteps;
import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GmailStepDefs {

    @Steps
    LoginSteps signIn;

    @Given("^an user on login page$")
    public void an_user_on_login_page() throws Exception {
       signIn.openHomePage();
    }

    @When("^she decides to sign in  with login (.*) and password (.*)$")
    public void she_decides_to_sign_in_with_login_and_password_(String login, String password) throws Exception {
        signIn.signIn(login, password);
    }

    @Then("^user is logged in her profile$")
    public void user_is_logged_in_her_profile() throws Exception {
        assertThat(signIn.checkMessagePresent()).as("Is welcome message present?").isTrue();
    }

    @Then("^user is not logged in her profile$")
    public void user_is_not_logged_in_her_profile() throws Exception {
        assertThat(signIn.checkMessagePresent()).as("Is welcome message" +
                " present?").isFalse();
    }

}

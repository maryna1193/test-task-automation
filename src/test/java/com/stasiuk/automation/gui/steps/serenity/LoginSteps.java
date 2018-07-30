package com.stasiuk.automation.gui.steps.serenity;


import com.stasiuk.automation.gui.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    LoginPage loginPage;

    @Step("Open the Home Page")
    public void openHomePage() {
        loginPage.open();
    }

    @Step("Sign in with login {0} and password {1}")
    public void signIn(String login, String password) {
        loginPage.typeLogin(login);
        loginPage.clickIdentNextButton();
        loginPage.typePassword(password);
        loginPage.clickPasswordNextButton();
    }

    @Step("Check inbox visible")
    public boolean checkInboxVisible() {
        return loginPage.checkInboxLinkPresent();
    }

    @Step("Check welcome message")
    public boolean checkMessagePresent() {
        return loginPage.checkWelcomeMessagePresent();
    }

}

package com.stasiuk.automation.gui.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://accounts.google.com/signin")
public class LoginPage extends PageObject {

    @FindBy(id = "identifierId")
    WebElementFacade loginField;

    @FindBy(css = "#identifierNext")
    WebElementFacade identNextButton;

    @FindBy(css = "#passwordNext")
    WebElementFacade passwordNextButton;

    @FindBy(name = "password")
    WebElementFacade passwordField;


    @FindBy(linkText = "https://mail.google.com/mail/#inbox")
    WebElementFacade inboxLink;

    @FindBy(xpath = "//*[contains(text(), 'Welcome,')]", timeoutInSeconds = "5")
    WebElementFacade welcomeMesage;

    public void typeLogin (String login) {
        typeInto(loginField.waitUntilEnabled(), login);
    }

    public void clickIdentNextButton() {
        identNextButton.click();
    }

    public void clickPasswordNextButton() {
        passwordNextButton.click();
    }

    public void typePassword (String password) {
        typeInto(passwordField.waitUntilEnabled(), password);
    }

    public boolean checkInboxLinkPresent() {
        inboxLink.withTimeoutOf(10, TimeUnit.SECONDS).waitUntilVisible();
        return  inboxLink.isVisible();
    }

    public boolean checkWelcomeMessagePresent() {
        return  welcomeMesage.isVisible();
    }

}

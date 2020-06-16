package com.volsu.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class SignInForm extends MainPage {
// форма для предварительного ввода email
    private final By formContainer = By.id("create-account_form");
    private final By emailAddressInput = By.id("email_create");
    private final By createAccountButton = By.id("SubmitCreate");

    public SignInForm(WebDriver webDriver ) {
        super(webDriver);
    }

    // ввести email
    public void fillForm(String email) {
        this.waitForElementDisplayed(formContainer);
        webDriver.findElement(emailAddressInput).sendKeys(email);
    }

    // кликнуть кнопку создания аккаунта
    public void clickCreateAccountButton() {
        webDriver.findElement(createAccountButton).click();
    }
}

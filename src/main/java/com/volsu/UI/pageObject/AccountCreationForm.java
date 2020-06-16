package com.volsu.UI.pageObject;
import com.volsu.UI.Models.Account;

import com.volsu.UI.utils.RegistrationErrors;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Setter
@Getter
@Component
public class AccountCreationForm extends MainPage {
    private static final Logger log = LogManager.getLogger(AccountCreationForm.class);

// полная форма создания аккаунта
    private By formContainer = By.id("account-creation_form");

    private By titleMr = By.id("id_gender1");

    private By titleMrs = By.id("id_gender2");

    private By firstNamePersonalInfo = By.id("customer_firstname");

    private By lastNamePersonalInfo = By.id("customer_lastname");

    private By email = By.id("email");

    private By password = By.id("passwd");

    private By birthDay = By.id("days");

    private By birthMonth = By.id("months");

    private By birthYear = By.id("years");

    private By newsletter = By.id("newsletter");

    private By specialOffers = By.id("optin");

    private By firstNameYourAddress = By.id("firstname");

    private By lastNameYourAddress = By.id("lastname");

    private By company = By.id("company");

    private By address = By.id("address1");

    private By address2 = By.id("address2");

    private By city = By.id("city");

    private By state = By.id("id_state");

    private By postalCode = By.id("postcode");

    private By country = By.id("id_country");

    private By additionalInfo = By.id("other");

    private By homePhone = By.id("phone");

    private By mobilePhone = By.id("phone_mobile");

    private By addressAlias = By.id("alias");

    private By submitButton = By.id("submitAccount");

    public AccountCreationForm(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isFormDisplayed() {
        log.debug("Wait for form to be shown.");
        this.waitForElementDisplayed(formContainer);
        return true;
    }

    public void chooseGender(String gend) {
        log.info("Choose gender.");
        if (gend.equals("male"))
            webDriver.findElement(titleMr).click();
        else if (gend.equals("female"))
            webDriver.findElement(titleMrs).click();
    }

    public void fillFirstNamePersonalInfo(String name) {
        log.info("Fill field with locator: {}", firstNamePersonalInfo.toString());
        webDriver.findElement(firstNamePersonalInfo).sendKeys(name);
    }

    public void fillLastNamePersonalInfo(String lName) {
        log.info("Fill field with locator: {}", lastNamePersonalInfo.toString());
        webDriver.findElement(lastNamePersonalInfo).sendKeys(lName);
    }

    public void fillEmail(String mail) {
        log.info("Fill field with locator: {}", email.toString());
        webDriver.findElement(email).clear();
        webDriver.findElement(email).sendKeys(mail);
    }

    public void fillPassword(String pswd) {
        log.info("Fill field with locator: {}", password.toString());
        webDriver.findElement(password).sendKeys(pswd);
    }

    public void fillBirthDay(String day) {
        log.info("Choose day of birth");
        Select drpDay = new Select(webDriver.findElement(birthDay));
        drpDay.selectByValue(day);
    }

    public void fillBirthMonth(String month) {
        log.info("Choose month of birth");
        Select drpDay = new Select(webDriver.findElement(birthMonth));
        drpDay.selectByValue(month);
    }

    public void fillBirthYear(String year) {
        log.info("Choose year of birth");
        Select drpDay = new Select(webDriver.findElement(birthYear));
        drpDay.selectByValue(year);
    }

    public void clickNewslwtter() {
        log.info("Click newsletter checkbox");
        webDriver.findElement(newsletter).click();
    }

    public void clickSpecialOffers() {
        log.info("Click special offers checkbox");
        webDriver.findElement(specialOffers).click();
    }

    public void fillFirstNameYourAddress(String name) {
        log.info("Fill field with locator: {}", firstNameYourAddress.toString());
        webDriver.findElement(firstNameYourAddress).sendKeys(name);
    }

    public void fillLastNameYourAddress(String lName) {
        log.info("Fill field with locator: {}", lastNameYourAddress.toString());
        webDriver.findElement(lastNameYourAddress).sendKeys(lName);
    }

    public void fillCompany(String company) {
        log.info("Fill field with locator: {}", company.toString());
        webDriver.findElement(this.company).sendKeys(company);
    }

    public void fillAddress(String address) {
        log.info("Fill field with locator: {}", address.toString());
        webDriver.findElement(this.address).sendKeys(address);
    }

    public void fillAddress2(String address) {
        log.info("Fill field with locator: {}", address2.toString());
        webDriver.findElement(this.address2).sendKeys(address);
    }

    public void fillCity(String city) {
        log.info("Fill field with locator: {}", city.toString());
        webDriver.findElement(this.city).sendKeys(city);
    }

    public void fillState(String state) {
        log.info("Choose state");
        Select drpState = new Select(webDriver.findElement(this.state));
        drpState.selectByVisibleText(state);
    }

    public void fillPostalCode(String code) {
        log.info("Fill field with locator: {}", postalCode.toString());
        webDriver.findElement(this.postalCode).sendKeys(code);
    }

    public void fillCountry(String country) {
        log.info("Choose country");
        Select drpCountry = new Select(webDriver.findElement(this.country));
        drpCountry.selectByVisibleText(country);
    }

    public void fillAdditionalInfo(String info) {
        log.info("Fill field with locator: {}", additionalInfo.toString());
        webDriver.findElement(this.additionalInfo).sendKeys(info);
    }

    public void fillHomePhone(String phone) {
        log.info("Fill field with locator: {}", homePhone.toString());
        webDriver.findElement(this.homePhone).sendKeys(phone);
    }

    public void fillMobilePhone(String phone) {
        log.info("Fill field with locator: {}", mobilePhone.toString());
        webDriver.findElement(this.mobilePhone).sendKeys(phone);
    }

    public void fillAddressAlias(String alias) {
        log.info("Fill field with locator: {}", addressAlias.toString());
        webDriver.findElement(this.addressAlias).sendKeys(alias);
    }

    public void clickSubmitButton() {
        log.info("Click submit button");
        webDriver.findElement(this.submitButton).click();
    }

    public void fullRegistration(Account account) {
        Assert.assertTrue(isFormDisplayed());
        chooseGender(account.getGender());
        fillFirstNamePersonalInfo(account.getFirstName());
        fillLastNamePersonalInfo(account.getLastName());
        fillPassword(account.getPassword());
        fillBirthDay(account.getBirthDay());
        fillBirthMonth(account.getBirthMonth());
        fillBirthYear(account.getBirthYear());

        if (account.isNewsletter()) clickNewslwtter();
        if (account.isSpecialOffers()) clickSpecialOffers();

        fillCompany(account.getCompany());
        fillAddress(account.getAddress());
        fillAddress2(account.getAddress2());
        fillCity(account.getCity());
        fillState(account.getState());
        fillPostalCode(account.getPostalCode());
        fillCountry(account.getCountry());
        fillAdditionalInfo(account.getAdditionalInfo());
        fillHomePhone(account.getHomePhone());
        fillMobilePhone(account.getMobilePhone());
        fillAddressAlias(account.getAddressAlias());

        clickSubmitButton();
    }

    public boolean isRegistrationSuccessful() {
        By myAccount = By.id("my-account");
        this.waitForElementDisplayed(myAccount);
        return webDriver.findElements(myAccount).size() != 0;
    }

    public void registrationNoRequiredFields(Account account) {

        Assert.assertTrue(isFormDisplayed());

        chooseGender(account.getGender());
        fillEmail("");

        fillBirthDay(account.getBirthDay());
        fillBirthMonth(account.getBirthMonth());
        fillBirthYear(account.getBirthYear());

        if (account.isNewsletter()) clickNewslwtter();
        if (account.isSpecialOffers()) clickSpecialOffers();

        fillCompany(account.getCompany());
        fillAddress2(account.getAddress2());
        fillState(account.getState());
        fillCountry(account.getCountry());
        fillAdditionalInfo(account.getAdditionalInfo());

        clickSubmitButton();
    }

    public boolean errorMessageCheck() {
       By myAccount = By.className("alert-danger");
        this.waitForElementDisplayed(myAccount);
        String bodyText = webDriver.findElement(myAccount).getText();

        return (webDriver.findElements(myAccount).size() != 0) &&
                bodyText.contains(RegistrationErrors.noPhoneNumber) &&
                bodyText.contains(RegistrationErrors.noLastname) &&
                bodyText.contains(RegistrationErrors.noFirstame) &&
                bodyText.contains(RegistrationErrors.noEmail) &&
                bodyText.contains(RegistrationErrors.noPasswd) &&
                bodyText.contains(RegistrationErrors.noAddress1) &&
                bodyText.contains(RegistrationErrors.noCity) &&
                bodyText.contains(RegistrationErrors.invalidPostalCode);
    }
}
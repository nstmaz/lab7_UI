package com.volsu.UI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
// первая страница сайта
    private static final int timeout = 6000;

    protected WebDriver webDriver;

    private By signInButton = By.className("login");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // нажать кнопку SignIn
    public void clickSignIn() {
        webDriver.findElement(signInButton).click();
    }

    // подождать отображения элемента на странице
    public void waitForElementDisplayed(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
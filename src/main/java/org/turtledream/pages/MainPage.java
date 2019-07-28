package org.turtledream.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.turtledream.annotations.FieldName;

public class MainPage extends BasePage {

    @FieldName(name = "Войти")
    @FindBy(xpath = "//span[contains(text(),'Войти')]//parent::div")
    public WebElement signIn;

    @FieldName(name = "Войти по почте")
    @FindBy(xpath = "//a[contains(text(),'Войти по почте')]")
    public WebElement signInEmail;

    @FieldName(name = "Почта")
    @FindBy(xpath = "//input[@data-test-id='emailField']")
    public WebElement email;

    @FieldName(name = "Пароль")
    @FindBy(xpath = "//input[@data-test-id='passwordField']")
    public WebElement password;

    @FieldName(name = "Вход")
    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    public WebElement login;

    @FieldName(name = "Поисковая строка")
    @FindBy(xpath = "//input[@class='search-input']")
    public WebElement searchLine;

    @FieldName(name = "Поиск")
    @FindBy(xpath = "//div[@class='search-button-wrap']//button")
    public WebElement searchButton;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "org.turtledream.pages.MainPage");
    }
}

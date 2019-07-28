package org.turtledream.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.turtledream.annotations.FieldName;

import java.util.List;

public class CartPage extends BasePage{

    @FieldName(name = "Товары")
    @FindBy(xpath = "//div[@class='split simple m-first m-last']")
    public List<WebElement> products;

    @FieldName(name = "Итого")
    @FindBy(xpath = "//div[@class='row m-big']//*//span[@class='main']")
    public WebElement finallyPrice;

    @FieldName(name = "Выбрать всё")
    @FindBy(xpath = "//button[contains(text(), 'Выбрать всё')]")
    public WebElement selectAll;

    @FieldName(name = "Удалить выбранные")
    @FindBy(xpath = "//button[@data-test-id='cart-delete-selected-btn']")
    public WebElement deleteSelect;

    @FieldName(name = "Удалить")
    @FindBy(xpath = "//div[@class='buttons m-single']//button[contains(text(),'Удалить')]")
    public WebElement delete;

    @FieldName(name = "Аккаунт")
    @FindBy(xpath = "//div[@data-test-id='header-my-ozon-icon']//parent::div[@tabindex='0']")
    public WebElement account;

    @FieldName(name = "Выйти")
    @FindBy(xpath = "//button[contains(text(), 'Выйти')]")
    public WebElement exit;

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

    @FieldName(name = "Удалить для физ")
    @FindBy(xpath = "//button[contains(text(), 'Удалить все')]")
    public WebElement deletef;

    @FieldName(name = "Корзина")
    @FindBy(xpath = "//div[@class='split-title']")
    public WebElement cart;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "org.turtledream.pages.CartPage");
    }
}

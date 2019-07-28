package org.turtledream.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.turtledream.annotations.FieldName;

public class SearchResultPage extends BasePage {

    @FieldName(name = "Цена до")
    @FindBy(xpath = "//div[contains(text(),'Цена')]//parent::div//*//input[@data-test-id='range-filter-to-input']")
    public WebElement price;

    @FieldName(name = "Корзина")
    @FindBy(xpath = "//span[contains(text(), 'Корзина')]//parent::a")
    public WebElement cart;

    @FieldName(name = "Флиппер")
    @FindBy(xpath = "//div[@class='flipper m-right']")
    public WebElement flipper;

    @FieldName(name = "Закрыть")
    @FindBy(xpath = "//button[@class='close']")
    public WebElement closer;

    @FieldName(name = "Посмотреть все")
    @FindBy(xpath = "//div[@data-test-id='filter-block-brand']//span[@class='show']")
    public WebElement viewAll;

    @FieldName(name = "Бренды")
    @FindBy(xpath = "//div[@data-test-id='filter-block-brand']//form//input")
    public WebElement brends;

    @FieldName(name = "Искать")
    @FindBy(xpath = "//button[contains(@class, \"search-\")]")
    public WebElement srchBtn;

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "org.turtledream.pages.SearchResultPage");
    }
}

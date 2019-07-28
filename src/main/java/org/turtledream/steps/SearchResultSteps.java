package org.turtledream.steps;

import cucumber.api.java.ru.Когда;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.turtledream.pages.SearchResultPage;
import org.turtledream.utils.DriverManager;

public class SearchResultSteps {

    SearchResultPage searchResultPage = null;

    @Когда("Страница 'Результат поиска' загружена")
    public void pageLoaded() throws Exception {
        searchResultPage = new SearchResultPage();
    }

    @Когда("Клик на \"(.*)\"")
    public void click(String name) throws Exception {
        searchResultPage.click(name);
    }

    @Когда("Ввод в поле \"(.*)\" значения \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        DriverManager.getDriver().get("https://www.ozon.ru/category/telefony-i-smart-chasy-15501/?price=13.000%3B60000.000&text=iphone&from_global=true");
    }

    @Когда("Добавить в корзину товары")
    public void addProducts() throws InterruptedException {

        for(int i = 1; i <= 15; i += 2){

            WebElement webElementTitle = DriverManager.getDriver().findElement(By.xpath("//div[@data-index='" + i + "']//*//a[@id='name']"));

            Actions mouseHover = new Actions(DriverManager.getDriver());
            mouseHover.moveToElement(webElementTitle).perform();

            searchResultPage.productNames.add((DriverManager.getDriver()
                    .findElement(By.xpath("//div[@data-v-febbae54][@data-v-11a8aaee]//div[@class='widget-search-result-container content'][1]//*//div[@data-index='" + i + "']//*//a[@id='name']")).getText()));

            WebElement webElement = DriverManager.getDriver().findElement(By.xpath("//div[@data-v-febbae54][@data-v-11a8aaee]//div[@class='widget-search-result-container content'][1]//*//div[@data-index='" + i + "']//*//span[contains(text(), 'В корзину')]//parent::button"));

            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);
            mouseHover.moveToElement(webElement).perform();

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
    }
}

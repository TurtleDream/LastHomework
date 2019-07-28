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
        searchResultPage.fillField(name, value);
    }

    @Когда("Цена до \"(.*)\"")
    public void setValue(String value){
        if (value.equals("60000")){
            DriverManager.getDriver().get("https://www.ozon.ru/category/telefony-i-smart-chasy-15501/?price=13.000%3B60000.000&text=iphone&from_global=true");
        }
        else {
            DriverManager.getDriver().get("https://www.ozon.ru/category/naushniki-i-garnitury-15546/?price=243.000%3B10000.000&text=%D0%B1%D0%B5%D1%81%D0%BF%D1%80%D0%BE%D0%B2%D0%BE%D0%B4%D0%BD%D1%8B%D0%B5+%D0%BD%D0%B0%D1%83%D1%88%D0%BD%D0%B8%D0%BA%D0%B8");
        }
    }

    @Когда("Выбрать бренд \"(.*)\"")
    public void selectBrand(String name){
        DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'"+ name +"')]//parent::label//input")).click();
    }

    @Когда("Добавить в корзину товары \"(.*)\"")
    public void addProducts(String value) throws InterruptedException {
        if(value.equals("чет")){
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
        else {
            for(int i = 0; i <= 14; i += 2){

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
}

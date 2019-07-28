package org.turtledream.steps;

import cucumber.api.java.ru.Когда;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.turtledream.pages.BasePage;
import org.turtledream.pages.CartPage;
import org.turtledream.utils.DriverManager;

public class CartSteps {

    CartPage cartPage = null;

    @Когда("Страница 'Корзина' загружена")
    public void pageLoaded2() throws Exception {
        cartPage = new CartPage();
    }

    @Когда("Нажать на \"(.*)\"")
    public void click2(String name) throws Exception {
        cartPage.click(name);
    }

    @Когда("Проверка наличия продуктов в корзине")
    public void checkProducts2() throws InterruptedException {
        cartPage.wait.until(ExpectedConditions.visibilityOf(cartPage.cart));
        for(String product : cartPage.productNames){
            Assert.assertTrue(
                    "Продукт не найден!",
                    DriverManager.getDriver().getPageSource().contains(product));
        }
    }

    @Когда("Проверка итоговой суммы")
    public void checkSum2(){

        int sum = 0;

        for(int i = 1; i < 9; i++){
            sum += Integer.parseInt(DriverManager.getDriver()
                    .findElement(By.xpath("//div[@class='main split-item']["+i+"]//span[@data-v-7ac73ea8][@class='main']"))
                    .getText().replaceAll("\u20BD", "").replaceAll(" ", ""));
        }

        Assert.assertEquals(
                sum,
                Integer.parseInt(cartPage.finallyPrice
                    .getText()
                    .replaceAll(" ","")
                    .replaceAll("\u20BD", "")));
    }

    @Когда("Проверка пустоты страницы")
    public void checkCart(){
            Assert.assertTrue(
                    "Корзина не пуста!",
                    DriverManager.getDriver().getPageSource().contains("Корзина пуста"));
    }

    @Когда("Заполнить поле \"(.*)\" значением \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        cartPage.fillField(name, value);
    }

    @Когда("Удалить для физ.")
    public void deletef(){
        if(!DriverManager.getDriver().getPageSource().contains("Корзина пуста")){
            cartPage.deletef.click();
        }
    }
}

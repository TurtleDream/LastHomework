package org.turtledream.steps;

import cucumber.api.java.ru.Когда;
import org.turtledream.pages.MainPage;

public class MainSteps{

    MainPage mainPage = new MainPage();

    @Когда("Нажатие на \"(.*)\"")
    public void click(String name) throws Exception {
        mainPage.click(name);
    }

    @Когда("Ввести в поле \"(.*)\" значение \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        mainPage.fillField(name, value);
    }
}

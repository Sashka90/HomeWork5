package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.StandartWaiter;

abstract public class PageObject {

    protected WebDriver driver;
    protected Actions actions;
    protected StandartWaiter standartWaiter;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        standartWaiter = new StandartWaiter(driver);


        PageFactory.initElements(driver, this);
    }
}

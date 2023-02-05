package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.PageObject;

abstract public class AbsBasePage extends PageObject {

    private String baseUrl = System.getProperty("base.url", "https://otus.ru");

    private String path;

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    public void open(){
        driver.get(baseUrl + path);
    }

    public AbsBasePage clearCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }

}

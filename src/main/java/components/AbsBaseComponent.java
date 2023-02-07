package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.PageObject;

abstract public class AbsBaseComponent extends PageObject {

    public AbsBaseComponent (WebDriver driver){
        super(driver);
    }

    protected void clearAndInputField(By field, String string){
        driver.findElement(field).clear();
        driver.findElement(field).sendKeys(string);
    }

}

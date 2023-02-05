package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends AbsBasePage{

    public PersonalInfoPage(WebDriver driver) {
        super(driver, "/lk/biography/personal/");
    }

    @FindBy(xpath = "//button[@title='Сохранить и продолжить']")
    public WebElement submit;

    public void clickSaveButton() {
        submit.click();
    }
}

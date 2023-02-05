package components;

import data.CityData;
import data.CountryData;
import data.EnglishLevelData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalInfoComponent extends AbsBaseComponent {

    public PersonalInfoComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='fname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='date_of_birth']")
    public WebElement dateOfBirth;

    @FindBy(css = "input[name='country']+div")
    public WebElement countryInput;

    @FindBy(css = "input[name='city']+div")
    public WebElement cityInput;

    @FindBy(css = "input[name='english_level']+div")
    public WebElement englishLevelInput;

    @FindBy(xpath = "//text()[contains(.,'Да')]/ancestor::label[contains(@class, 'radio')]")
    public WebElement relocate;

    @FindBy(css = "input[id='id_email']")
    public WebElement idEmail;

    @FindBy(css = "input[id='id_phone']")
    public WebElement idPhone;

    public PersonalInfoComponent fillPersonalDataInputs(){
        firstName.clear();
        firstName.sendKeys("Alexander");
        lastName.clear();
        lastName.sendKeys("Yakushev");
        dateOfBirth.clear();
        dateOfBirth.sendKeys("20.05.1990" + Keys.ENTER);
        countryInput.click();
        countrySelect(CountryData.RUSSIA);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", dateOfBirth);
        standartWaiter.waitForCondition(ExpectedConditions.elementToBeClickable(cityInput));
        englishLevelInput.click();
        englishLevelSelect(EnglishLevelData.INTERMEDIATE);
        relocate.click();
        cityInput.click();
        citySelect(CityData.MOSCOW);
        return this;
    }

    private void countrySelect(CountryData countryData) {
        String selector = String.format("button[title='%s']", countryData.getName());
        driver.findElement(By.cssSelector(selector)).click();

    }

    private void citySelect(CityData cityData) {
        String selector = String.format("button[title='%s']", cityData.getName());
        driver.findElement(By.cssSelector(selector)).click();
    }

    private void englishLevelSelect(EnglishLevelData englishLevelData) {
        String selector = String.format("button[title='%s']", englishLevelData.getName());
        driver.findElement(By.cssSelector(selector)).click();
    }

    public PersonalInfoComponent checkUserInfo() {
        Assertions.assertEquals("Alexander", firstName.getAttribute("value"));
        Assertions.assertEquals("Yakushev", lastName.getAttribute("value"));
        Assertions.assertEquals("20.05.1990", dateOfBirth.getAttribute("value"));
        Assertions.assertEquals("Россия", countryInput.getText());
        Assertions.assertEquals("Москва", cityInput.getText());
        Assertions.assertTrue(relocate.isEnabled());
        Assertions.assertEquals("ceyogo9446@bitvoo.com", idEmail.getAttribute("value"));
        Assertions.assertEquals("+7 901 222-33-45", idPhone.getAttribute("value"));
        return this;
    }



}

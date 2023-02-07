package components;

import data.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalInfoComponent extends AbsBaseComponent {

    public PersonalInfoComponent(WebDriver driver) {
        super(driver);
    }

    private final static String userInputLocatorTemplate = "//input[@name='%s']";
    private final static String dropDownButtonSelectorTemplate = "button[title='%s']";

    public PersonalInfoComponent fillPersonalDataInputs(User user){
        inputFioInInput(UserInputsData.FIRST_NAME, user.getFname());
        inputFioInInput(UserInputsData.LAST_NAME, user.getLname());
        inputFioInInput(UserInputsData.DATE_OF_BIRTH, user.getDateOfBirth() + Keys.ENTER);
        inputCountry(UserInputsData.COUNTRY, user.getCountry());
        standartWaiter.waitForCondition(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.CITY.getName())))));
        inputEnglishLevel(UserInputsData.ENGLISH_LEVEL, user.getEnglishLevel());
        choiceRelocate(UserInputsData.RELOCATE, "True");
        inputCity(UserInputsData.CITY, user.getCity());
        return this;
    }

    private void countrySelect(CountryData countryData) {
        String selector = String.format(dropDownButtonSelectorTemplate, countryData.getName());
        driver.findElement(By.cssSelector(selector)).click();

    }

    private void citySelect(CityData cityData) {
        String selector = String.format(dropDownButtonSelectorTemplate, cityData.getName());
        driver.findElement(By.cssSelector(selector)).click();
    }

    private void englishLevelSelect(EnglishLevelData englishLevelData) {
        String selector = String.format(dropDownButtonSelectorTemplate, englishLevelData.getName());
        driver.findElement(By.cssSelector(selector)).click();
    }

    public void inputFioInInput(UserInputsData userInputsData, String data) {
        String locator = String.format(userInputLocatorTemplate, userInputsData.getName());
        standartWaiter.waitForCondition(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        clearAndInputField(By.xpath(locator), data);
    }

    public void inputCountry(UserInputsData userInputsData, CountryData countryData) {
        clickToDropdown(userInputsData);
        countrySelect(countryData);
    }

    public void inputCity(UserInputsData userInputsData, CityData cityData) {
        clickToDropdown(userInputsData);
        citySelect(cityData);
    }

    public void inputEnglishLevel(UserInputsData userInputsData, EnglishLevelData englishLevelData) {
        clickToDropdown(userInputsData);
        englishLevelSelect(englishLevelData);
    }

    private void clickToDropdown(UserInputsData userInputsData) {
        String locator = String.format(userInputLocatorTemplate, userInputsData.getName()).concat("//following-sibling::*");
        driver.findElement(By.xpath(locator)).click();
    }

    private void choiceRelocate(UserInputsData userInputsData, String choice){
        String locator = String.format(userInputLocatorTemplate, userInputsData.getName()).replace("]", " and @value='"+choice+"']/following-sibling::*");
        driver.findElement(By.xpath(locator)).click();
    }

    public void checkUserInformation(User user) {
        Assertions.assertEquals(user.getFname(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.FIRST_NAME.getName()))).getAttribute("value"));
        Assertions.assertEquals(user.getLname(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.LAST_NAME.getName()))).getAttribute("value"));
        Assertions.assertEquals(user.getDateOfBirth(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.DATE_OF_BIRTH.getName()))).getAttribute("value"));
        Assertions.assertEquals(user.getCountry().getName(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.COUNTRY.getName()).concat("//following-sibling::*"))).getText());
        Assertions.assertEquals(user.getCity().getName(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.CITY.getName()).concat("//following-sibling::*"))).getText());
        Assertions.assertEquals(user.getEnglishLevel().getName(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.ENGLISH_LEVEL.getName()).concat("//following-sibling::*"))).getText());
        Assertions.assertEquals(user.getEmail(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.EMAIL.getName()))).getAttribute("value"));
        Assertions.assertEquals(user.getPhone(),
                driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.PHONE.getName()))).getAttribute("value"));
        Assertions.assertTrue(driver.findElement(By.xpath(String.format(userInputLocatorTemplate, UserInputsData.RELOCATE.getName()))).isEnabled());
    }

}

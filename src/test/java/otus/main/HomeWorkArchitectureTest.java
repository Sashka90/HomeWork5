package otus.main;

import components.HeaderMenuComponent;
import components.PersonalInfoComponent;
import components.SignInComponent;
import components.UserInfoComponent;
import data.User;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.PersonalInfoPage;

import static data.CityData.MOSCOW;
import static data.CountryData.RUSSIA;
import static data.EnglishLevelData.INTERMEDIATE;

public class HomeWorkArchitectureTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().create();
    }

    @AfterEach
    public void close(){
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void homeWorkArchitectureTest() {
        MainPage mainPage = new MainPage(driver);
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        SignInComponent signInComponent = new SignInComponent(driver);
        UserInfoComponent userInfoComponent = new UserInfoComponent(driver);
        PersonalInfoComponent personalInfoComponent = new PersonalInfoComponent(driver);
        PersonalInfoPage personalInfoPage = new PersonalInfoPage(driver);
        User user = new User("Alexander", "Yakushev", "20.05.1990", RUSSIA, MOSCOW, INTERMEDIATE, "ceyogo9446@bitvoo.com", "+7 901 222-33-45");

         mainPage.open();
         headerMenuComponent.clickToSignInButton();
         signInComponent.inputAutorizationData("ceyogo9446@bitvoo.com", "Ceyogo9446!");
         headerMenuComponent.clickToUserInfo();
         userInfoComponent.clickToUserProfile();
         personalInfoComponent.fillPersonalDataInputs(user);
         personalInfoPage.clickSaveButton();
         mainPage.clearCookies().open();
         headerMenuComponent.clickToSignInButton();
         signInComponent.inputAutorizationData("ceyogo9446@bitvoo.com", "Ceyogo9446!");
         headerMenuComponent.clickToUserInfo();
         userInfoComponent.clickToUserProfile();
         personalInfoComponent.checkUserInformation(user);
    }
}

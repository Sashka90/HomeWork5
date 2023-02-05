package otus.main;

import components.HeaderMenuComponent;
import components.PersonalInfoComponent;
import components.SignInComponent;
import components.UserInfoComponent;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.PersonalInfoPage;

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

         mainPage.open();
         headerMenuComponent.clickToSignInButton();
         signInComponent.inputAutorizationData("ceyogo9446@bitvoo.com", "Ceyogo9446!");
         headerMenuComponent.clickToUserInfo();
         userInfoComponent.clickToUserProfile();
         personalInfoComponent.fillPersonalDataInputs();
         personalInfoPage.clickSaveButton();
         mainPage.clearCookies().open();
         headerMenuComponent.clickToSignInButton();
         signInComponent.inputAutorizationData("ceyogo9446@bitvoo.com", "Ceyogo9446!");
         headerMenuComponent.clickToUserInfo();
         userInfoComponent.clickToUserProfile();
         personalInfoComponent.checkUserInfo();
    }
}

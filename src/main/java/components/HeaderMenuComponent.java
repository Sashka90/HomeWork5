package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenuComponent extends AbsBaseComponent{

    public HeaderMenuComponent(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[@class = 'header3__button-sign-in']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@data-name='user-info']")
    public WebElement userInfo;

    public SignInComponent clickToSignInButton() {
        signInButton.click();
        return new SignInComponent(driver);
    }

    public UserInfoComponent clickToUserInfo() {
        standartWaiter.waitForCondition(ExpectedConditions.visibilityOf(userInfo));
        userInfo.click();
        return new UserInfoComponent(driver);
    }
}

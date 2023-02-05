package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfoComponent extends AbsBaseComponent{

    public UserInfoComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href*='/lk/biography/personal']")
    public WebElement userProfile;

    public void clickToUserProfile() {
        userProfile.click();
    }

}

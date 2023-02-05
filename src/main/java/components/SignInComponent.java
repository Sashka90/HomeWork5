package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SignInComponent extends AbsBaseComponent {
    public SignInComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text' and contains(@placeholder, 'Электронная почта')]")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@type='password' and contains(@placeholder, 'Введите пароль')]")
    public WebElement inputPass;

    @FindBy(xpath = "//button[contains(text(), 'Войти') and (@type ='submit')]")
    public WebElement enterButton;

    public void inputAutorizationData(String email, String password) {
        standartWaiter.waitForCondition(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);
        inputPass.sendKeys(password);
        enterButton.click();
    }
}

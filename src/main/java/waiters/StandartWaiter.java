package waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class StandartWaiter {

    private  WebDriver driver;

    public StandartWaiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            webDriverWait.until(condition);
        } catch (Exception ignored) {
        }
    }
}

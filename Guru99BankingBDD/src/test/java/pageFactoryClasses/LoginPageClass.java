
package pageFactoryClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageClass {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By userIdField = By.name("uid");
    private final By passwordField = By.name("password");
    private final By loginButton = By.name("btnLogin");

    public LoginPageClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );
    }

    public void enterUserId(String userId) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(userIdField)
        ).sendKeys(userId);
    }

    public void enterPassword(String password) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordField)
        ).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    public void login(String userId, String password) {
        enterUserId(userId);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoginPageDisplayed() {
        return !driver.findElements(userIdField).isEmpty()
            && !driver.findElements(passwordField).isEmpty();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

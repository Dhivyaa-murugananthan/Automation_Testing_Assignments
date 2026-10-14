
package pageFactoryClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By editAccountLink =
        By.linkText("Edit Account");

    private final By accountNumberField =
        By.name("accountno");

    private final By submitButton =
        By.name("AccSubmit");

    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    public void openEditAccountPage() {
        wait.until(
            ExpectedConditions.elementToBeClickable(
                editAccountLink
            )
        ).click();
    }

    public void enterAccountNumber(String accountId) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                accountNumberField
            )
        );

        field.clear();
        field.sendKeys(accountId);
    }

    public void submitAccountNumber() {
        wait.until(
            ExpectedConditions.elementToBeClickable(
                submitButton
            )
        ).click();
    }
}

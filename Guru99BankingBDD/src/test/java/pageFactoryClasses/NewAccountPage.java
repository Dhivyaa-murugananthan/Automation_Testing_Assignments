
package pageFactoryClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By newAccountLink =
        By.linkText("New Account");

    private final By customerIdField =
        By.name("cusid");

    private final By accountTypeDropdown =
        By.name("selaccount");

    private final By initialDepositField =
        By.name("inideposit");

    private final By submitButton =
        By.name("button2");

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    public void openNewAccountPage() {
        wait.until(
            ExpectedConditions.elementToBeClickable(newAccountLink)
        ).click();
    }

    public void enterCustomerId(String customerId) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                customerIdField
            )
        );

        field.clear();
        field.sendKeys(customerId);
    }

    public void selectAccountType(String accountType) {
        WebElement dropdown = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                accountTypeDropdown
            )
        );

        new Select(dropdown).selectByVisibleText(accountType);
    }

    public void enterInitialDeposit(String amount) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                initialDepositField
            )
        );

        field.clear();
        field.sendKeys(amount);
    }

    public void submitAccountForm() {
        wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        ).click();
    }

    public String getAccountId() {
        WebElement accountIdCell = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                    "//td[normalize-space()='Account ID']"
                    + "/following-sibling::td"
                )
            )
        );

        return accountIdCell.getText().trim();
    }
}

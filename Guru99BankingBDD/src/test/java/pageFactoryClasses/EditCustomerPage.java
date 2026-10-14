
package pageFactoryClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCustomerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By editCustomerLink = By.linkText("Edit Customer");
    private final By customerIdField = By.name("cusid");
    private final By submitButton = By.name("AccSubmit");
    private final By addressField = By.name("addr");
    private final By submitChangesButton = By.name("sub");

    public EditCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    public void openEditCustomer() {
        wait.until(
            ExpectedConditions.elementToBeClickable(editCustomerLink)
        ).click();
    }

    public void enterCustomerId(String customerId) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(customerIdField)
        );
        field.clear();
        field.sendKeys(customerId);
    }

    public void submitCustomerId() {
        wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        ).click();
    }

    public void updateAddress(String address) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(addressField)
        );
        field.clear();
        field.sendKeys(address);
    }

    public void submitChanges() {
        wait.until(
            ExpectedConditions.elementToBeClickable(submitChangesButton)
        ).click();
    }
}

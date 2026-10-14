
package pageFactoryClasses;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCustomerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Navigation
    private final By newCustomerLink =
        By.linkText("New Customer");

    // Customer form fields
    private final By customerName =
        By.name("name");

    private final By genderFemale =
        By.xpath("//input[@name='rad1' and @value='f']");

    private final By genderMale =
        By.xpath("//input[@name='rad1' and @value='m']");

    private final By dateOfBirth =
        By.name("dob");

    private final By address =
        By.name("addr");

    private final By city =
        By.name("city");

    private final By state =
        By.name("state");

    private final By pin =
        By.name("pinno");

    private final By mobile =
        By.name("telephoneno");

    private final By email =
        By.name("emailid");

    private final By password =
        By.name("password");

    private final By submitButton =
        By.name("sub");

    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );
    }

    public void openNewCustomerPage() {
        wait.until(
            ExpectedConditions.elementToBeClickable(newCustomerLink)
        ).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(customerName)
        );
    }

    public void fillCustomerForm(Map<String, String> data) {

        type(customerName, data.get("customerName"));

        String gender = data.get("gender");

        if ("female".equalsIgnoreCase(gender)) {
            wait.until(
                ExpectedConditions.elementToBeClickable(genderFemale)
            ).click();
        } else if ("male".equalsIgnoreCase(gender)) {
            wait.until(
                ExpectedConditions.elementToBeClickable(genderMale)
            ).click();
        } else {
            throw new IllegalArgumentException(
                "Gender must be male or female"
            );
        }

        type(dateOfBirth, data.get("dateOfBirth"));
        type(address, data.get("address"));
        type(city, data.get("city"));
        type(state, data.get("state"));
        type(pin, data.get("pin"));
        type(mobile, data.get("mobile"));
        type(email, data.get("email"));
        type(password, data.get("password"));
    }
    
    

    public void submitCustomerForm() {
        wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        ).click();
    }

    public boolean isCustomerRegisteredSuccessfully() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                        "//*[contains(normalize-space(.),"
                        + "'Customer Registered Successfully')]"
                    )
                )
            ).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public String getCustomerId() {
        By customerIdValue = By.xpath(
            "//td[normalize-space()='Customer ID']"
            + "/following-sibling::td[1]"
        );

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                customerIdValue
            )
        ).getText().trim();
    }

    private void type(By locator, String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                "Missing required customer form value for: " + locator
            );
        }

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator)
        );

        element.clear();
        element.sendKeys(value);
    }
}

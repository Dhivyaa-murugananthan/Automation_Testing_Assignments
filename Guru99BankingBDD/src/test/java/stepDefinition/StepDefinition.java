
package stepDefinition;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pageFactoryClasses.LoginPageClass;
import pageFactoryClasses.CreateCustomerPage;
import pageFactoryClasses.EditCustomerPage;
import pageFactoryClasses.NewAccountPage;
import pageFactoryClasses.EditAccountPage;

import utilities.BaseClassDriverInitialization;
import utilities.FetchDataFromExcel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StepDefinition {

    private boolean initialized;
    private boolean actionExecuted;
    private String generatedCustomerId;

    // ================================================
    // Basic Cucumber framework validation
    // ================================================

    @Given("the framework is initialized")
    public void frameworkInitialized() {
        initialized = true;
        System.out.println("Framework initialized");
    }

    @When("I execute a sample action")
    public void executeSampleAction() {
        Assert.assertTrue(
            initialized,
            "Framework must be initialized first"
        );

        actionExecuted = true;
        System.out.println("Sample action executed");
    }

    @Then("the scenario should pass")
    public void scenarioShouldPass() {
        Assert.assertTrue(
            actionExecuted,
            "Sample action was not executed"
        );

        System.out.println("Scenario passed");
    }

    // ================================================
    // Launch Guru99 Banking
    // ================================================

    @Given("I launch the Guru99 Banking application")
    public void launchBankingApplication() {
        WebDriver driver =
            BaseClassDriverInitialization.getDriver();

        driver.get("https://demo.guru99.com/V4/index.php");

        System.out.println(
            "Guru99 Banking application opened"
        );
    }

    // ================================================
    // Verify banking login page
    // ================================================

    @Then("the banking login page should be displayed")
    public void bankingLoginPageShouldBeDisplayed() {

        WebDriver driver =
            BaseClassDriverInitialization.getDriver();

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/V4/"),
            "Guru99 Banking login page URL was not displayed. "
                + "Current URL: " + driver.getCurrentUrl()
        );

        Assert.assertTrue(
            driver.getTitle().contains("Guru99 Bank"),
            "Unexpected page title: " + driver.getTitle()
        );

        String pageText =
            driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(
            pageText.contains("UserID")
                && pageText.contains("Password"),
            "Banking login form was not displayed."
        );

        System.out.println(
            "Guru99 Banking login page verified successfully"
        );
    }

    // ================================================
    // Manager login
    // ================================================

    @When("I log in with valid manager credentials")
    public void loginWithValidCredentials() {

        String userId = System.getenv("GURU99_USER");
        String password = System.getenv("GURU99_PASSWORD");

        if (userId == null || userId.isBlank()
                || password == null || password.isBlank()) {
            throw new IllegalStateException(
                "Set GURU99_USER and GURU99_PASSWORD "
                    + "environment variables."
            );
        }

        LoginPageClass loginPage =
            new LoginPageClass(
                BaseClassDriverInitialization.getDriver()
            );

        loginPage.login(userId, password);

        System.out.println("Login form submitted");
    }

    @Then("the manager dashboard should be displayed")
    public void managerDashboardShouldBeDisplayed() {

        WebDriver driver =
            BaseClassDriverInitialization.getDriver();

        Assert.assertTrue(
            driver.getCurrentUrl().contains("Manager"),
            "Manager dashboard was not displayed. Current URL: "
                + driver.getCurrentUrl()
        );

        System.out.println(
            "Manager dashboard displayed successfully"
        );
    }

    // ================================================
    // Customer registration
    // ================================================

    private CreateCustomerPage createCustomerPage() {
        return new CreateCustomerPage(
            BaseClassDriverInitialization.getDriver()
        );
    }

    @When("I navigate to the New Customer page")
    public void navigateToNewCustomerPage() {
        createCustomerPage().openNewCustomerPage();

        System.out.println("New Customer page opened");
    }


    @When("I enter the following customer details")
    public void enterCustomerDetails(DataTable dataTable) {
        List<Map<String, String>> rows =
            dataTable.asMaps(String.class, String.class);

        Map<String, String> customerData = new LinkedHashMap<>();

        for (Map<String, String> row : rows) {
            customerData.put(
                row.get("field").trim(),
                row.get("value").trim()
            );
        }

        createCustomerPage().fillCustomerForm(customerData);

        System.out.println("Customer details entered using Cucumber DataTable");
    }
    



	@When("I submit the new customer form")
	public void submitNewCustomerForm() {
	    createCustomerPage().submitCustomerForm();
	    System.out.println("Customer form submitted");
	}
		
    @Then("the customer should be registered successfully")
    public void verifyCustomerRegistered() {

        Assert.assertTrue(
            createCustomerPage()
                .isCustomerRegisteredSuccessfully(),
            "Customer registration failed or success message "
                + "was not displayed."
        );

        System.out.println("Customer registered successfully");
    }

    @Then("the generated customer ID should be displayed")
    public void verifyGeneratedCustomerId() {

        generatedCustomerId =
            createCustomerPage().getCustomerId();

        Assert.assertNotNull(
            generatedCustomerId,
            "Customer ID is null"
        );

        Assert.assertFalse(
            generatedCustomerId.isBlank(),
            "Customer ID is blank"
        );

        System.out.println(
            "Generated Customer ID: " + generatedCustomerId
        );

        FetchDataFromExcel.writeData(
            "customerId",
            generatedCustomerId
        );

        String savedCustomerId =
            FetchDataFromExcel.readData("customerId");

        Assert.assertEquals(
            savedCustomerId,
            generatedCustomerId,
            "Customer ID saved in Excel does not match"
        );

        System.out.println(
            "Verified Customer ID from Excel: "
                + savedCustomerId
        );

        saveSuccessfulRegistrationScreenshot();
    }

    // ================================================
    // Edit Customer
    // ================================================

    private EditCustomerPage editCustomerPage() {
        return new EditCustomerPage(
            BaseClassDriverInitialization.getDriver()
        );
    }

    @When("I navigate to the Edit Customer page")
    public void navigateToEditCustomerPage() {
        editCustomerPage().openEditCustomer();

        System.out.println("Edit Customer page opened");
    }

    @When("I update the customer address to {string}")
    public void updateCustomerAddress(String newAddress) {

        String customerId =
            FetchDataFromExcel.readData("customerId");

        Assert.assertNotNull(
            customerId,
            "Customer ID could not be read from Excel"
        );

        Assert.assertFalse(
            customerId.isBlank(),
            "Customer ID in Excel is blank"
        );

        System.out.println(
            "Editing customer ID from Excel: " + customerId
        );

        editCustomerPage().enterCustomerId(customerId);
        editCustomerPage().submitCustomerId();
        editCustomerPage().updateAddress(newAddress);
        editCustomerPage().submitChanges();
    }

    @Then("the customer address update should be successful")
    public void verifyCustomerAddressUpdate() {

        WebDriver driver =
            BaseClassDriverInitialization.getDriver();

        String pageText =
            driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(
            pageText.contains(
                "Customer details updated Successfully!!!"
            ),
            "Customer address update confirmation was not found. "
                + "Actual page text: " + pageText
        );

        System.out.println(
            "Customer address update verified successfully."
        );
    }

    // ================================================
    // Save successful registration screenshot
    // ================================================

    private void saveSuccessfulRegistrationScreenshot() {

        WebDriver driver =
            BaseClassDriverInitialization.getDriver();

        Path screenshotDirectory =
            Paths.get("target", "screenshots");

        String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
        );

        Path screenshotPath = screenshotDirectory.resolve(
            "CustomerRegistrationSuccess_"
                + timestamp + ".png"
        );

        try {
            Files.createDirectories(screenshotDirectory);

            byte[] screenshot =
                ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Files.write(screenshotPath, screenshot);

            System.out.println(
                "Registration screenshot saved: "
                    + screenshotPath.toAbsolutePath()
            );

        } catch (Exception e) {
            throw new RuntimeException(
                "Unable to save registration screenshot",
                e
            );
        }
    }

    // ================================================
    // New Account
    // ================================================

    private NewAccountPage newAccountPage() {
        return new NewAccountPage(
            BaseClassDriverInitialization.getDriver()
        );
    }

    @When("I navigate to the New Account page")
    public void navigateToNewAccountPage() {
        newAccountPage().openNewAccountPage();

        System.out.println("New Account page opened");
    }

    @When("I create a savings account with initial deposit {string}")
    public void createSavingsAccount(String depositAmount) {

        String customerId =
            FetchDataFromExcel.readData("customerId");

        Assert.assertNotNull(
            customerId,
            "Customer ID could not be read from Excel"
        );

        Assert.assertFalse(
            customerId.isBlank(),
            "Customer ID in Excel is blank"
        );

        System.out.println(
            "Creating Savings Account for Customer ID: "
                + customerId
        );

        newAccountPage().enterCustomerId(customerId);
        newAccountPage().selectAccountType("Savings");
        newAccountPage().enterInitialDeposit(depositAmount);
        newAccountPage().submitAccountForm();
    }

    @Then("the account should be created and saved in Excel")
    public void verifyAccountCreatedAndSaveId() {

        String generatedAccountId =
            newAccountPage().getAccountId();

        Assert.assertNotNull(
            generatedAccountId,
            "Generated Account ID is null"
        );

        Assert.assertFalse(
            generatedAccountId.isBlank(),
            "Generated Account ID is blank"
        );

        System.out.println(
            "Generated Account ID: " + generatedAccountId
        );

        FetchDataFromExcel.writeData(
            "accountId",
            generatedAccountId
        );

        String savedAccountId =
            FetchDataFromExcel.readData("accountId");

        Assert.assertEquals(
            savedAccountId,
            generatedAccountId,
            "Account ID saved in Excel does not match"
        );

        System.out.println(
            "Verified Account ID from Excel: "
                + savedAccountId
        );
    }

    // ================================================
    // Edit Account
    // ================================================

    private EditAccountPage editAccountPage() {
        return new EditAccountPage(
            BaseClassDriverInitialization.getDriver()
        );
    }

    @When("I navigate to the Edit Account page")
    public void navigateToEditAccountPage() {
        editAccountPage().openEditAccountPage();

        System.out.println("Edit Account page opened");
    }

    @When("I submit the Account ID stored in Excel")
    public void submitAccountIdFromExcel() {

        String accountId =
            FetchDataFromExcel.readData("accountId");

        Assert.assertNotNull(
            accountId,
            "Account ID could not be read from Excel"
        );

        Assert.assertFalse(
            accountId.isBlank(),
            "Account ID in Excel is blank"
        );

        System.out.println(
            "Editing account ID from Excel: " + accountId
        );

        editAccountPage().enterAccountNumber(accountId);
        editAccountPage().submitAccountNumber();
    }
}

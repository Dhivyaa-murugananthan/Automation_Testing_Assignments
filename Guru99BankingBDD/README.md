# Guru99 Banking BDD Automation Framework

A Selenium-based banking application automation framework built using Java, Maven, Cucumber BDD, and TestNG. The framework follows the Page Object Model (POM) and supports Excel-based test data management, automated screenshots, and HTML reporting.

## Features

- **BDD testing:** Readable Gherkin feature files using Cucumber.
- **Browser automation:** Selenium WebDriver with Chrome.
- **Test execution:** TestNG and Maven.
- **Page Object Model:** Separate page classes for maintainable UI automation.
- **Test data management:** Apache POI for reading and writing Excel test data.
- **Environment-based credentials:** Manager login credentials supplied through environment variables.
- **Reporting:** Cucumber HTML, Cucumber JSON, and Extent Reports.
- **Failure handling:** Automatic failure screenshots, browser diagnostics, and browser cleanup.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Selenium WebDriver 4.27.0 | Browser automation |
| Cucumber 7.20.1 | BDD feature execution |
| TestNG 7.10.2 | Test execution |
| Maven 3.9.16 | Dependency and build management |
| Apache POI 5.3.0 | Excel data handling |
| Extent Reports Cucumber 7 adapter | HTML reporting |
| Eclipse IDE | Development environment |

## Project Structure

```text
Guru99BankingBDD/
├── src/
│   └── test/
│       ├── java/
│       │   ├── featureFiles/
│       │   │   ├── D_CreateCustomer.feature
│       │   │   ├── E_EditCustomer.feature
│       │   │   ├── F_NewAccount.feature
│       │   │   └── G_EditAccount.feature
│       │   ├── pageFactoryClasses/
│       │   │   ├── LoginPageClass.java
│       │   │   ├── CreateCustomerPage.java
│       │   │   ├── EditCustomerPage.java
│       │   │   ├── NewAccountPage.java
│       │   │   └── EditAccountPage.java
│       │   ├── stepDefinition/
│       │   │   ├── StepDefinition.java
│       │   │   └── TestRunner.java
│       │   ├── utilities/
│       │   │   ├── BaseClassDriverInitialization.java
│       │   │   ├── FetchDataFromExcel.java
│       │   │   └── Hooks.java
│       │   └── testData/
│       │       └── TestData.xlsx
│       └── resources/
│           ├── extent.properties
│           └── extent-config.xml
├── .gitignore
├── pom.xml
└── README.md
```

*The structure above reflects the intended organization; verify filenames against the actual project before committing.*

## Prerequisites

- JDK 21
- Apache Maven 3.9+
- Eclipse IDE or another Java IDE
- Google Chrome
- A valid Guru99 Banking demo account

## Configuration

Set the following environment variables on your machine:

| Variable | Description |
|---|---|
| `GURU99_USER` | Guru99 Manager UserID |
| `GURU99_PASSWORD` | Guru99 Manager password |

Do not hardcode credentials in Java source files.

Configure these variables in your IDE's run configuration or operating system environment.

## Run the Tests

From the project root, execute:

```bash
mvn clean test
```

The Cucumber runner is configured to discover feature files under `src/test/java/featureFiles`.

You can also execute `TestRunner.java` directly through Eclipse using **Run As → TestNG Test**.

Close `TestData.xlsx` before execution so the framework can update the workbook.

## Reports and Screenshots

Generated artifacts are stored under `target/`.

| Artifact | Location |
|---|---|
| Cucumber HTML | `target/cucumber-reports/cucumber.html` |
| Cucumber JSON | `target/cucumber-reports/cucumber.json` |
| Extent HTML | `target/extent-reports/ExtentReport.html` |
| Screenshots | `target/screenshots/` |

Open the HTML files in a browser after test execution.

## Test Scenarios

- Manager login
- Customer registration using a Cucumber DataTable
- Customer ID storage and verification in Excel
- Edit Customer workflow
- Savings Account creation
- Account ID storage and verification in Excel
- Edit Account workflow

The public demo website can be unstable or shared with other users. A scenario's successful execution does not necessarily prove that every backend operation is reliable. Validate actual application behavior when required.

## Test Data

`TestData.xlsx` stores generated customer and account identifiers used by dependent scenarios. The workbook is updated during execution, so its contents can change between runs.

## Notes

- Generated reports, screenshots, build output, and IDE-specific files are excluded through `.gitignore`.
- Selenium may display Chrome DevTools Protocol compatibility warnings when the installed Chrome version is newer than the Selenium version's supported CDP implementation.
- This framework is intended for learning and demonstration against the Guru99 public banking demo site.

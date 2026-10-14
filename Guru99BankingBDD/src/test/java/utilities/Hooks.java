
package utilities;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp() {
        BaseClassDriverInitialization.getDriver();
        System.out.println("[HOOK] Browser initialized");
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver =
            BaseClassDriverInitialization.getExistingDriver();

        System.out.println(
            "Scenario status: " + scenario.getStatus()
        );

        try {
            if (driver != null) {

                // Capture diagnostic information safely.
                try {
                    System.out.println(
                        "Current URL: " + driver.getCurrentUrl()
                    );

                    System.out.println(
                        "Page title: " + driver.getTitle()
                    );

                    System.out.println(
                        "Page text: "
                            + driver.findElement(By.tagName("body"))
                                    .getText()
                    );

                } catch (Exception e) {
                    System.out.println(
                        "Unable to collect browser diagnostics: "
                            + e.getMessage()
                    );
                }

                // Capture and attach screenshots for failed scenarios.
                if (scenario.isFailed()) {
                    try {
                        byte[] screenshot =
                            ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                        // Attach to Cucumber; the Extent adapter
                        // can consume this attachment.
                        scenario.attach(
                            screenshot,
                            "image/png",
                            "Failure Screenshot"
                        );

                        // Save a standalone PNG file as well.
                        saveFailureScreenshot(
                            screenshot,
                            scenario.getName()
                        );

                        System.out.println(
                            "Failure screenshot captured and attached."
                        );

                    } catch (Exception e) {
                        System.out.println(
                            "Unable to capture failure screenshot: "
                                + e.getMessage()
                        );
                    }
                }
            }

        } finally {
            // Always clean up the browser, including after failures.
            try {
                BaseClassDriverInitialization.quitDriver();
                System.out.println("[HOOK] Browser closed");
            } catch (Exception e) {
                System.out.println(
                    "Unable to close browser: " + e.getMessage()
                );
            }
        }
    }

    private void saveFailureScreenshot(
            byte[] screenshot,
            String scenarioName) {

        try {
            Path screenshotDirectory =
                Paths.get("target", "screenshots");

            Files.createDirectories(screenshotDirectory);

            String safeScenarioName = scenarioName
                .replaceAll("[^a-zA-Z0-9-_]", "_");

            String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
            );

            Path screenshotPath = screenshotDirectory.resolve(
                "Failure_" + safeScenarioName
                    + "_" + timestamp + ".png"
            );

            Files.write(screenshotPath, screenshot);

            System.out.println(
                "Failure screenshot saved: "
                    + screenshotPath.toAbsolutePath()
            );

        } catch (Exception e) {
            System.out.println(
                "Unable to save screenshot file: "
                    + e.getMessage()
            );
        }
    }
}

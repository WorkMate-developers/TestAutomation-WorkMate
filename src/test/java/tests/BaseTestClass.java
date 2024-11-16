package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import utils.LoggerUtils;
import utils.WebDriverUtils;

/**
 * This abstract class contains all methods commonly used by all tests. Currently, it contains only stuff for UI tests.
 */

public abstract class BaseTestClass extends LoggerUtils {

    protected WebDriver setUpDriver() {
        return WebDriverUtils.setUpDriver();
    }

    protected void quitDriver(WebDriver driver) {
        WebDriverUtils.quitDriver(driver);
    }

    protected void tearDown(WebDriver driver, ITestResult testResult) {
        String sTestName = testResult.getTestName();

        try {
            if(testResult.getStatus() == ITestResult.FAILURE) {
                // TODO: add screenshot logic here
            }
        } catch (AssertionError | Exception e) {
            LoggerUtils.log.debug("Exception occurred in tearDown(" + sTestName + ")! Message: " + e.getMessage());
        }
        finally {
            quitDriver(driver);
        }
    }
}

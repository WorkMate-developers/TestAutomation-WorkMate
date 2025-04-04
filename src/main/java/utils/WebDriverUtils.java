package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;

public class WebDriverUtils extends LoggerUtils {

    /**
     * Sets up Web Driver based on preferences picked up from common.properties.
     *
     * @return WebDriver
     */

    public static WebDriver setUpDriver() {
        WebDriver driver = null;

        String sBrowser = PropertiesUtils.getBrowser();
        boolean bHeadless = PropertiesUtils.getBoolProperty("headless");

        log.debug("Set up WebDriver: {}, headless={}", sBrowser, bHeadless);

        try {
            switch (sBrowser) {
                case "chrome" -> {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (bHeadless) {
                        chromeOptions.addArguments("--headless");
                    }
                    driver = new ChromeDriver(chromeOptions);
                }
                case "firefox" -> {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (bHeadless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                }
                case "edge" -> {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (bHeadless) {
                        edgeOptions.addArguments("--headless");
                    }
                    driver = new EdgeDriver(edgeOptions);
                }
                default -> Assert.fail("Cannot create driver, " + sBrowser + " is not recognized as valid browser!");
            }
        } catch (Exception e) {
            Assert.fail("Exception thrown while creating driver! Message: " + e.getMessage());
        }

        if (PropertiesUtils.getBoolProperty("maximized")) {
            driver.manage().window().maximize();
        }

        return driver;
    }

    private static SessionId getSessionID(WebDriver driver) {
        return ((RemoteWebDriver) driver).getSessionId();
    }

    public static Boolean hasDriverQuit(WebDriver driver) {
        if (driver != null) {
            return getSessionID(driver) == null;
        } else {
            return true;
        }
    }

    public static void quitDriver(WebDriver driver) {
        log.debug("Quitting driver. Bye!");
        if (!hasDriverQuit(driver)) {
            driver.quit();
        }
    }

}

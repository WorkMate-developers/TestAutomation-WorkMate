package pageObject.pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LoggerUtils;
import utils.PropertiesUtils;
import utils.WebDriverUtils;

import java.time.Duration;
import java.util.List;

public class BasePageClass extends LoggerUtils {

    protected WebDriver driver;
    private static final String BASE_URL = PropertiesUtils.getApplicationUrl();

    private final By pageLocator = By.id("app");

    protected BasePageClass(WebDriver driver) {
        Assert.assertFalse(WebDriverUtils.hasDriverQuit(driver), "Driver instance has quit!");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void openUrl(String sUrl) {
        log.trace("Open URL: {}", sUrl);
        driver.get(sUrl);
    }


    // Methods for getting elements

    protected WebElement getWebElement(By locator) {
        log.trace("getWebElement({})", locator);
        return driver.findElement(locator);
    }

    protected WebElement getWebElement(By locator, int timeout) {
        log.trace("getWebElement({}, {})", locator, timeout);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement getNestedWebElement(WebElement element, By locator) {
        log.trace("getNestedWebElement({}, {})", element, locator);
        return element.findElement(locator);
    }

    protected WebElement getNestedWebElement(WebElement element, By locator, int timeout) {
        log.trace("getNestedWebElement({}, {}, {})", element, locator, timeout);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }

    protected List<WebElement> getWebElements(By locator) {
        log.trace("getWebElements({})", locator);
        return driver.findElements(locator);
    }

    protected List<WebElement> getNestedWebElements(WebElement element, By locator) {
        log.trace("getWebElements({}, {})", element, locator);
        return element.findElements(locator);
    }

    // Methods for getting data from elements

    protected String getTextFromWebElement(WebElement element) {
        log.trace("getTextFromWebElement({})", element);
        return element.getText();
    }

    protected String getWebElementAttribute(WebElement element, String sAttribute) {
        log.trace("getWebElementAttribute({}, {}", element, sAttribute);
        return element.getAttribute(sAttribute);
    }

    // Methods for interaction with elements

    protected void clickWebElement(WebElement element) {
        log.trace("clickWebElement(" + element + " with timeout: " + Time.TIME_SHORT);
        waitForWebElementToBeClickable(element, Time.TIME_SHORT);
        element.click();
    }

    protected void clickWebElement(WebElement element, int timeout) {
        log.trace("clickWebElement(" + element + " with timeout: " + timeout);
        waitForWebElementToBeClickable(element, timeout);
        element.click();
    }

    protected void enterTextInElement(WebElement element, String sText) {
        log.trace("enterTextInElement({}, {})", element, sText);
        element.sendKeys(sText);
    }

    protected void clearTextInput(WebElement element) {
        log.trace("clearTextInput({})", element);
//        element.clear();
        int currentTextLength = element.getText().length();
        for (int i = 0; i < currentTextLength; i++)
            element.sendKeys(Keys.BACK_SPACE);
        }

    // Element presence methods
    protected Boolean isWebElementVisible(WebElement element) {
        try {
            log.trace("isWebElementVisible({})", element);
            WebElement webElement = waitForWebElementToBeVisible(element, Time.TIME_SHORT);
            return webElement != null;
        } catch (Exception e) {
            return false;
        }
    }

    protected Boolean isWebElementVisible(WebElement element, int iWaitTime) {
        try {
            log.trace("isWebElementVisible({}, {})", element, iWaitTime);
            WebElement webElement = waitForWebElementToBeVisible(element, iWaitTime);
            return webElement != null;
        } catch (Exception e) {
            return false;
        }
    }


    // Wait methods

    protected WebElement waitForWebElementToBeVisible(By locator, int timeout) {
        log.trace("waitForWebElementToBeVisible(" + locator + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForWebElementToBeVisible(WebElement element, int timeout) {
        log.trace("waitForWebElementToBeVisible(" + element + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean waitForWebElementToBeInvisible(By locator, int timeout) {
        log.trace("waitForWebElementToBeInvisible(" + locator + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected boolean waitForWebElementToBeInvisible(WebElement element, int timeout) {
        log.trace("waitForWebElementToBeInvisible(" + element + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected WebElement waitForWebElementToBeClickable(WebElement element, int timeout) {
        log.trace("waitForWebElementToBeClickable(" + element + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}

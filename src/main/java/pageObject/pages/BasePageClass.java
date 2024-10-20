package pageObject.pages;

import org.openqa.selenium.By;
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
        log.debug("Open URL: " + sUrl);
        driver.get(sUrl);
    }


    // Methods for getting elements

    protected WebElement getWebElement(By locator) {
        log.trace("getWebElement(" + locator + ")");
        return driver.findElement(locator);
    }

    protected WebElement getWebElement(By locator, int timeout) {
        log.trace("getWebElement(" + locator + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement getNestedWebElement(WebElement element, By locator) {
        log.trace("getNestedWebElement(" + element + ", " + locator + ")");
        return element.findElement(locator);
    }

    protected WebElement getNestedWebElement(WebElement element, By locator, int timeout) {
        log.trace("getNestedWebElement(" + element + ", " + locator + ", " + timeout + ")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }

    protected List<WebElement> getWebElements(By locator) {
        log.trace("getWebElements(" + locator + ")");
        return driver.findElements(locator);
    }

    protected List<WebElement> getNestedWebElements(WebElement element, By locator) {
        log.trace("getWebElements(" + element + ", " + locator + ")");
        return element.findElements(locator);
    }

    // Methods for interaction with elements


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

package pageObject.pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class contains the elements that are common to all pages when the user is logged in.
 */

public abstract class CommonLoggedInPage extends BasePageClass {

    // Locators
    private final By homeTabLocator = By.xpath("//a[@href='#/']");
    private final By aboutTabLocator = By.xpath("//a[@href='#/about']");
    private final By dataTabLocator = null;
    private final By countriesTabLocator = null;
    private final By citiesTabLocator = null;
    private final By suppliersTabLocator = null;

    // Constructor(s)
    public CommonLoggedInPage(WebDriver driver) {
        super(driver);
    }

    // Methods to access pages

    public HomePage clickHomeTab() {
        log.debug("clickHomeTab()");
        clickWebElement(getWebElement(homeTabLocator, Time.TIME_SHORT));
        return new HomePage(driver);
    }

    public AboutPage clickAboutTab() {
        log.debug("clickAboutTab()");
        clickWebElement(getWebElement(aboutTabLocator, Time.TIME_SHORT));
        return new AboutPage(driver);
    }

    // ToDo: Data Page

    // ToDo: Countries Page

    // ToDo: Cities Page

    // ToDo: Suppliers Page

}

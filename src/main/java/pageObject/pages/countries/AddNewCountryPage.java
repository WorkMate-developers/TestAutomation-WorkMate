package pageObject.pages.countries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.BasePageClass;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class AddNewCountryPage extends BasePageClass {

    private static final HashMap<String, WebElement> elementsMap = new HashMap<>();
    private final String pageName = "Add New Country page";

    // Locators
    @FindBy(id = "form-title")
    private WebElement pageTitle;

    @FindBy(id = "country-name-label")
    private WebElement countryNameTitle;

    @FindBy(id = "country-name")
    private WebElement countryNameInput;

    @FindBy(id = "country-code-label")
    private WebElement countryCodeTitle;

    @FindBy(id = "country-code")
    private WebElement countryCodeInput;

    @FindBy(id = "rlink-back")
    private WebElement backButton;

    @FindBy(id = "btn-submit")
    private WebElement createCountryButton;

    @FindBy(id = "country-name-error")
    private WebElement countryNameErrorMessage;

    @FindBy(id = "country-code-error")
    private WebElement countryCodeErrorMessage;

    // Element maps

    public AddNewCountryPage(WebDriver driver) {
        super(driver);
        addElementsToMap();
        log.trace("new Add New Country Page");
    }

    private void addElementsToMap() {
        elementsMap.put("Page Title", pageTitle);
        elementsMap.put("Country Name Title", countryNameTitle);
        elementsMap.put("Country Name Input Placeholder", countryNameInput);
        elementsMap.put("Country Code Title", countryCodeTitle);
        elementsMap.put("Country Code Input Placeholder", countryCodeInput);
        elementsMap.put("Back Button", backButton);
        elementsMap.put("Create Country Button", createCountryButton);
        elementsMap.put("Country Name Error Message", countryNameErrorMessage);
        elementsMap.put("Country Code Error Message", countryCodeErrorMessage);
    }

    //Methods

    public String getTextFromElement(String sKey) {
            log.debug("Get text from element: " + sKey + " on page: " + pageName);
            if (sKey.contains("Placeholder")) {
                return getWebElementAttribute(elementsMap.get(sKey), "placeholder");
            }
            return getTextFromWebElement(elementsMap.get(sKey));
    }

    // Interactions

    public CountriesPage clickBackButton() {
        log.debug("Click Back button -> open new Countries page");
        clickWebElement(elementsMap.get("Back Button"));
        return new CountriesPage(driver);
    }

    public void clickCreateCountryButton() {
        log.debug("Click Create Country button -> stay on this page");
        clickWebElement(elementsMap.get("Create Country Button"));
    }

    public void enterTextIntoField(String sKey, String sText) {
        log.debug("Entering text: '" + sText + "' into the " + sKey + " field");
        // TODO: add methods when they are available in BasePageClass
    }

}

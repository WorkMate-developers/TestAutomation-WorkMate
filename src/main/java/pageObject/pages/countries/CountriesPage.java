package pageObject.pages.countries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.CommonLoggedInPage;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class CountriesPage extends CommonLoggedInPage {

    public CountriesPage(WebDriver driver) {
        super(driver);
        addElementsToMap();
        log.trace("new Countries Page");
    }

    private final String pageName = "Add New Country page";

    // Locators
    @FindBy(className = "")
    private WebElement pageTitle;

    @FindBy(css = ".btn")
    private WebElement addNewCountryButton;

    @FindBy(xpath = "'//[@id=country-*]'")
    private List<WebElement> itemsInTable;

    // TODO: refactor the table locators completely

    // Element maps

    private static final HashMap<String, WebElement> elementsMap = new HashMap<>();

    private void addElementsToMap() {
        elementsMap.put("Page Title", pageTitle);
        elementsMap.put("Add New Country button", addNewCountryButton);
    }

    // Methods

    public String getTextFromElement(String key) {
        try {
            log.debug("Get text from element: " + key + " on page: " + pageName);
            return getTextFromWebElement(elementsMap.get(key));
        }
        catch (NoSuchElementException e) {
            log.error("Element " + key + " not defined on this page! Check the testing code.");
            assert false;
        }
        return null;
    }

    public AddNewCountryPage clickOnAddNewCountryButton() {
        log.debug("Click on Add New bountry Button -> open new Add New Country page");
        clickWebElement(addNewCountryButton);
        return new AddNewCountryPage(driver);
    }

}

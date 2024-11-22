package pageObject.pages.countries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.CommonLoggedInPage;

import java.util.HashMap;
import java.util.List;

public class CountriesPage extends CommonLoggedInPage {

    private static final HashMap<String, WebElement> elementsMap = new HashMap<>();
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

    public CountriesPage(WebDriver driver) {
        super(driver);
        addElementsToMap();
        log.trace("new Countries Page");
    }

    private void addElementsToMap() {
        elementsMap.put("Page Title", pageTitle);
        elementsMap.put("Add New Country button", addNewCountryButton);
    }

    // Methods

    public String getTextFromElement(String key) {
        log.debug("Get text from element: " + key + " on page: " + pageName);
        return getTextFromWebElement(elementsMap.get(key));
    }

    public AddNewCountryPage clickOnAddNewCountryButton() {
        log.debug("Click on Add New Country Button -> open new Add New Country page");
        clickWebElement(addNewCountryButton);
        return new AddNewCountryPage(driver);
    }

}

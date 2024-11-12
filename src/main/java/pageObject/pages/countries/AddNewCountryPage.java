package pageObject.pages.countries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.BasePageClass;

public class AddNewCountryPage extends BasePageClass {

    public AddNewCountryPage(WebDriver driver) {
        super(driver);
        log.trace("new AddNewCountryPage()");
    }

    // Locators
    @FindBy(id = "form-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[contains(@for, 'country-name')]")
    private WebElement countryNameTitle;

    @FindBy(id = "country-name")
    private WebElement countryNameInput;

    @FindBy(xpath = "//*[contains(@for, 'country-code')]")
    private WebElement countryCodeTitle;

    @FindBy(id = "country-code")
    private WebElement countryCodeInput;

    @FindBy(id = "rlink-back")
    private WebElement backButton;

    @FindBy(id = "btn-submit")
    private WebElement createCountryButton;

    @FindBy(id = "")
    private WebElement countryNameErrorMessage; // TODO: add locator

    @FindBy(id = "")
    private WebElement countryCodeErrorMessage; // TODO: add locator

    //Methods
    //TODO: get page title

    // TODO: get country name title

    // TODO: get country name input placeholder

    // TODO: get country code title

    // TODO: get country code input placeholder

    // TODO: get back button text

    // TODO: get submit button text

    // Interactions

    // TODO: enter country name

    // TODO: enter country code

    // TODO: click back button

    // TODO: click submit button



}

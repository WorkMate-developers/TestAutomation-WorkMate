package pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.countries.CountriesPage;

/**
 * This class contains the elements that are common to all pages when the user is logged in.
 */

public abstract class CommonLoggedInPage extends BasePageClass {

    // Locators

    @FindBy(xpath = "//a[@href='#/']")
    private WebElement homeTab;

    @FindBy(xpath = "//a[@href='#/about']")
    private WebElement aboutTab;

    @FindBy(xpath = "//a[@href='#/simple_api/data']")
    private WebElement dataTab;

    @FindBy(xpath = "//a[@href='#/api/countries']")
    private WebElement countriesTab;

    @FindBy(xpath = "//a[@href='#/api/cities']")
    private WebElement citiesTab;

    @FindBy(xpath = "//a[@href='#/api/suppliers']")
    private WebElement suppliersTab;

    // Constructor(s)
    public CommonLoggedInPage(WebDriver driver) {
        super(driver);
    }


    // Methods to access different pages from the common logged in page

    public HomePage clickHomeTab() {
        log.debug("clickHomeTab()");
        clickWebElement(homeTab);
        return new HomePage(driver);
    }

    public AboutPage clickAboutTab() {
        log.debug("clickAboutTab()");
        clickWebElement(aboutTab);
        return new AboutPage(driver);
    }

    public DataPage clickDataTab() {
        log.debug("clickDataTab()");
        clickWebElement(dataTab);
        return new DataPage(driver);
    }

    public CountriesPage clickCountriesTab() {
        log.debug("clickCountriesPage()");
        clickWebElement(countriesTab);
        return new CountriesPage(driver);
    }

    public CitiesPage clickCitiesTab() {
        log.debug("clickCitiesTab()");
        clickWebElement(citiesTab);
        return new CitiesPage(driver);
    }

    public SuppliersPage clickSuppliersTab() {
        log.debug("clickSuppliersTab()");
        clickWebElement(suppliersTab);
        return new SuppliersPage(driver);
    }

    public boolean isTabActive(String sTab) {
        log.debug("isTabActive({})", sTab);
        String parameter = "";
        switch (sTab){
            case "Home" -> {
                parameter = homeTab.getAttribute("class");
            }
            case "About" -> {
                parameter = aboutTab.getAttribute("class");
            }
            case "Data" -> {
                parameter = dataTab.getAttribute("class");
            }
            case "Countries" -> {
                parameter = countriesTab.getAttribute("class");
            }
            case "Cities" -> {
                parameter = citiesTab.getAttribute("class");
            }
            case "Suppliers" -> {
                parameter = suppliersTab.getAttribute("class");
            }
        }
        return parameter.contains("router-link-active");
    }

}

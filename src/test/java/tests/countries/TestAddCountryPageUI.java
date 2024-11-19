package tests.countries;

import data.CommonStrings;
import data.Groups;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.pages.HomePage;
import pageObject.pages.countries.AddNewCountryPage;
import pageObject.pages.countries.CountriesPage;
import tests.BaseTestClass;

@Test(groups = {Groups.REGRESSION, Groups.SMOKE, Groups.UI}, testName = "Add New Country Page basic UI test")
public class TestAddCountryPageUI extends BaseTestClass {

    private final String testName = this.getClass().getName();
    private WebDriver driver;

    @BeforeMethod
    public void setUpTest(ITestContext testContext) {
        log.debug("[SETUP TEST] {}", testName);
        driver = setUpDriver();
    }

    @Test
    public void testAddNewCountryPageUI() {
        log.debug("[START TEST] {}", testName);

        HomePage homePage = new HomePage(driver).open();
        CountriesPage countriesPage = homePage.clickCountriesTab();
        AddNewCountryPage addNewCountryPage = countriesPage.clickOnAddNewCountryButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Page Title"), CommonStrings.CREATE_NEW_COUNTRY_PAGE_TITLE);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Country Name Title"), CommonStrings.COUNTRY_NAME_TEXT);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Country Name Input"), CommonStrings.COUNTRY_NAME_TEXT_BOX_PLACEHOLDER_TEXT);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Country Code Title"), CommonStrings.COUNTRY_CODE_TEXT);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Country Code Input"), CommonStrings.COUNTRY_CODE_TEXT_BOX_PLACEHOLDER_TEXT);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Back Button"), CommonStrings.BACK_BUTTON_TEXT);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Create Country Button"), CommonStrings.CREATE_COUNTRY_BUTTON_TEXT);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupTest(ITestResult testResult) {
        log.debug("[CLEANUP TEST] {}", testName);
        tearDown(driver, testResult);
    }
}

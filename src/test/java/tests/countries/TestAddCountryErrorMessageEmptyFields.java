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

/**
 * This test checks whether the error messages for blank fields appear when they should.
 * Case 1: Both input fields are empty -> both error messages should appear
 * Case 2: Country Code input field empty -> Country Code error message should appear
 * Case 3: Country Name input field empty -> Country Name error message should appear
 */

@Test(groups = {Groups.REGRESSION, Groups.SMOKE, Groups.UI}, testName = "Add New Country Page error messages")
public class TestAddCountryErrorMessageEmptyFields extends BaseTestClass {

    private final String testName = this.getClass().getName();
    private WebDriver driver;

    @BeforeMethod
    public void setUpTest(ITestContext testContext) {
        log.debug("[SETUP TEST] {}", testName);
        driver = setUpDriver();
    }

    @Test
    public void testAddCountryErrorMessageEmptyFields() {
        log.debug("[START TEST] {}", testName);

        HomePage homePage = new HomePage(driver).open();
        CountriesPage countriesPage = homePage.clickCountriesTab();
        AddNewCountryPage addNewCountryPage = countriesPage.clickOnAddNewCountryButton();

        SoftAssert softAssert = new SoftAssert();

        addNewCountryPage.clickCreateCountryButton();
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Country Name Error Message"), CommonStrings.COUNTRY_NAME_ERROR_MESSAGE);
        softAssert.assertEquals(addNewCountryPage.getTextFromElement("Country Code Error Message"), CommonStrings.COUNTRY_CODE_ERROR_MESSAGE);

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupTest(ITestResult testResult) {
        log.debug("[CLEANUP TEST] {}", testName);
        tearDown(driver, testResult);
    }
}

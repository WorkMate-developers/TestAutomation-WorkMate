package tests;

import data.CommonStrings;
import data.Groups;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.pages.AboutPage;
import pageObject.pages.HomePage;

@Test(groups = {Groups.REGRESSION, Groups.SMOKE, Groups.UI}, testName = "About Page basic UI test")
public class TestAboutPage extends BaseTestClass{

    private WebDriver driver;
    private final String testName = this.getClass().getName();

    @BeforeMethod
    public void setUpTest(ITestContext testContext) {
        log.debug("[SETUP TEST] " + testName);
        driver = setUpDriver();
    }

    @Test
    public void testAboutPage() {
        log.debug("[START TEST] " + testName);

        HomePage homePage = new HomePage(driver).open();
        AboutPage aboutPage = homePage.clickAboutTab();
        assert aboutPage.getAboutText().equals(CommonStrings.ABOUT_TEXT);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupTest(ITestResult testResult) {
        log.debug("[CLEANUP TEST] " + testName);
        tearDown(driver, testResult);
    }
}

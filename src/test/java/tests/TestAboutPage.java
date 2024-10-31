package tests;

import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.pages.AboutPage;
import pageObject.pages.HomePage;

public class TestAboutPage extends BaseTestClass{

    private WebDriver driver;
    private final String testName = this.getClass().getName();

    @BeforeTest
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

    @AfterTest(alwaysRun = true)
    public void cleanupTest() {
        log.debug("[CLEANUP TEST] " + testName);
        quitDriver(driver);
    }
}

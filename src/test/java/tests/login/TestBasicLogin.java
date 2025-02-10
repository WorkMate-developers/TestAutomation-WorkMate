package tests.login;

import data.Groups;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.pages.HomePage;
import tests.BaseTestClass;

@Test(groups = {Groups.REGRESSION, Groups.SMOKE, Groups.UI, Groups.LOGIN})
public class TestBasicLogin extends BaseTestClass {

    private final String testName = this.getClass().getName();
    private WebDriver driver;

    @BeforeMethod
    public void setUpTest(ITestContext testContext) {
        log.info("[SETUP TEST] {}", testName);
        driver = setUpDriver();
    }

    @Test
    public void testBasicLogin() {
        log.info("[START TEST] {}", testName);

        HomePage homePage = new HomePage(driver).open();

    }
}

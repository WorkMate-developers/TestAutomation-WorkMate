package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

public class CommonSteps {

    WebDriver driver;

    @Given("WebDriver instance is created")
    public void createWebDriverInstance() {
        driver = WebDriverUtils.setUpDriver();
    }

}


package pageObject.pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutPage extends CommonLoggedInPage {

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    // locators
    private final By aboutTextLocator = By.className("about");

    public String getAboutText() {
         WebElement element = getWebElement(aboutTextLocator, Time.TIME_SHORT);
         return element.getText();
    }
}

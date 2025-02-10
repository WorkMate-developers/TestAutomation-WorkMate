package pageObject.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.BasePageClass;

public class PostLoginPage extends BasePageClass {

    public PostLoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators //

    @FindBy(xpath = "/html/body/div/div/p[1]/strong")
    private WebElement usernameField;

    @FindBy(xpath = "/html/body/div/div/p[2]/strong")
    private WebElement emailField;


}

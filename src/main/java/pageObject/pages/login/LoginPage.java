package pageObject.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.BasePageClass;
import pageObject.pages.HomePage;

public class LoginPage extends BasePageClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators //

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "username-label")
    private WebElement usernameTitle;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-label")
    private WebElement passwordTitle;

    @FindBy(id = "rlink-back")
    private WebElement backButton;

    @FindBy(id = "btn-submit")
    private WebElement loginButton;

    // Methods //

    public void setUsername(String username) {
        log.debug("Entering {} to username field", username);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        log.debug("Entering {} to password field", password);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        log.debug("Click login button on Login page");
        loginButton.click();
    }

    public HomePage clickBackButton() {
        log.debug("Click back button on Login page");
        backButton.click();
        return new HomePage(driver);
    }

}

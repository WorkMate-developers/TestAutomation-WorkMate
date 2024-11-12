package pageObject.pages;

import org.openqa.selenium.WebDriver;
import utils.PropertiesUtils;

public class HomePage extends CommonLoggedInPage {

    private final String HOME_PAGE_URL = PropertiesUtils.getApplicationUrl();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        log.debug("Open Home Page: " + HOME_PAGE_URL);
        openUrl(HOME_PAGE_URL);
        // TODO: consider adding a waitForUrlChange and/or waitUntilPageIsReady
        return this;
    }
}

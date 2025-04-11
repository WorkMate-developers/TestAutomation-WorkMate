package pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.PropertiesUtils;

import java.util.Arrays;
import java.util.List;

public class HomePage extends CommonLoggedInPage {

    // Locators

    @FindBy(id = "settingsCard")
    private WebElement settingsCard;

    @FindBy(id = "swInstallationCard")
    private WebElement swInstallationCard;

    @FindBy(id = "swOptionCard")
    private WebElement swOptionCard;

    @FindBy(id = "swOptionInstallationCard")
    private WebElement swOptionInstallationCard;

    @FindBy(id = "instrumentInstallationCard")
    private WebElement instrumentInstallationCard;

    private final String HOME_PAGE_URL = PropertiesUtils.getApplicationUrl();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        log.debug("Open Home Page: {}", HOME_PAGE_URL);
        openUrl(HOME_PAGE_URL);
        // TODO: consider adding a waitForUrlChange and/or waitUntilPageIsReady
        return this;
    }

    protected String getCardText(WebElement cardElement, String whatToGet) {
        log.debug("Getting title text for {} card", cardElement);
        String[] fullText;
        fullText = prepareCardText(cardElement);
        if(!whatToGet.equals("title") && !whatToGet.equals("text")) {
            Assert.fail("Invalid request for card element");
            return null;
        }
        if(fullText != null && whatToGet.equals("title")) {
            return fullText[0];
        } else if (fullText != null) {
            return fullText[1];
        } else {
            Assert.fail("Title in card " + cardElement + " is null!");
            return null;
        }
    }

    protected void clickCard(String requestedCard) {
        log.debug("Clicking on {} card", requestedCard);
        WebElement cardElement = getSpecificCardElement(requestedCard);
        clickWebElement(cardElement);
    }

    /**
     * Gets the innerText property from the card and splits it into Title and Subtitle, respectively. Return null if
     * the element value is empty.
     * @param cardElement WebElement of the Card we are looking into
     * @return String[] of Title and Subtitle or null if the value of innerText is null
     */
    private String[] prepareCardText(WebElement cardElement) {
        String[] fullTextArray = null;
        try {
            String fullTextString = cardElement.getAttribute("innerText");
            if(fullTextString != null) {
                fullTextArray = fullTextString.split("\\n\\n");
            }
        } catch (NullPointerException e) {
            log.debug("Element {} contains no text!", cardElement);
            return null;
        }
        return fullTextArray;
    }

    /**
     * Returns the proper WebElement based on String input. Used to facilitate getting elements and to make tests more
     * readable. Currently available:
     * "Settings", "Software Installation", "Software Option", "Software Option Installation", "Instrument Installation"
     * @param requestedCard - String, card to get
     * @return WebElement based on the input. None if input is wrong.
     */
    private WebElement getSpecificCardElement(String requestedCard) {
        switch (requestedCard) {
            case "Settings" -> {
                return settingsCard;
            }
            case "Software Installation" -> {
                return swInstallationCard;
            }
            case "Software Option" -> {
                return swOptionCard;
            }
            case "Software Option Installation" -> {
                return swOptionInstallationCard;
            }
            case "Instrument Installation" -> {
                return instrumentInstallationCard;
            }
            default -> {
                Assert.fail("Invalid card selected");
                return null;
            }
        }
    }

}

package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.pages.HomePage;

public class HomePageSteps {

    /**
     * NOTE TO STEFAN: treba da se napravi da se deli nekako instanca drajvera kroz ove korake. Istrazi malo bolje
     * kako se prebacuju podaci u cucumberu, posto imamo jednu instancu drivera po scenariju (ne po feature fajlu).
     * Znaci treba nam da se napravi jedna instanca drajvera za svaki scenario i da se unisti na kraju.
     */

    WebDriver driver;
    HomePage homePage = new HomePage(driver);

    @Given("I open the Home Page")
    public void openHomePageStep() {
        homePage.open();
    }

    @When("I click on (.*) card")
    public void clickCard(String requestedCard) {
        homePage.clickCard(requestedCard);
    }

    @Then("Card (.*) title matches (.*) value")
    public void verifyCardTitleMatches(String requestedCard, String expectedTitle) {
        String actualTitle = this.homePage.getCardText(requestedCard, "Title");
        Assert.assertEquals(expectedTitle, actualTitle, "Mismatch in titles, expected:" + expectedTitle + " but found: " + actualTitle);
    }

    @Then("Card (.*) text matches (.*) value")
    public void verifyCardTextMatches(String requestedCard, String expectedText) {
        String actualText = this.homePage.getCardText(requestedCard, "Text");
        Assert.assertEquals(expectedText, actualText, "Mismatch in titles, expected:" + expectedText + " but found: " + actualText);
    }

}


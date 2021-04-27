package miamato.stepdefinitions;

import com.miamato.context.CucumberStepContext;
import com.miamato.pageobject.PageManager;
import com.miamato.properties.PropertyManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BuyingSteps {

    private static final Logger logger = LogManager.getLogger(com.miamato.stepdefinitions.BuyingSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @Given ("Customer performs search for 'product.name'")
    public void customerPerformsSearchFor(String productName) {
        pageManager.header().enterSearchTerm(propertyManager.getProperty(productName))
                .header().initiateSearch();
    }
    @When ("Customer clicks on Buy it now filter")
    public void customerClicksOnBoyItNowFilter() {
        pageManager.searchResultsPage()
                .waitForElementToBeVisible(pageManager.searchResultsPage().buyItNowFilterButton, driver, logger)
                .click();
    }
    @When ("Customer clicks on Auction filter")
    public void customerClicksOnAuctionFilter() {
        pageManager.searchResultsPage()
                .waitForElementToBeVisible(pageManager.searchResultsPage().auctionFilterButton, driver, logger)
                .click();
    }
    @When ("Customer clicks for product on position 'product.position.nr'")
    public void customerClicksForProductOnPosition(int position) {
        pageManager.searchResultsPage()
                .waitForElementToBeVisible(pageManager.searchResultsPage().productsLinks.get(position), driver, logger)
                .click();
    }
    @When ("Customer passes zero to bid")
    public void customerPassesZeroToBid() {
        pageManager.productPage()
                .waitForElementToBeVisible(pageManager.productPage().bidField, driver, logger)
                .sendKeys("0");
        pageManager.productPage().bidButton.click();
    }

    @Then ("Customer is asked to place valid amount")
    public void customerIsAskedToPlaceValidAmount() {
        logger.info("Checking if customer is asked to perform correct bid");
        Assert.assertTrue(pageManager.bidPopup()
                .waitForElementToBeVisible(pageManager.bidPopup().notValidAmountMsg, driver, logger)
                .isDisplayed());
    }

    @Then ("Customer can buy product on position 'product.position.nr' right now")
    public void customerCanBuyNowProductOnPosition(int position) {
        logger.info("Checking filtering by Buy It Now works correct");
        Assert.assertTrue(pageManager.productPage()
                .waitForElementToBeVisible(pageManager.productPage().bidButton, driver, logger)
                .isDisplayed());
    }


    @Then ("Customer can bid for product on position 'product.position.nr'")
    public void customerCanBidForProductOnPosition(int position) {
        logger.info("Checking filtering by Auction works correct");
        Assert.assertTrue(pageManager.productPage()
                .waitForElementToBeVisible(pageManager.productPage().buyItNowButton, driver, logger)
                .isDisplayed());
    }
}

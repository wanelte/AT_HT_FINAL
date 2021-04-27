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

public class LoginSteps {

    private static final Logger logger = LogManager.getLogger(LoginSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();


    @Given("Customer is on page with url {string}")
    public void customerIsOnPageWithUrlHomePageUrl(String pageName) {
        pageManager.open(propertyManager.getProperty(pageName))
                .waitForPageToLoad();
    }
    @When ("Customer clicks on sign in link")
    public void customerClicksOnSignInLink() {
        pageManager.header().signInLink.click();
    }
    @Then("Page title contains 'Sign in'")
    public void pageTitleContainsSignIn() {
        logger.info("Checking if page title contains 'Sign in'");
        Assert.assertTrue(driver.getTitle().trim().contains("Sign in"));
    }
    @Given ("Customer is on sign in page")
    public void customerIsOnSignInPage() {
       customerIsOnPageWithUrlHomePageUrl(propertyManager.getProperty("homepage.url"));
       customerClicksOnSignInLink();
    }
    @Then("Customer is logged on a site")
    public void customerIsLoggedOnASite() {
        logger.info("Checking if Customer is sign in");
        Assert.assertTrue(pageManager.header().userDropdown.isDisplayed());
    }
    @Then ("Error login message is visible")
    public void errorLoginMessageIsVisible() {
        logger.info("Customer passed wrong data for login");
        Assert.assertTrue(pageManager.signInPage()
                .waitForElementToBeVisible(pageManager.signInPage().errorMsg, driver, logger)
                .isDisplayed());
    }
    @When ("Customer passes {string} to email field")
    public void customerPassesEmail(String email){
        pageManager.signInPage()
                .emailField.sendKeys(propertyManager.getProperty(email));
        pageManager.signInPage().signInContinueButton.click();

    }

    @When ("Customer passes {string} to password field")
    public void customerPassesPassword(String password) {
        pageManager.signInPage()
                .waitForElementToBeVisible(pageManager.signInPage().passwordField, driver, logger)
                .sendKeys(propertyManager.getProperty(password));
        pageManager.signInPage().signInButton.click();
    }
    @Given ("Customer logs on a site")
    public void customerLogsOnASite() {
        customerIsOnPageWithUrlHomePageUrl(propertyManager.getProperty("homepage.url"));
        customerClicksOnSignInLink();
        customerPassesEmail(propertyManager.getProperty("default.user.email"));
        customerPassesPassword(propertyManager.getProperty("default.user.password"));
    }
    @When ("Customer performs singing out")
    public void customerPerformsSigningOut() {
        pageManager.header().SignOut();
    }
    @Then("Customer is logged out")
    public void customerIsLoggedOut() {
        logger.info("Checking if Customer is logged out");
        Assert.assertTrue(pageManager.signOutPage()
                .waitForElementToBeVisible(pageManager.signOutPage().signOutBanner, driver, logger)
                .isDisplayed());
    }
}


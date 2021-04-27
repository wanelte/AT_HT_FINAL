package miamato.pageobject.ebay;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    private static final Logger logger = LogManager.getLogger(com.miamato.pageobject.ebay.Header.class.getSimpleName());

    @FindBy(xpath = "//input[@aria-label='Search for anything']")
    public WebElement searchField;

    @FindBy(xpath = "//input[@value='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@id='gh-ug']//a[text()='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "//button[@id='gh-ug']")
    public WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Sign out']")
    public WebElement signOutButton;

    public Header(WebDriver driver,
                  PageManager pageManager) {
        super(driver, pageManager);
    }

    public PageManager enterSearchTerm(String searchTerm){
        logger.info("Enterting search term: " + searchTerm);
        searchField.sendKeys(searchTerm);
        return pageManager;
    }

    public PageManager initiateSearch(){
        logger.info("Initiating search");
        searchButton.click();
        return pageManager;
    }
    public PageManager SignOut(){
        logger.info("Sign out");
        userDropdown.click();
        waitForElementToBeVisible(signOutButton,driver,logger).click();
        return pageManager;
    }

}


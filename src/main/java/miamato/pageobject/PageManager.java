package miamato.pageobject;

import com.miamato.pageobject.ebay.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageManager {

    private static final Logger logger = LogManager.getLogger(PageManager.class.getSimpleName());

    public WebDriver driver;
    private HomePage homePage;
    private Header header;
    private SearchResultsPage searchResultsPage;
    private SignInPage signInPage;
    private SignOutPage signOutPage;
    private BidPopup bidPopup;
    private ProductPage productPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(driver, this);
        return homePage;
    }
    public Header header(){
        if(header == null)
            header = new Header(driver, this);
        return header;
    }

    public SearchResultsPage searchResultsPage(){
        if(searchResultsPage == null)
            searchResultsPage = new SearchResultsPage(driver, this);
        return searchResultsPage;
    }

    public SignInPage signInPage(){
        if(signInPage == null)
            signInPage = new SignInPage(driver, this);
        return signInPage;
    }

    public SignOutPage signOutPage(){
        if(signOutPage == null)
            signOutPage = new SignOutPage(driver, this);
        return signOutPage;
    }

    public BidPopup bidPopup(){
        if(bidPopup == null)
            bidPopup = new BidPopup(driver, this);
        return bidPopup;
    }

    public ProductPage productPage(){
        if(productPage == null)
            productPage = new ProductPage(driver, this);
        return productPage;
    }

    public PageManager open(String url){
        logger.info("Opening page with url: " + url);
        driver.navigate().to(url);
        return this;
    }

    public PageManager waitForPageToLoad(){
        logger.info("Waiting till next page is loaded");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}

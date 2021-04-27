package miamato.pageobject.ebay;
import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private final Logger logger = LogManager.getLogger(SearchResultsPage.class.getSimpleName());

    @FindAll(@FindBy(xpath = "//li[contains(@class,'s-item') and contains(@data-view, 'iid:1')]//a[@class='s-item__link']"))
    public List<WebElement> productsLinks;

    @FindBy(xpath = "//span[text()='Buy It Now' and @class='srp-format-tabs-h2']")
    public WebElement buyItNowFilterButton;

    @FindBy(xpath = "//span[text()='Auction' and @class='srp-format-tabs-h2']")
    public WebElement auctionFilterButton;

    public SearchResultsPage(WebDriver driver, PageManager pageManager) {
            super(driver, pageManager);
        }
}

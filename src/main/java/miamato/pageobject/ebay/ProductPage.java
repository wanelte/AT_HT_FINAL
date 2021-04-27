package miamato.pageobject.ebay;
import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private final Logger logger = LogManager.getLogger(ProductPage.class.getSimpleName());

    @FindBy(xpath = "//a[contains(text(),'Buy It Now')]")
    public WebElement buyItNowButton;

    @FindBy(xpath = "//a[@data-cta='placebid']")
    public WebElement bidButton;

    @FindBy(xpath = "//input[@id='MaxBidId']")
    public WebElement bidField;


    public ProductPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }
}



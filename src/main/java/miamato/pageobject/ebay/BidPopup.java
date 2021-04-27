package miamato.pageobject.ebay;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BidPopup extends BasePage {

    private static final Logger logger = LogManager.getLogger(BidPopup.class.getSimpleName());

    @FindBy(xpath = "//span[text()='Please enter a valid amount.']")
    public WebElement notValidAmountMsg;

    public BidPopup(WebDriver driver,
                    PageManager pageManager) {
        super(driver, pageManager);
    }
}
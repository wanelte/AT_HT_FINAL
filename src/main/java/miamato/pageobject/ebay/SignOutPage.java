package miamato.pageobject.ebay;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SignOutPage.class.getSimpleName());

    @FindBy(xpath = "//div[@id='signout-banner']")
    public WebElement signOutBanner;

    public SignOutPage(WebDriver driver,
                    PageManager pageManager) {
        super(driver, pageManager);
    }

}

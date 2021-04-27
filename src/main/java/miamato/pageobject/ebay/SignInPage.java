package miamato.pageobject.ebay;

import com.miamato.pageobject.BasePage;
import com.miamato.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SignInPage.class.getSimpleName());

    @FindBy(xpath = "//input[@id='userid']")
    public WebElement emailField;
    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    public WebElement signInContinueButton;
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordField;
    @FindBy(xpath = "//p[@id='signin-error-msg']")
    public WebElement errorMsg;
    @FindBy(xpath = " //button[@id='sgnBt']")
    public WebElement signInButton;


    public SignInPage(WebDriver driver,
                    PageManager pageManager) {
        super(driver, pageManager);
    }

}

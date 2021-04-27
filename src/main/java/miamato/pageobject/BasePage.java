package miamato.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends Page {

    protected WebDriver driver;
    protected PageManager pageManager;

    public BasePage(WebDriver driver,PageManager pageManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.pageManager = pageManager;
    }

    protected String getPageTitle(){
        return driver.getTitle();
    }

    protected void open(String url){
        driver.navigate().to(url);
    }

    protected void selectFromDropdownByValue(WebElement element, String value, Logger logger){
        logger.info("Trying to select option: \"" + value + "\" from dropdown: " + element);
        Select dropdown = new Select(element);
        try {
            dropdown.selectByValue(value);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;
        }
    }

    protected void selectFromDropdownByVisibleText(WebElement element, String text, Logger logger){
        logger.info("Trying to select option: \"" + text + "\" from dropdown: " + element);
        Select dropdown = new Select(element);
        try {
            dropdown.selectByVisibleText(text);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;
        }
    }
    public WebElement waitForElementToBeVisible(WebElement element, WebDriver driver, Logger logger) {
        WebElement visibleElement = null;
        try {
            visibleElement = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(1))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error(" ---- Element with XPath: " + element + "  was not found on the page.");
            throw e;
        }
        return visibleElement;
    }
}

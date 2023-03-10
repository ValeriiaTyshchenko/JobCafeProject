package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;




public class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;


    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

    }


    protected void clickElementByXpath(String xpath){
        logger.info("Clicking element with xpath: " + xpath);

        findElementByXpath(xpath).click();

    }

    protected void  sendTextToElementByXpath(String xpath, String text){
        findElementByXpath(xpath).sendKeys(text);

    }

    protected boolean elementExists(String xpath){
        try {
            logger.info("Check element with xpath: " + xpath);

            webDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception err){
            return false;
        }


    }
    public WebElement findElementByXpath(String xpath){

        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement((By.xpath(xpath)));
        return element;

    }

    public void takeScreenshot(String name) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(("Screenshots" + name + ".jpeg")));

    }
    public List<LogEntry> getLogs() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();
        return logs;

    }

}

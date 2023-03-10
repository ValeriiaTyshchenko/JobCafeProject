package Utils;

import Pages.BasePage;
import Pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setUpHome() {

        page = new BasePage();
        webDriver = SharedDriver.setUpWebDriver();
        page.setWebDriver(webDriver);
    }


    @AfterAll
    public static void tearDownMain(){
        SharedDriver.closeDriver();
        webDriver = null;


    }

}

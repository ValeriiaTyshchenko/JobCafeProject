import Pages.AboutUsPage;
import Pages.BasePage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntry;

import java.util.logging.Level;

public class AboutUsPageTest extends UseCaseBase {
    private static HomePage homePage;
    private static AboutUsPage aboutUsPage;


    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        aboutUsPage = new AboutUsPage();
        homePage.navigateToHomePage();

    }

    @BeforeEach
    public void openAboutUsPage() {

        homePage.openAboutUsPage();

    }
    // Selenium4 logs verification
    @Test
    public void logsTest() {
        for (LogEntry e : aboutUsPage.getLogs()) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("Level: " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }
    }
}

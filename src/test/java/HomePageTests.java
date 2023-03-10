import Pages.AboutUsPage;
import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntry;


import java.io.IOException;
import java.util.logging.Level;


import static Pages.BasePage.logger;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTests extends UseCaseBase {
    private static HomePage homePage;

    @BeforeAll
    public static void classSetup(){
        homePage= new HomePage();

    }
    @BeforeEach
    public void beforeTests(){

      homePage.navigateToHomePage();
    }

// Selenium4 logs verification
    @Test
    public void logsTest() {
        for (LogEntry e : homePage.getLogs()) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("Level: " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }
    }

//    Navigate to Home Page
    @Test
    public void homePageLoadTest() throws IOException {
        logger.info("Home Page load test");
        Boolean success = homePage.isLogoVisible();
        homePage.takeScreenshot("HomePageTest");
        assertTrue(success);

    }
//    From Home Page click on the About Us menu option
    @Test
    public void openAboutUsPage() throws IOException {
        logger.info("About Us Page load test");
        AboutUsPage aboutUsPage = homePage.openAboutUsPage();
        boolean isLoaded = aboutUsPage.isLogoVisible();
        aboutUsPage.takeScreenshot("AboutUsPageLoadTest");
        assertTrue(isLoaded);


    }
//    From Home Page click on the Jobs menu option
    @Test
    public void openJobPage() throws IOException {
        logger.info("Job Page load test");
        JobsPage jobsPage = homePage.openJobPage();
        boolean isLoaded = jobsPage.isLogoVisible();
        jobsPage.takeScreenshot("JobPageLoadTest");
        assertTrue(isLoaded);


    }

}

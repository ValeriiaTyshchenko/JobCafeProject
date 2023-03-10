import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.logging.LogEntry;
import java.io.IOException;
import java.util.logging.Level;

import static Pages.BasePage.logger;
import static org.junit.jupiter.api.Assertions.*;


public class JobPageTest extends UseCaseBase {
    private static JobsPage jobsPage;
    private static HomePage homePage;

    @BeforeAll
    public static void classSetup() {
        jobsPage = new JobsPage();
        homePage = new HomePage();

    homePage.navigateToHomePage();

    }

    @BeforeEach
    public void openJobPage() {

        homePage.openJobPage();

    }
// Selenium4 logs verification
    @Test
    public void logsTest(){
        for (LogEntry e : jobsPage.getLogs()) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("Level: " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }
    }
// Search for a location: Toronto, Tel Aviv, Chicago, New York
    @Test
    public void jobSearchByLocation() throws IOException {
//        search by location - Toronto
        logger.info("Job search by Location - Toronto");
        jobsPage.searchByLocation("Toronto");
        jobsPage.clickOnSearchButton();
        boolean resultListToronto = jobsPage.resultListToronto();
        assertTrue(resultListToronto);
        jobsPage.takeScreenshot(" Job positions in Toronto");
        jobsPage.clickOnResetButton();

//        search by location - Tel Aviv
        logger.info("Job search by Location - Tel Aviv");
        jobsPage.searchByLocation("Tel Aviv");
        jobsPage.clickOnSearchButton();
        boolean resultListTelAviv = jobsPage.resultListTelAviv();
        assertTrue(resultListTelAviv);
        jobsPage.takeScreenshot(" Job positions in Tel Aviv");
        jobsPage.clickOnResetButton();

//        search by location - Chicago
        logger.info("Job search by Location - Chicago");
        jobsPage.searchByLocation("Chicago");
        jobsPage.clickOnSearchButton();
        boolean resultListChicago = jobsPage.resultListChicago();
        assertTrue(resultListChicago);
        jobsPage.takeScreenshot(" Job positions in Chicago");
        jobsPage.clickOnResetButton();

//        search by location - New York
        logger.info("Job search by Location - New York");
        jobsPage.searchByLocation("New York");
        jobsPage.clickOnSearchButton();
        boolean resultListNewYork = jobsPage.resultListNewYork();
        assertTrue(resultListNewYork);
        jobsPage.takeScreenshot(" Job positions in New York");
    }


//Search for a position: QA, Developer, Project Manager
    @Test
    public void jobSearchByPosition() throws IOException {
//        search by position - QA
        logger.info("Job search by Position - QA");
        jobsPage.searchByPosition("QA");
        jobsPage.clickOnSearchButton();
        boolean resultListQA = jobsPage.resultListQA();
        assertTrue(resultListQA);
        jobsPage.takeScreenshot(" QA position");
        jobsPage.clickOnResetButton();

//        search by position - Developer
        logger.info("Job search by Position - Developer");
        jobsPage.searchByPosition("Developer");
        jobsPage.clickOnSearchButton();
        boolean resultListDeveloper = jobsPage.resultListDeveloper();
        assertTrue(resultListDeveloper);
        jobsPage.takeScreenshot(" Developer position");
        jobsPage.clickOnResetButton();

//        search by position - Project Manager
        logger.info("Job search by Position - Project Manager");
        jobsPage.searchByPosition(" Project Manager");
        jobsPage.clickOnSearchButton();
        boolean resultListProjectManager = jobsPage.resultListProjectManager();
        assertTrue(resultListProjectManager);
        jobsPage.takeScreenshot(" Manager position");

    }
//Search by a company: Apple, Facebook, Google
    @Test
    public void jobSearchByCompany() throws IOException {
//        search by Company - Apple
        logger.info("Job search by Company - Apple");
        jobsPage.searchByCompany("Apple");
        jobsPage.clickOnSearchButton();
        boolean resultListApple = jobsPage.resultListApple();
        assertTrue(resultListApple);
        jobsPage.takeScreenshot(" Apple job positions");
        jobsPage.clickOnResetButton();

//        search by Company - Facebook
        logger.info("Job search by Company - Facebook");
        jobsPage.searchByCompany("Facebook");
        jobsPage.clickOnSearchButton();
        boolean resultListFacebook = jobsPage.resultListFacebook();
        assertTrue(resultListFacebook);
        jobsPage.takeScreenshot(" Facebook job positions");
        jobsPage.clickOnResetButton();

//        search by Company - Google
        logger.info("Job search by Company - Google");
        jobsPage.searchByCompany("Google");
        jobsPage.clickOnSearchButton();
        boolean resultListGoogle = jobsPage.resultListGoogle();
        assertTrue(resultListGoogle);
        jobsPage.takeScreenshot(" Google job positions");

    }
//combined search - look for manager positions in Google in USA

    @Test
    public void jobSearchCombine() throws IOException {
        logger.info("Job search: Manager position Google in USA");
        jobsPage.searchByLocation("USA");
        jobsPage.searchByPosition("Manager");
        jobsPage.searchByCompany("Google");
        jobsPage.clickOnSearchButton();
        boolean resultListCombine = jobsPage.resultListCombineSearch();
        assertTrue(resultListCombine);
        jobsPage.takeScreenshot(" Combine Job Search");
    }
//No results - enter abracadabra to position filter and press search button

    @Test
    public void negativeTest() throws IOException  {
        logger.info("Job page negative test - No result job search");
        jobsPage.searchByPosition("fgfjhkjklfd");
        jobsPage.clickOnSearchButton();
        boolean noResultSearch = jobsPage.noResultSearch();
        assertTrue(noResultSearch);
        jobsPage.takeScreenshot(" No Result Job Search");
    }
// Populate all the edit boxes. Press reset button

    @Test
    public void resetTest() throws IOException {
        logger.info("Job page - reset test");
//      Populate all the edit boxes
        jobsPage.searchByLocation("USA");
        jobsPage.searchByPosition("Manager");
        jobsPage.searchByCompany("Google");

//        Press reset button
        jobsPage.clickOnResetButton();
        String locationField = jobsPage.locationFieldValue();
        assertTrue(locationField.isEmpty() || locationField.isBlank());
        String positionField = jobsPage.getPositionFieldValue();
        assertTrue(positionField.isEmpty() || positionField.isBlank());
        String companyField = jobsPage.getCompanyFieldValue();
        assertTrue(companyField.isEmpty() || companyField.isBlank());
        jobsPage.takeScreenshot(" Reset Page");

    }


    }



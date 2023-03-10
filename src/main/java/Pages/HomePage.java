package Pages;

public class HomePage extends BasePage {

    private static final String LOGO_JOB_CAFE = "//*[@src='/img/site_bg.jpg']";
    private static final String ABOUT_US_PAGE = "//*[@name = 'About Us']";
    private static final String FIND_JOB = "//*[@name = 'Find Job']";


    public HomePage navigateToHomePage(){
        webDriver.get("http://167.99.178.249:3000/");

        return null;
    }

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_JOB_CAFE);
        return isVisible;
    }

    public AboutUsPage openAboutUsPage(){
        clickElementByXpath(ABOUT_US_PAGE);
        return new AboutUsPage();

    }

    public JobsPage openJobPage(){
        clickElementByXpath(FIND_JOB);
        return new JobsPage();

    }


}

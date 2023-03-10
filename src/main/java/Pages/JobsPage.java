package Pages;

import org.openqa.selenium.WebElement;

public class JobsPage extends BasePage{
    private static final String LOGO_JOBS = "//*[@class = 'd-flex justify-content-between align-items-center']";
    private static final String POSITION_FIELD = "//*[@name = 'position']";
    private static final String LOCATION_FIELD = "//*[@placeholder = 'location']";
    private static final String COMPANY_FIELD = "//*[@name = 'company']";
    private static final String SEARCH_BUTTON = "//*[text() = 'search']";
    private static final String RESET_BUTTON = "//*[text() = 'reset']";
    private static final String NO_RESULT_MESSAGE = "//*[text()='No results found!']";
    private static final String JOB_SEARCH_TORONTO = "//*[text()='Toronto, ON, Canada']";
    private static final String JOB_SEARCH_TEL_AVIV = "//*[text()='Tel Aviv-Yafo, Israel']";
    private static final String JOB_SEARCH_NEW_YORK = "//*[text()='New York, NY, USA']";
    private static final String JOB_SEARCH_CHICAGO = "//*[text()='Chicago, IL, USA']";
    private static final String JOB_SEARCH_GOOGLE_MANAGER_USA = "//*[text()='Google Inc.']";
    private static final String JOB_SEARCH_QA = "//h2[contains(text(), 'QA')]";
    private static final String JOB_SEARCH_DEVELOPER = "//h2[contains(text(), 'Developer')]";
    private static final String JOB_SEARCH_PROJECT_MANAGER = "//h2[contains(text(), 'Project')]";
    private static final String JOB_SEARCH_APPLE = "//b[contains(text(),'Apple')]";
    private static final String JOB_SEARCH_FACEBOOK = "//b[contains(text(),'Facebook')]";
    private static final String JOB_SEARCH_GOOGLE = "//b[contains(text(),'Google')]";

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_JOBS);
        return isVisible;
    }
    public String locationFieldValue(){
        WebElement locationField = findElementByXpath(LOCATION_FIELD);
        String locationValue = locationField.getAttribute("value");

     return locationValue;
    }
    public String getPositionFieldValue(){
        WebElement positionField = findElementByXpath(POSITION_FIELD);
        String positionValue = positionField.getAttribute("value");

        return positionValue;
    }
    public String getCompanyFieldValue(){
        WebElement companyField = findElementByXpath(COMPANY_FIELD);
        String companyValue = companyField.getAttribute("value");

        return  companyValue;
    }
    public void searchByLocation(String location) {
        sendTextToElementByXpath(LOCATION_FIELD, location);}
    public void searchByPosition(String position) {
        sendTextToElementByXpath(POSITION_FIELD, position);}

    public void searchByCompany(String company) {
        sendTextToElementByXpath(COMPANY_FIELD, company);}


    public void clickOnSearchButton() {
        clickElementByXpath(SEARCH_BUTTON);
    }
    public void clickOnResetButton() {
        clickElementByXpath(RESET_BUTTON);
    }

    public boolean resultListToronto(){
        return elementExists(JOB_SEARCH_TORONTO);


    }

    public boolean resultListTelAviv(){
        return elementExists(JOB_SEARCH_TEL_AVIV);


    }

    public boolean resultListChicago(){
        return elementExists(JOB_SEARCH_CHICAGO);


    }

    public boolean resultListNewYork(){
        return elementExists(JOB_SEARCH_NEW_YORK);


    }
    public boolean resultListQA(){
        return elementExists(JOB_SEARCH_QA);
    

    }
    public boolean resultListDeveloper() {
        return elementExists(JOB_SEARCH_DEVELOPER);


    }
        public boolean resultListProjectManager(){
            return elementExists(JOB_SEARCH_PROJECT_MANAGER);

    }

    public boolean resultListApple(){
        return elementExists(JOB_SEARCH_APPLE);


    }

    public boolean resultListFacebook(){
        return elementExists(JOB_SEARCH_FACEBOOK);

    }

    public boolean resultListGoogle(){
        return elementExists(JOB_SEARCH_GOOGLE);


    }

    public boolean resultListCombineSearch(){
        return elementExists(JOB_SEARCH_GOOGLE_MANAGER_USA);


    }

    public boolean noResultSearch(){
        return elementExists(NO_RESULT_MESSAGE);


    }

}

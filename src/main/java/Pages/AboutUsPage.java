package Pages;

public class AboutUsPage extends BasePage{
    private static final String LOGO_CAFE = "//*[text() = ' CAFE']";


    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_CAFE);
        return isVisible;
    }


}

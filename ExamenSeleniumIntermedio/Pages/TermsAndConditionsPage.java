package ExamenSeleniumIntermedio.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TermsAndConditionsPage extends BasePage {

    @FindBy(tagName = "a" )
    List<WebElement> linkList;

    public boolean isLinkDisplayed(String linkName) {
        boolean isDisplayed = false;
        for(WebElement a : linkList) {
            if(a.getText().contains(linkName)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }
}

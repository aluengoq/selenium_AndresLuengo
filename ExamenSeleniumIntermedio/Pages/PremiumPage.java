package ExamenSeleniumIntermedio.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PremiumPage extends BasePage {

    @FindBy(tagName = "h3")
    List<WebElement> h3List;

    public boolean isPlanDisplayed(String planName) {
        boolean planNameDisplayed = false;

        for(WebElement h3 : h3List) {
            if(h3.getText().contains(planName)) {
                planNameDisplayed = true;
                break;
            }
        }
        return planNameDisplayed;
    }
}

package ExamenEjemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(xpath = "//*[contains(text(),'2 guests')]")
    List<WebElement> twoGuestsList;

    @FindBy(tagName = "h1")
    List<WebElement> h1List;

    public int getTwoGuestListSize() throws InterruptedException {
        Thread.sleep(7000);
        return twoGuestsList.size();
    }

    public boolean isPlaceDisplayed(String place) {
        boolean foundPlace = false;
//        try {
            for (WebElement h1 : h1List) {
                if (h1.getText().contains(place)) {
                    foundPlace = true;
                    break;
                }
            }
//        } catch (Exception exception) {
//
//        }
        return foundPlace;
    }

    public int getMatchingExperienceListSize(String place) {
        return driver.findElements(By.xpath(String.format("//*[containts(text(),'%s)]", place))).size();
    }
}

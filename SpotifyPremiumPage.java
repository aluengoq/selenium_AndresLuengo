package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyPremiumPage {

    public WebDriver driver;

    public SpotifyPremiumPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public String getSpotifyTitle() {
        return driver.getTitle();
    }

    public String getSpotifyURL() {
        return driver.getCurrentUrl();
    }

    public boolean validateTitlePresence(String title) {
        boolean isTitlePresent = false;
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));

        for (WebElement h1 : h1List) {
            if (h1.getText().equals(title)) {
                isTitlePresent = true;
            }
        }
        return isTitlePresent;
    }
}

package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyLandingPage {

    public WebDriver driver;

    public SpotifyLandingPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public String getSpotifyTitle() {
        return driver.getTitle();
    }

    public String getSpotifyURL() {
        return driver.getCurrentUrl();
    }

    public SpotifyRegistrationPage clickOnRegister() {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/ar/signup/']")).click();
        return new SpotifyRegistrationPage(driver);
    }

    public SpotifyPremiumPage clickOnPremium() {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/ar/premium/']")).click();
        return new SpotifyPremiumPage(driver);
    }
}

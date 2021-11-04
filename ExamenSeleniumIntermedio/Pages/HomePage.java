package ExamenSeleniumIntermedio.Pages;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public void open() {
        driver.get("https://www.spotify.com/uy/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    public void clickOnSection(String section) {
        driver.findElement(By.linkText(section)).click();
    }
}

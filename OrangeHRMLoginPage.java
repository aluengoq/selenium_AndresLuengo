package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLoginPage {

    public WebDriver driver;

    public OrangeHRMLoginPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public OrangeHRMHomePage clickOnLogin() {
        driver.findElement(By.id("btnLogin")).click();
        return new OrangeHRMHomePage(driver);
    }

}

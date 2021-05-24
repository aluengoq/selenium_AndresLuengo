package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMTimesheetsPage {

    public WebDriver driver;

    public OrangeHRMTimesheetsPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public String getOrangeHRMTitle() {
        return driver.getTitle();
    }

    public String getOrangeHRMURL() {
        return driver.getCurrentUrl();
    }

    public int getPendingForApprovalTimesheets() {
        return driver.findElements(By.cssSelector(".bordered tbody > tr")).size();
    }
}

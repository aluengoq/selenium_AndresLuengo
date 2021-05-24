package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage {

    public WebDriver driver;

    public OrangeHRMHomePage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void printQuickAccessListItems() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> quickAccessList = driver.findElements(By.className("quick-access-heading"));

        System.out.println("The Quick Access items of the site are:");
        for (WebElement item : quickAccessList) {
            System.out.println(item.getText());
        }
    }

    public int getQuickAccessListSize() {
        return driver.findElements(By.className("quick-access-heading")).size();
    }

    public OrangeHRMTimesheetsPage clickOnTimesheetstoApprove() {
        driver.findElement(By.cssSelector(".link-container.pending-timesheets-approval-container")).click();
        return new OrangeHRMTimesheetsPage(driver);
    }

}

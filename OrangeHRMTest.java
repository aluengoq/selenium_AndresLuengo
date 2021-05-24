package Clase15.Test;

import Clase15.PageObject.OrangeHRMHomePage;
import Clase15.PageObject.OrangeHRMLoginPage;
import Clase15.PageObject.OrangeHRMTimesheetsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
    }
    
    @Test
    public void orangeHRMTest() {
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage(driver);

        OrangeHRMHomePage orangeHRMHomePage = orangeHRMLoginPage.clickOnLogin();

        orangeHRMHomePage.printQuickAccessListItems();

        Assert.assertEquals(orangeHRMHomePage.getQuickAccessListSize(), 8);

        OrangeHRMTimesheetsPage orangeHRMTimesheetsPage = orangeHRMHomePage.clickOnTimesheetstoApprove();

        Assert.assertEquals(orangeHRMTimesheetsPage.getOrangeHRMTitle(), "Employee Timesheets");
        Assert.assertEquals(orangeHRMTimesheetsPage.getOrangeHRMURL(), "https://orangehrm-demo-6x.orangehrmlive.com/client/#/time/employee_timesheets");

        System.out.println("Timesheets pending to be approved: " + orangeHRMTimesheetsPage.getPendingForApprovalTimesheets());
    }


    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}

package Clase12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngSalesforce {

    public WebDriver driver;
    public static final String salesforceUrl = "https://login.salesforce.com/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(salesforceUrl);
    }

    @Test (priority = 1)
    public void validateSalesforceLogoTest() {
        WebElement salesforceLogo = driver.findElement(By.id("logo"));
        System.out.println("El TagName del logo es " + salesforceLogo.getTagName());
        System.out.println("y su atributo alt es " + salesforceLogo.getAttribute("alt"));
    }

    @Test (enabled = false)
    public void RememberMeIsSelected() {
        WebElement rememberMeCheckbox = driver.findElement(By.id("rememberUn"));
        rememberMeCheckbox.click();
        Assert.assertTrue(rememberMeCheckbox.isSelected());
    }

    @Test (priority = 2)
    public void FooterIsValid() {
        WebElement footer = driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.getText().contains("Reservados todos los derechos."));
    }

    @Test (priority = 3)
    public void LoginFailureTest() {
        driver.get("https://login.salesforce.com/?locale=eu");

        WebElement salesforceLogo = driver.findElement(By.name("logo"));
        Assert.assertTrue(salesforceLogo.isDisplayed());

        driver.findElement(By.name("username")).sendKeys("test@test.com");
        driver.findElement(By.name("pw")).sendKeys("123466");
        driver.findElement(By.name("Login")).click();

        WebElement actualFailureError = driver.findElement(By.id("error"));
        String expectedFailureError = "Your access to salesforce.com has been disabled by " +
                "your system administrator. Please contact your Administrator for more information.";
        Assert.assertEquals(expectedFailureError, actualFailureError.getText());
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}

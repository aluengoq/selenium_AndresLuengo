package Prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void landingPageTest() {
        WebElement pageH1 = driver.findElement(By.tagName("h1"));
        System.out.println("h1 --> " + pageH1.getText());

        List<WebElement> h3List = driver.findElements(By.tagName("h3"));
        for (int i = 0; i < 5; i++) {
            System.out.println("h3 --> " + h3List.get(i).getText());
        }

        Assert.assertEquals(driver.getTitle(), "Most popular TestNG interview questions - Software Testing Questions");
        Assert.assertTrue(driver.getCurrentUrl().contains("testng"));

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        Assert.assertTrue(seleniumLink.isDisplayed(), "No se encontro la opción Selenium en el menú");

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        Assert.assertTrue(javaLink.isDisplayed(), "No se encontro la opción Java en el menú");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}

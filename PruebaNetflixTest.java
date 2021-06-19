package Prueba;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {

    public WebDriver driver;
    public Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void iniciarSesionPageTest() {
        driver.findElement(By.xpath("//a[contains(text(),'Iniciar sesión')]")).click();

        String h1Title = driver.findElement(By.tagName("h1")).getText();

        WebElement iniciarSesionFB = driver.findElement(By.className("fbBtnText"));

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        Assert.assertEquals(h1Title, "Inicia sesión");
        Assert.assertTrue(iniciarSesionFB.isDisplayed());
    }


    @Test
    public void fakeEmailTest() {
        driver.findElement(By.xpath("//input[@id='id_email_hero_fuji']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-uia='our-story-cta-hero_fuji']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Test(dataProvider = "email", dataProviderClass = dataProvider.class)
    public void dataProviderEmailTest(String email) {
        driver.findElement(By.xpath("//input[@id='id_email_hero_fuji']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@data-uia='our-story-cta-hero_fuji']")).click();
    }

    @Test
    @Parameters({"specificTag"})
    public void printTagsTest(@Optional("h1") String tagName) {
        List<WebElement> tagList = driver.findElements(By.tagName(tagName));

        for (WebElement tag : tagList) {
            System.out.println(tag.getText());
        }
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}

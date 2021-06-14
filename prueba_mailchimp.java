package ModeloPrueba;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class prueba_mailchimp {

    public WebDriver driver;
    public Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button.onetrust-close-btn-handler.onetrust-close-btn-ui.banner-close-button.onetrust-lg.ot-close-icon")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test (priority = 5)
    public void validarTituloTest() {
        Assert.assertEquals(driver.getTitle(), "Login | Mailchimp");
    }

    @Test (priority = 4)
    public void iniciarSesionPageTest() {
        boolean isLogInTitleDisplayed = driver.findElement(By.tagName("h1")).isDisplayed();
        boolean isNeedAnAccountDisplayed = driver.findElement(By.xpath("//span[contains(text(),'Need a Mailchimp account?')]")).isDisplayed();

        Assert.assertTrue(isLogInTitleDisplayed);
        Assert.assertTrue(isNeedAnAccountDisplayed);
    }

    @Test (priority = 3)
    public void loginErrorTest() {
        driver.findElement(By.id("username")).sendKeys("XXXXX@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//p[contains(text(),'Looks like you forgot your password there')]")).isDisplayed();
        boolean isCheckboxSelected = driver.findElement(By.xpath("//label[@for='stay-signed-in']")).isSelected();

        Assert.assertTrue(isErrorMsgDisplayed);
        Assert.assertFalse(isCheckboxSelected);
    }

    @Test (priority = 2)
    public void fakeEmailTest() {
        driver.navigate().to("https://login.mailchimp.com/signup/");
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Test(dataProvider = "email", dataProviderClass = DataProviderTest.class, priority = 1)
    public void dataProviderEmailTest(String email) {
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("holamundo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        boolean isUsernameErrorDisplayed = driver.findElement(By.xpath("//p[contains(text(),'Can we help you recover your')]")).isDisplayed();

        Assert.assertTrue(isUsernameErrorDisplayed);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}

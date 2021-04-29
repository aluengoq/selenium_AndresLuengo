package Clase11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class spotifyWithCssSelectorTest {

    @Test
    public void spotifyByPlaceHolderTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("testuser@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("testuser@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("P4$$w0rd");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Testuser");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("18");

        Select monthDropdown = new Select(driver.findElement(By.cssSelector("select[name='month']")));
        monthDropdown.selectByVisibleText("Septiembre");

        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1989");
        driver.findElement(By.cssSelector("label[for='gender_option_female']")).click();
        driver.findElement(By.cssSelector("label[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("label[for='third-party-checkbox']")).click();
    }
}


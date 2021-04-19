package Clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static Clase9.Ejercicio9.getDriver;

public class registrationFacebookTest {

    @Test
    public void fullRegistrationTest() throws InterruptedException {

        WebDriver driver = getDriver("https://www.facebook.com/");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(2000);
        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys("Smith");

        WebElement phoneNumberField = driver.findElement(By.name("reg_email__"));
        phoneNumberField.sendKeys("5555555");

        WebElement passwordField = driver.findElement(By.name("reg_passwd__"));
        passwordField.sendKeys("123456789");

        WebElement days = driver.findElement(By.name("birthday_day"));
        Select dayCombobox = new Select(days);
        dayCombobox.selectByVisibleText("26");

        WebElement months = driver.findElement(By.name("birthday_month"));
        Select monthCombobox = new Select(months);
        monthCombobox.selectByVisibleText("jun");

        WebElement years = driver.findElement(By.name("birthday_year"));
        Select yearCombobox = new Select(years);
        yearCombobox.selectByVisibleText("1980");

        List<WebElement> labelList = driver.findElements(By.tagName("label"));
        for (WebElement label : labelList) {
            if (label.getText().contentEquals("Hombre")) {
                label.click();
            }
        }
    }
}

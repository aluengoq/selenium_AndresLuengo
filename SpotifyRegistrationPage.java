package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SpotifyRegistrationPage {

    public WebDriver driver;

    public SpotifyRegistrationPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public String getSpotifyTitle() {
        return driver.getTitle();
    }

    public String getSpotifyURL() {
        return driver.getCurrentUrl();
    }

    public void fillEmailField(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void fillConfirmEmailField(String email) {
        driver.findElement(By.id("confirm")).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void fillUsernameField(String username) {
        driver.findElement(By.id("displayname")).sendKeys(username);
    }

    public void fillBirthDate(int day,String month, int year) {
        driver.findElement(By.id("day")).sendKeys(String.valueOf(day));
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        monthDropdown.selectByVisibleText(month);
        driver.findElement(By.id("year")).sendKeys(String.valueOf(year));
    }

    public void clickOnGender(String sex) {
        driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", sex))).click();
    }

    public void clickOnSubmit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public String getInvalidEmailErrorMsg() {
        return driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico no es válido.')]")).getText();
    }
}

package ExamenEjemplo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Homepage extends BasePage {

    public Homepage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy(id = "bigsearch-query-attached-location-input")
    WebElement locationField;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-0']")
    WebElement checkInField;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-guests-button']")
    WebElement guestField;

    @FindBy(xpath = "//button[@data-testid='stepper-adults-increase-button']")
    WebElement increaseAdultsBtn;

    @FindBy(css = "._w64aej button")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-dates-button']")
    WebElement datefield;

    @FindBy(xpath = "//input[@placeholder='Where are you going?']")
    WebElement locationPlaceholder;

    @FindBy(css = "._1slbw8s span._1i13tcg span:nth-child(1)")
    List<WebElement> nearbyPlacesList;

    @FindBy(css = "._1slbw8s span._1i13tcg span:nth-child(2)")
    List<WebElement> driveHoursList;

    public void open() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        PageFactory.initElements(driver, this);
    }

    public void selectLocation(String location) throws InterruptedException {
        Thread.sleep(5000);
        locationField.sendKeys(location);
    }

    public void clickOnCheckInField() {
        checkInField.click();
    }

    public void selectDate(String date) {
        driver.findElement(By.xpath(String.format("//div[@data-testid='datepicker-day-%s']", date))).click();
    }

    public void setNumberOfAdults(int numberOfAdults) {
        guestField.click();
        for (int i = 0; i < numberOfAdults; i++) {
            increaseAdultsBtn.click();
        }
    }

    public ResultsPage clickOnSearch() {
        searchBtn.click();
        return new ResultsPage(driver);
    }

    public void clickOnSection(String section) throws InterruptedException {
        driver.findElement(By.xpath(String.format("//button[@data-testid='header-tab-search-block-tab-true-%s']", section))).click();
        Thread.sleep(3000);
    }

    public void selectExperienceDate(String date) throws InterruptedException {
        Thread.sleep(3000);
        datefield.click();
        driver.findElement(By.xpath(String.format("//div[@data-testid='datepicker-day-%s']", date))).click();
    }

    public String getLocationValue() {
        return locationPlaceholder.getAttribute("value");
    }

    public boolean isSectionSelected(String section) throws InterruptedException {
        Thread.sleep(3000);
        boolean isSelected = false;
        String selected = driver.findElement(By.xpath(String.format("//button[@data-testid='header-tab-search-block-tab-true-%s']", section))).getAttribute("aria-selected");
        if (selected.equals("true")) {
            isSelected = true;
        }
        return  isSelected;
    }

    public void printNumberOfNearbyPlaces() {
        System.out.println("There's a total of " + nearbyPlacesList.size() + " places nearby");
    }

    public void printNearbyPlacesAndHoursDrive() {
        int cont = 0;
        for(WebElement nearbyPlace : nearbyPlacesList) {
            System.out.println("---> Place: " + nearbyPlace.getText() + " at " + driveHoursList.get(cont).getText());
            cont++;
        }
    }
}

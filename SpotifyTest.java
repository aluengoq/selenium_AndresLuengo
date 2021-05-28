package Clase15.Test;

import Clase15.PageObject.SpotifyLandingPage;
import Clase15.PageObject.SpotifyPremiumPage;
import Clase15.PageObject.SpotifyRegistrationPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SpotifyTest {

    public WebDriver driver;

    Faker faker = new Faker();
    String password = faker.internet().password();
    String username = faker.name().username();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/");
    }

    @Test
    public void registrationTest() {
        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);

        Assert.assertEquals(spotifyLandingPage.getSpotifyTitle(), "Escuchar es todo - Spotify");
        Assert.assertEquals(spotifyLandingPage.getSpotifyURL(), "https://www.spotify.com/ar/");

        SpotifyRegistrationPage spotifyRegistrationPage = spotifyLandingPage.clickOnRegister();

        Assert.assertEquals(spotifyRegistrationPage.getSpotifyTitle(), "Registrarte - Spotify");
        Assert.assertEquals(spotifyRegistrationPage.getSpotifyURL(), "https://www.spotify.com/ar/signup/");

        spotifyRegistrationPage.fillEmailField("@@@.com");
        spotifyRegistrationPage.fillConfirmEmailField("@@@.com");
        spotifyRegistrationPage.fillPasswordField(password);
        spotifyRegistrationPage.fillUsernameField(username);
        spotifyRegistrationPage.fillBirthDate(23, "Mayo", 1989);
        spotifyRegistrationPage.clickOnGender("Hombre");
        spotifyRegistrationPage.clickOnSubmit();

        Assert.assertEquals(spotifyRegistrationPage.getInvalidEmailErrorMsg(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
    }

    @Test
    public void validateH1titles() {
        SpotifyLandingPage spotifyLandingPage = new SpotifyLandingPage(driver);

        Assert.assertEquals(spotifyLandingPage.getSpotifyTitle(), "Escuchar es todo - Spotify");
        Assert.assertEquals(spotifyLandingPage.getSpotifyURL(), "https://www.spotify.com/ar/");

        SpotifyPremiumPage spotifyPremiumPage = spotifyLandingPage.clickOnPremium();

        Assert.assertEquals(spotifyPremiumPage.getSpotifyTitle(), "Spotify Premium - Spotify (AR)");
        Assert.assertEquals(spotifyPremiumPage.getSpotifyURL(), "https://www.spotify.com/ar/premium/");

        Assert.assertTrue(spotifyPremiumPage.validateTitlePresence("Obtené Premium gratis por 1 mes"));
        Assert.assertTrue(spotifyPremiumPage.validateTitlePresence("Beneficios de Premium"));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}

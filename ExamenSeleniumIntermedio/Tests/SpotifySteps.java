package ExamenSeleniumIntermedio.Tests;

import ExamenSeleniumIntermedio.Pages.HomePage;
import ExamenSeleniumIntermedio.Pages.PremiumPage;
import ExamenSeleniumIntermedio.Pages.SignupPage;
import ExamenSeleniumIntermedio.Pages.TermsAndConditionsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SpotifySteps extends BaseTest {

    HomePage homePage = new HomePage();
    PremiumPage premiumPage = new PremiumPage();
    SignupPage signupPage = new SignupPage();
    TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage();

    @Given("the user is at Spotify HomePage")
    public void user_at_the_spotify_homepage() {
        homePage.open();
    }

    @When("the user clicks on {string} section")
    public void user_clicks_on_section(String sectionName) {
        homePage.clickOnSection(sectionName);
    }

    @Then("the user to see the {string} plan displayed")
    public void user_to_see_the_plan_displayed(String planName) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(premiumPage.getPageTitle().contains("Premium"), "This is not the Premium page");
        Assert.assertTrue(premiumPage.isPlanDisplayed(planName), "Plan is not available");
    }

    @Then("the user gets to Spotify Registration Page")
    public void user_gets_to_spotify_registration_page()  {
        Assert.assertTrue(signupPage.getPageTitle().contains("Registrarte"), "This is not the Registration page");
    }

    @When("the user completes the email field with {string}")
    public void user_completes_the_email_field_with(String emailInput) {
        signupPage.fillInput(emailInput);
    }

    @When("the user clicks on the confirm email field")
    public void user_clicks_on_the_confirm_email_field() {
        signupPage.clickOnConfirmField();
    }

    @Then("the user should see the {string} message displayed")
    public void user_should_see_the_message_displayed(String errorMsg) {
        Assert.assertTrue(signupPage.isErrorMsgDisplayed(errorMsg), errorMsg + " error message is not displayed");
    }

    @When("the user navigates to {string}")
    public void user_navigates_to(String url) {
        homePage.navigateTo(url);
    }

    @Then("the user should see the {string} displayed")
    public void user_should_see_the_link_name_displayed(String linkName) {
        Assert.assertTrue(termsAndConditionsPage.getPageTitle().contains("Términos y Condiciones"), "This is not the Terms and Conditions page");
        Assert.assertTrue(termsAndConditionsPage.isLinkDisplayed(linkName), linkName + " is not present");
    }
}

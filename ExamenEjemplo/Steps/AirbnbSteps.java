package ExamenEjemplo.Steps;

import ExamenEjemplo.Pages.Homepage;
import ExamenEjemplo.Pages.ResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.IsEqual.equalTo;

public class AirbnbSteps {

    public WebDriver driver;
    public Homepage homepage = new Homepage(driver);
    public ResultsPage resultsPage;

    @Given("the user is at the homepage")
    public void user_is_at_the_homepage() {
        homepage.open();
    }

    @When("the user searches for {string}")
    public void user_searches_for(String location) throws InterruptedException {
        homepage.selectLocation(location);
        MatcherAssert.assertThat("Place does not match!", homepage.getLocationValue(), equalTo(location));
    }

    @When("selects {string} as check in date")
    public void selects_check_in_date(String date) {
        homepage.clickOnCheckInField();
        homepage.selectDate(date);
    }

    @When("selects {string} as check out date")
    public void selects_check_out_date(String date) {
        homepage.selectDate(date);
    }

    @When("adds {int} adults as guests")
    public void adds_adults_as_guests(int numberOfAdults) {
        homepage.setNumberOfAdults(numberOfAdults);
    }

    @When("clicks on search")
    public void clicks_on_search() {
        resultsPage = homepage.clickOnSearch();
    }

    @Given("the user goes to {string} section")
    public void user_goes_to_section(String section) throws InterruptedException {
        homepage.clickOnSection(section);
        MatcherAssert.assertThat("This is not the Experiences section",homepage.isSectionSelected(section), equalTo(true));
    }

    @When("selects {string} as date")
    public void user_selects_experience_start_date(String date) throws InterruptedException {
        homepage.selectExperienceDate(date);
    }

    @Then("the user should see the list of nearby places and how many hours away they are")
    public void user_should_see_the_list_of_nearby_places_and_drive_hours() {
        homepage.printNumberOfNearbyPlaces();
        homepage.printNearbyPlacesAndHoursDrive();
        homepage.closeBrowser();
    }

    @Then("the user should see the title Stays in {string} and {int} matches with the number of guests in the results")
    public void validate_results_match_with_search_criteria(String place, int numberOfMatches) throws InterruptedException {
        MatcherAssert.assertThat("Place is not being displayed", resultsPage.getH1Text().contains(place), equalTo(true));
        MatcherAssert.assertThat("Number of results don't match", resultsPage.getTwoGuestListSize(), equalTo(numberOfMatches));
        homepage.closeBrowser();
    }

    @Then("the user should see {int} results for {string}")
    public void user_should_see_the_results_for(int numberOfResults, String place) throws InterruptedException {
        Thread.sleep(3000);
        MatcherAssert.assertThat("This is not the experiences result page for " + place, resultsPage.getPageTitle().contains(place), equalTo(true));
        MatcherAssert.assertThat("Number of results do not match!", resultsPage.getH1Text().contains(numberOfResults + " experiences"), equalTo(true));
        homepage.closeBrowser();
    }
}

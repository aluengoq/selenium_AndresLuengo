package ExamenEjemplo.Steps;

import ExamenEjemplo.Pages.Homepage;
import ExamenEjemplo.Pages.ResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.core.IsEqual.equalTo;

public class HomepageSteps extends BaseTest{

    Homepage homepage = new Homepage(driver);

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
        ResultsPage resultsPage = homepage.clickOnSearch();
    }

    @Given("the user goes to {string} section")
    public void user_goes_to_section(String section) throws InterruptedException {
        homepage.clickOnSection(section);
        //MatcherAssert.assertThat("This is not the Experiences section",homepage.isSectionSelected(section), equalTo(true));
    }

    @When("selects {string} as date")
    public void user_selects_experience_start_date(String date) throws InterruptedException {
        homepage.selectExperienceDate(date);
    }
}

package ExamenEjemplo.Steps;

import ExamenEjemplo.Pages.ResultsPage;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.core.IsEqual.equalTo;

public class ResultsPageSteps extends BaseTest {

    ResultsPage resultsPage = new ResultsPage(driver);

    @Then("the user should see the title Stays in {string} and {int} matches with the number of guests in the results")
    public void validate_results_match_with_search_criteria(String place, int numberOfMatches) throws InterruptedException {
        MatcherAssert.assertThat("Place is not being displayed", resultsPage.isPlaceDisplayed(place), equalTo(true));
        MatcherAssert.assertThat("Number of results don't match", resultsPage.getTwoGuestListSize(), equalTo(numberOfMatches));
        resultsPage.closeBrowser();
    }

    @Then("the user should see {int} results for {string}")
    public void user_should_see_the_results_for(int numberOfResults, String place) {
        MatcherAssert.assertThat("This is not the experiences result page for " + place, resultsPage.getPageTitle().contains(place), equalTo(true));
        MatcherAssert.assertThat("Number of results do not match!", resultsPage.getMatchingExperienceListSize(place), equalTo(numberOfResults));
    }
}

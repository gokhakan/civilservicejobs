package uk.gov.service.civilservicejobs.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.gov.service.civilservicejobs.pages.CivilServiceJobSearchPage;
import uk.gov.service.civilservicejobs.pages.QuickCheckNeededPage;
import uk.gov.service.civilservicejobs.pages.SearchResultsPage;
import uk.gov.service.civilservicejobs.utilities.ConfigurationReader;
import uk.gov.service.civilservicejobs.utilities.Driver;

import static org.junit.Assert.assertEquals;
import static uk.gov.service.civilservicejobs.utilities.Commons.safeClick;
import static uk.gov.service.civilservicejobs.utilities.Commons.safeSendKeys;

public class Steps {
    @Given("user is on search page")
    public void user_is_on_search_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        new QuickCheckNeededPage().clickAndContinueCaptcha();
        assertEquals("Civil Service job search - Civil Service Jobs - GOV.UK", Driver.get().getTitle());
        new CivilServiceJobSearchPage().acceptAllCookies();
    }

    @When("user searches for {string} in {string}")
    public void user_searches_for_in(String what, String where) {
        CivilServiceJobSearchPage searchPage = new CivilServiceJobSearchPage();

        safeSendKeys(searchPage.what, what);
        safeSendKeys(searchPage.where, where);
        safeClick(searchPage.submitSearch);
    }

    @Then("{string} search results should be displayed")
    public void search_results_should_be_displayed(String numberOfResults) {
        assertEquals(numberOfResults + " Search results", new SearchResultsPage().resultsTitle.getText());
    }

    @When("user filters {string}")
    public void user_filters(String filter) {
        SearchResultsPage searchResultsPage = new SearchResultsPage();

        safeClick(searchResultsPage.department);
        safeClick(searchResultsPage.searchBox);
        safeSendKeys(searchResultsPage.searchBox, filter);
        safeClick(searchResultsPage.medicines);
        safeClick(searchResultsPage.updateResult);
    }
}

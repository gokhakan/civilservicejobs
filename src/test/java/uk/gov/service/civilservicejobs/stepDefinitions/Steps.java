package uk.gov.service.civilservicejobs.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.gov.service.civilservicejobs.pages.CivilServiceJobSearchPage;
import uk.gov.service.civilservicejobs.pages.*;
import uk.gov.service.civilservicejobs.pages.SearchResultsPage;
import uk.gov.service.civilservicejobs.utilities.Commons;
import uk.gov.service.civilservicejobs.utilities.ConfigurationReader;
import uk.gov.service.civilservicejobs.utilities.Driver;

import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static uk.gov.service.civilservicejobs.utilities.Commons.safeClick;
import static uk.gov.service.civilservicejobs.utilities.Commons.safeSendKeys;

public class Steps {

    private static final Logger logger = LogManager.getLogger(Steps.class);

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

    @When("user clicks on {string}")
    public void user_clicks_on(String linkName) {
        logger.info("linkName = {}", linkName);

        switch (linkName.toLowerCase()) {
            case "careers available in the civil service (opens in a new window)":
                Commons.safeClick(new CivilServiceJobSearchPage().careersAvailableInTheCivilService);

                // Handle the new window
                String originalWindow = Driver.get().getWindowHandle();
                Set<String> allWindows = Driver.get().getWindowHandles();

                // Switch to the new window
                for (String windowHandle : allWindows) {
                    if (!windowHandle.equals(originalWindow)) {
                        Driver.get().switchTo().window(windowHandle);
                        logger.info("Switched to new window");
                        break;
                    }
                }

                // Verify we're on the correct page
                assertEquals("https://www.civil-service-careers.gov.uk/",
                        Driver.get().getCurrentUrl());
                logger.info("Current URL: " + Driver.get().getCurrentUrl());
                break;

            case "working for the civil service":
                logger.info("Attempting to click 'Working for the Civil Service'");
                Commons.safeClick(new CivilServiceCareersPage().workingForTheCivilService);
                break;

            case "civil service code":
                Commons.safeClick(new WorkingForTheCivilServicePage().civilServiceCode);
                break;

            default:
                throw new IllegalArgumentException("Unknown link: " + linkName);
        }
    }

    @Then("user is on {string} page")
    public void user_is_on_page(String pageName) {
        logger.info("pageName = {}", pageName);
        switch (pageName.toLowerCase()) {

            case "workingforthecivilservice":
                assertEquals("https://www.civil-service-careers.gov.uk/workingforthecivilservice/", Driver.get().getCurrentUrl());
                break;

            case "code":
                assertEquals(
                        "https://civilservicecommission.independent.gov.uk/code/the-code",
                        Driver.get().getCurrentUrl().replaceAll("/$", "")  // Remove trailing slash
                );
                break;

            default:
                throw new IllegalArgumentException("Unknown link: " + pageName);
        }
    }
}

package uk.gov.service.civilservicejobs.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import uk.gov.service.civilservicejobs.pages.CivilServiceJobSearchPage;
import uk.gov.service.civilservicejobs.pages.QuickCheckNeededPage;
import uk.gov.service.civilservicejobs.pages.SearchResultsPage;
import uk.gov.service.civilservicejobs.utilities.BrowserUtils;
import uk.gov.service.civilservicejobs.utilities.ConfigurationReader;
import uk.gov.service.civilservicejobs.utilities.Driver;

import static org.junit.Assert.assertEquals;

public class Steps {
    @Given("user is on search page")
    public void user_is_on_search_page() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        new QuickCheckNeededPage().clickAndContinueCaptcha();
        assertEquals( "Civil Service job search - Civil Service Jobs - GOV.UK", Driver.get().getTitle());
        new CivilServiceJobSearchPage().acceptAllCookies();
    }

    @When("user searches for {string} in {string}")
    public void user_searches_for_in(String what, String where) {
        new CivilServiceJobSearchPage().what.sendKeys(what);
        new CivilServiceJobSearchPage().where.sendKeys(where);
        new CivilServiceJobSearchPage().submitSearch.click();
        BrowserUtils.waitForPageToLoad(4);
    }

    @Then("{string} search results should be displayed")
    public void search_results_should_be_displayed(String numberOfResults) {
        assertEquals(numberOfResults + " Search results", new SearchResultsPage().resultsTitle.getText());
    }

    @When("user filters {string}")
    public void user_filters(String filter) throws InterruptedException {
        System.out.println(filter);
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,300);");        new SearchResultsPage().department.click();
        BrowserUtils.waitForPageToLoad(5);
        new SearchResultsPage().department.click();
        new SearchResultsPage().department.click();
        new SearchResultsPage().department.click();


    }
}

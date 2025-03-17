package uk.gov.service.civilservicejobs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.gov.service.civilservicejobs.utilities.Driver;

import static uk.gov.service.civilservicejobs.utilities.Commons.safeClick;

public class CivilServiceJobSearchPage {
    public CivilServiceJobSearchPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "accept_all_cookies_button")
    public WebElement acceptAllCookiesButton;

    @FindBy(id = "what")
    public WebElement what;

    @FindBy(id = "whereselector")
    public WebElement where;

    @FindBy(id = "submitSearch")
    public WebElement submitSearch;

    @FindBy(xpath = "//a[contains(@href, 'civil-service-careers.gov.uk') and @rel='external' and @target='_blank']")
    public WebElement careersAvailableInTheCivilService;

    public void acceptAllCookies() {
        safeClick(acceptAllCookiesButton);
    }
}

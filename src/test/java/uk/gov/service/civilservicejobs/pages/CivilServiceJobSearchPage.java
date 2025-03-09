package uk.gov.service.civilservicejobs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.gov.service.civilservicejobs.utilities.Driver;

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

    public void acceptAllCookies() {
        acceptAllCookiesButton.click();
    }
}

package uk.gov.service.civilservicejobs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.gov.service.civilservicejobs.utilities.Driver;

public class CivilServiceCareersPage {
    public CivilServiceCareersPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Working for the Civil Service')]")
    public WebElement workingForTheCivilService;
}

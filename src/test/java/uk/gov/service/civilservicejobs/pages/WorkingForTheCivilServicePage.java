package uk.gov.service.civilservicejobs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.gov.service.civilservicejobs.utilities.Driver;

public class WorkingForTheCivilServicePage {
    public WorkingForTheCivilServicePage() {
    PageFactory.initElements(Driver.get(), this);
}

    @FindBy(xpath = "//a[contains(@href, 'civilservicecommission.independent.gov.uk/code/the-code/')]")
    public WebElement civilServiceCode;
}

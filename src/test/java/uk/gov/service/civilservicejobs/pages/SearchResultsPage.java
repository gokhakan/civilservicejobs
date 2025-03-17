package uk.gov.service.civilservicejobs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.gov.service.civilservicejobs.utilities.Driver;

public class SearchResultsPage {
    public SearchResultsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id = "id_common_page_title_h1")
    public WebElement resultsTitle;

    @FindBy(xpath = "//button[contains(text(), 'Department')]")
    public WebElement department;

    @FindBy(xpath = "//button[contains(text(), 'Department')]//following::input")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@aria-label='Medicines and Healthcare Products Regulatory Agency']")
    public WebElement medicines;

    @FindBy(xpath = "//input[@name='update_button']")
    public WebElement updateResult;
}

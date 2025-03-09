package uk.gov.service.civilservicejobs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.gov.service.civilservicejobs.utilities.BrowserUtils;
import uk.gov.service.civilservicejobs.utilities.Driver;

public class QuickCheckNeededPage {
    public QuickCheckNeededPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "altcha_checkbox")
    public WebElement altchaCheckbox;


    @FindBy(xpath = "//*[@id=\"captcha-form\"]/button")
    public WebElement Continue;

    public void clickAndContinueCaptcha() throws InterruptedException {
        altchaCheckbox.click();
        BrowserUtils.waitFor(5);
        Continue.click();
    }

}

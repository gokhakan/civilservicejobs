package uk.gov.service.civilservicejobs.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons {
    private static final WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public static void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) Driver.get())
                    .executeScript("arguments[0].click();", element);
        }
    }

    public static void safeSendKeys(WebElement element, String keysToSend) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(keysToSend);
    }
}

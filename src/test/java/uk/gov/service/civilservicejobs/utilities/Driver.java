package uk.gov.service.civilservicejobs.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            // Get browser type from properties file
            String browser = ConfigurationReader.get("browser").toLowerCase();

            // Check if headless mode is enabled via Maven parameter (-Dheadless=true)
            boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

            switch (browser) {
                case "chrome":
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless || browser.equals("chrome-headless")) {
                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless || browser.equals("firefox-headless")) {
                        firefoxOptions.setHeadless(true);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    throw new WebDriverException("Invalid browser: " + browser);
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

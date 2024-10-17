package org.harender.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            // Automatically manage ChromeDriver binary
            WebDriverManager.chromedriver().setup();

            // Set ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Start maximized
            options.addArguments("--disable-infobars"); // Disable infobars
            // Uncomment to run in headless mode
            // options.addArguments("--headless");
            // Opens the browser in incognito mode.
            // options.addArguments("--incognito");
            // Disables GPU hardware acceleration (often used in headless mode).
            // options.addArguments("--disable-gpu");

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

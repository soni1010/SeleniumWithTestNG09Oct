package org.harender.pages;

import org.harender.utils.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;


public class GooglePage {

    private WebDriver driver;
    private static final Logger logger = LoggerUtils.getLogger(GooglePage.class);

    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query) throws InterruptedException {
        logger.info("Searching for: {}", query);
        driver.findElement(searchBox).sendKeys(query);
        Thread.sleep(5000);
        driver.findElement(searchButton).click();
        logger.info("Search performed for: {}", query);
        Thread.sleep(5000);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Page title is: {}", title);
        return title;
    }

}

package org.harender.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.harender.pages.GooglePage;
import org.harender.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class GoogleSearchTest {

    private ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver;
    private GooglePage googlePage;

    @BeforeClass
    public void setUp() {
        // Set up ExtentReports with Spark Reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        // Set up WebDriver
        driver = DriverManager.getDriver();
        googlePage = new GooglePage(driver);
        driver.get("https://www.google.com");
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        test = extent.createTest("Selenium Search on Google Test");
        test.info("Navigating to Google");

        googlePage.searchFor("Selenium");
        String title = googlePage.getPageTitle();
        //System.out.println("Title is > "+title);
        assert title.contains("Selenium") : "Title does not contain 'Selenium'";

        test.pass("Selenium Search on Google is successful !");
    }
    @Test
    public void testGoogleSearch1() throws InterruptedException {
        test = extent.createTest("Java Search on Google Test");
        test.info("Navigating to Google");

        driver.get("https://www.google.com");
        googlePage.searchFor("Java");
        String title = googlePage.getPageTitle();
        //System.out.println("Title is > "+title);
        assert title.contains("Java") : "Title does not contain 'Java'";

        test.pass("Java Search on Google is successful !");
    }

    @Test
    public void testGoogleSearch2() throws InterruptedException {
        test = extent.createTest("New Shree Hari Jewellers Charkhi Dadri Haryana Search on Google Test");
        test.info("Navigating to Google");

        driver.get("https://www.google.com");
        googlePage.searchFor("New Shree Hari jewellers Charkhi Dadri Haryana");
        String title = googlePage.getPageTitle();
        //System.out.println("Title is > "+title);
        assert title.contains("Java") : "Title does not contain 'New Shree Hari jewellers Charkhi Dadri Haryana'";

        test.pass("'New Shree Hari jewellers Charkhi Dadri Haryana' Search on Google is successful !");
    }


    @AfterClass
    public void tearDown() {
        // Flush the reports
        extent.flush();
        DriverManager.quitDriver();
    }
}

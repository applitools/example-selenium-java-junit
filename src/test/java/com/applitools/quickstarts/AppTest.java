package com.applitools.quickstarts;

import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void VGTest()
    {
        // Create a new webdriver
        WebDriver webDriver = new ChromeDriver();

        // Navigate to the url we want to test
        webDriver.get("https://demo.applitools.com");

        // ⭐️ Note to see visual bugs, run the test using the above URL for the 1st run.
        //but then change the above URL to https://demo.applitools.com/index_v2.html (for the 2nd run)

        // Create a runner with concurrency of 10
        VisualGridRunner runner = new VisualGridRunner(10);

        // Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
        Eyes eyes = new Eyes(runner);

        // Get current Eyes configuration object
        Configuration conf = eyes.getConfiguration();


        //conf.setApiKey("APPLITOOLS_API_KEY");    // Set the Applitools API KEY here or as an environment variable "APPLITOOLS_API_KEY"
        conf.setTestName("Java VisualGrid demo")   // Set test name
            .setAppName("Demo app");               // Set app name

        // Add browsers with different viewports
        conf.addBrowser(800, 600, BrowserType.CHROME);
        conf.addBrowser(700, 500, BrowserType.FIREFOX);
        conf.addBrowser(1200, 800, BrowserType.IE_10);
        conf.addBrowser(1600, 1200, BrowserType.IE_11);
        conf.addBrowser(1024, 768, BrowserType.EDGE);
        conf.addBrowser(800, 600, BrowserType.SAFARI);

        // Add iPhone 4 device emulation in Portrait mode
        conf.addDeviceEmulation(DeviceName.iPhone_4, ScreenOrientation.PORTRAIT);


        // Set the configuration object to eyes
        eyes.setConfiguration(conf);

        try
        {
            // Call Open on eyes to initialize a test session
            eyes.open(webDriver);

            // check the login page
            eyes.check(Target.window().fully().withName("Login page"));
            webDriver.findElement(By.id("log-in")).click();

            // Check the app page
            eyes.check(Target.window().fully().withName("App page"));

            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();
        }
        finally
        {
            // Close the browser
            webDriver.quit();
        }

        // Wait and collect all test results
        TestResultsSummary allTestResults = runner.getAllTestResults();
        System.out.println(allTestResults);
    }

}

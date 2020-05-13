package com.applitools.quickstarts;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private WebDriver webDriver;
	private VisualGridRunner runner;
	private Eyes eyes;

	@Test
	public void ultraFastTest() {
		// ⭐️ Note to see visual bugs, run the test using the above URL for the 1st run.
		// but then change the above URL to https://demo.applitools.com/index_v2.html
		// (for the 2nd run)
		// Navigate to the url we want to test
		webDriver.get("https://demo.applitools.com");

		// Call Open on eyes to initialize a test session
		eyes.open(webDriver, "Demo App", "Ultrafast grid demo");//, new RectangleSize(800, 600));

		// check the login page with fluent api, see more info here
		// https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
		eyes.check(Target.window().fully().withName("Login page"));

		webDriver.findElement(By.id("log-in")).click();

		// Check the app page
		eyes.check(Target.window().fully().withName("App page"));

		// Call Close on eyes to let the server know it should display the results
		eyes.closeAsync();
	}

	@BeforeMethod
	public void beforeEach () {
		// Create a new chrome web driver
		webDriver = new ChromeDriver();

		// Create a runner with concurrency of 1
		runner = new VisualGridRunner(1);

		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		eyes = new Eyes(runner);

		setUp();
	}
	
	@AfterMethod
	public void after() {

		// Close the browser
		webDriver.quit();

		// we pass false to this method to suppress the exception that is thrown if we
		// find visual differences
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		// Print results
		System.out.println(allTestResults);

		// If the test was aborted before eyes.close was called, ends the test as aborted.
		eyes.abortIfNotClosed();
	}

	private void setUp() {
		// Initialize eyes Configuration
		Configuration config = new Configuration();

		// You can get your api key from the Applitools dashboard
		config.setApiKey("APPLITOOLS_API_KEY");

		// create a new batch info instance and set it to the configuration
		config.setBatch(new BatchInfo("Ultrafast Batch"));

		// Add browsers with different viewports
		config.addBrowser(800, 600, BrowserType.CHROME);
		config.addBrowser(700, 500, BrowserType.FIREFOX);
		config.addBrowser(1600, 1200, BrowserType.IE_11);
		config.addBrowser(1024, 768, BrowserType.EDGE);
		config.addBrowser(800, 600, BrowserType.SAFARI);

		// Add mobile emulation devices in Portrait mode
		config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
		config.addDeviceEmulation(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT);

		// Set the configuration object to eyes
		eyes.setConfiguration(config);
	}
}

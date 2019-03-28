package com.applitools.quickstarts;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.config.SeleniumConfiguration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgridclient.model.EmulationDevice;
import com.applitools.eyes.visualgridclient.model.EmulationInfo;
import com.applitools.eyes.visualgridclient.model.ScreenOrientation;
import com.applitools.eyes.visualgridclient.model.TestResultSummary;
import com.applitools.eyes.visualgridclient.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualGridDemo {

	public static void main(String[] args) {
		VisualGridDemo program = new VisualGridDemo();
		program.run();
	}

	private void run() {
		// Create a new Webdriver
		WebDriver webDriver = new ChromeDriver();

		// Navigate to the URL we want to test
		webDriver.get("https://demo.applitools.com");
		
		
		//To see visual bugs, change the above URL to:
		//  https://demo.applitools.com/index_v2.html and run the test again
		

		// Create a runner with concurrency of 10
		VisualGridRunner runner = new VisualGridRunner(10);

		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		Eyes eyes = new Eyes(runner);

		// Set API key
		eyes.setApiKey("APPLITOOLS_API_KEY");

		// Create SeleniumConfiguration.
		SeleniumConfiguration sconf = new SeleniumConfiguration();

		// Set the AUT name
		sconf.setAppName("Bank App");

		// Set a test name
		sconf.setTestName("Smoke Test via Visual Grid");

		// Set a batch name so all the different browser and mobile combinations are
		// part of the same batch
		sconf.setBatch(new BatchInfo("VIP Browser combo batch"));

		// Add Chrome browsers with different Viewports
		sconf.addBrowser(800, 600, SeleniumConfiguration.BrowserType.CHROME);
		sconf.addBrowser(700, 500, SeleniumConfiguration.BrowserType.CHROME);

		// Add Firefox browser with different Viewports
		sconf.addBrowser(1200, 800, SeleniumConfiguration.BrowserType.CHROME);
		sconf.addBrowser(1600, 1200, SeleniumConfiguration.BrowserType.CHROME);

		// Add iPhone 4 device emulation
		EmulationInfo iphone4 = new EmulationInfo(EmulationInfo.DeviceName.IPHONE4, ScreenOrientation.PORTRAIT);
		sconf.addDeviceEmulation(iphone4);

		// Add custom mobile device emulation
		EmulationDevice customMobile = new EmulationDevice(1024, 768, 2, true, ScreenOrientation.LANDSCAPE);
		sconf.addDeviceEmulation(customMobile);

		// Set the configuration object to eyes
		eyes.setConfiguration(sconf);

		// Call Open on eyes to initialize a test session
		eyes.open(webDriver);

		// Check the Login page
		eyes.check(Target.window().fully().withName("Step 1 - Login page"));

		//Click on the Login button to go to the App's main page
		webDriver.findElement(By.id("log-in")).click();

		// Check the App page
		eyes.check(Target.window().fully().withName("Step 2 - App Page"));

		// Close the browser
		webDriver.quit();

		System.out.println(
				"Please wait... we are now: \n1. Uploading resources, \n2. Rendering in Visual Grid, and \n3. Using Applitools AI to validate the checkpoints. \nIt'll take about 30 secs to a minute...");
		TestResultSummary allTestResults = runner.getAllTestResults();
		System.out.println(allTestResults);

		// End main test
		System.exit(0);

	}
}
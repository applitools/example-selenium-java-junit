package com.applitools.quickstarts;

import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;

public class VisualGridDemo {

	public static void main(String[] args) {
		VisualGridDemo program = new VisualGridDemo();
		program.runTest();
	}
	
	public static Eyes initializeEyes(VisualGridRunner runner) {
		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		Eyes eyes = new Eyes(runner);

		// Set API key
		eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
		
		//If dedicated or on-prem cloud, uncomment and enter the cloud url
		//Default: https://eyes.applitools.com
		//eyes.setServerUrl("https://testeyes.applitools.com"); 


		// Create SeleniumConfiguration.
		Configuration sconf = new Configuration();

		// Set the AUT name
		sconf.setAppName("Bank App");

		// Set a test name
		sconf.setTestName("Smoke Test via Visual Grid");

		// Set a batch name so all the different browser and mobile combinations are
		// part of the same batch
		sconf.setBatch(new BatchInfo("VIP Browser combo batch"));

		// Add Chrome browsers with different Viewports
		sconf.addBrowser(800, 600, BrowserType.CHROME);
		sconf.addBrowser(700, 500, BrowserType.CHROME);

		// Add Firefox browser with different Viewports
		sconf.addBrowser(1200, 800, BrowserType.FIREFOX);
		sconf.addBrowser(1600, 1200, BrowserType.FIREFOX);

		// Add iPhone 4 device emulation
		sconf.addDeviceEmulation(DeviceName.iPhone_4);

		// Set the configuration object to eyes
		eyes.setConfiguration(sconf);
		
		return eyes;
	}

	private void runTest() {

		// Create a runner with concurrency of 10
		VisualGridRunner runner = new VisualGridRunner(10);

		//Initialize Eyes with Visual Grid Runner
		Eyes eyes = initializeEyes(runner);
		
		// Create a new Webdriver
		WebDriver webDriver = new ChromeDriver();

		// Navigate to the URL we want to test
		webDriver.get("https://demo.applitools.com");

		// To see visual bugs, change the above URL to:
		// https://demo.applitools.com/index_v2.html and run the test again


		// Call Open on eyes to initialize a test session
		eyes.open(webDriver);

		// Check the Login page
		eyes.check(Target.window().fully().withName("Step 1 - Login page"));

		// Click on the Login button to go to the App's main page
		webDriver.findElement(By.id("log-in")).click();

		// Check the App page
		eyes.check(Target.window().fully().withName("Step 2 - App Page"));

		// Close the browser
		webDriver.quit();

		System.out.println(
				"Please wait... we are now: \n1. Uploading resources, \n2. Rendering in Visual Grid, and \n3. Using Applitools A.I. to validate the checkpoints. \nIt'll take about 30 secs to a minute...");

		// Close eyes asynchronously
		eyes.close();
		TestResultsSummary allTestResults = runner.getAllTestResults();
		System.out.println(allTestResults);

	}
}

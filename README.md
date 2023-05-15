# Applitools Example: Selenium in Java with JUnit

This is the example project for the [Selenium Java JUnit tutorial](https://applitools.com/tutorials/quickstart/web/selenium/java/junit).
It shows how to start automating visual tests
with [Applitools Eyes](https://applitools.com/platform/eyes/)
and [Selenium WebDriver](https://www.selenium.dev/) in Java.

It uses:

* [Java](https://www.java.com/) as the programming language
* [Selenium WebDriver](https://www.selenium.dev/) for browser automation
* [Google Chrome](https://www.google.com/chrome/downloads/) as the local browser for testing
* [Apache Maven](https://maven.apache.org/index.html) for dependency management
* [JUnit 5](https://junit.org/junit5/) as the core test framework
* [Applitools Eyes](https://applitools.com/platform/eyes/) for visual testing

It can also run tests with:

* [Applitools Ultrafast Grid](https://applitools.com/platform/ultrafast-grid/) for cross-browser execution
* [Applitools Execution Cloud](https://applitools.com/platform/execution-cloud/) for self-healing remote WebDriver sessions

To run this example project, you'll need:

1. An [Applitools account](https://auth.applitools.com/users/register), which you can register for free.
2. The [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/), version 8 or higher.
3. A good Java editor, such as [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/).
4. [Apache Maven](https://maven.apache.org/download.cgi) (typically bundled with IDEs).
5. An up-to-date version of [Google Chrome](https://www.google.com/chrome/downloads/).
6. A corresponding version of [ChromeDriver](https://chromedriver.chromium.org/downloads).

The main test case is [`AcmeBankTests.java`](src/test/java/com/applitools/example/AcmeBankTests.java).
By default, the project will run tests with Ultrafast Grid but not Execution Cloud.
You can change these settings in the test class.

To execute tests, set the `APPLITOOLS_API_KEY` environment variable
to your [account's API key](https://applitools.com/tutorials/guides/getting-started/registering-an-account),
and then run:

```
mvn test
```

**For full instructions on running this project, take our
[Selenium Java JUnit tutorial](https://applitools.com/tutorials/quickstart/web/selenium/java/junit)!**

# Pre-requisites:

1. Java is installed on your machine.
   
   * [Install JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
   
2. Maven is installed on your machine, JAVA_HOME environment variable is created, path to Maven is added to environment variable PATH

   * [Download Maven](https://maven.apache.org/download.cgi)

   * [Install Maven, configure enviroment variables](https://maven.apache.org/install.html)

3. Chrome browser is installed on your machine.

   * [Install Chrome browser](https://support.google.com/chrome/answer/95346?co=GENIE.Platform%3DDesktop&hl=en&oco=0)

4. Chrome Webdriver is on your machine and is in the PATH. Here are some resources from the internet that'll help you.

   * [Download Chrome Webdriver](https://chromedriver.chromium.org/downloads)
   * https://splinter.readthedocs.io/en/0.1/setup-chrome.html
   * https://stackoverflow.com/questions/38081021/using-selenium-on-mac-chrome
   * https://www.youtube.com/watch?time_continue=182&v=dz59GsdvUF8

5. Git is installed on your machine. 

   * [Install git](https://www.atlassian.com/git/tutorials/install-git)

6. IDE (IntelliJ IDEA for example) is installed on your machine.

   * [Install IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

     6.1 Set Project SDK to your JDK (installed in Step 1)  in Intellij - File > Project Structure > Project.

7. Restart your machine to implement updated  environment variables (need for some OS).

   

# Steps to run this example

1. Git clone this repo 
   
   * `git clone https://github.com/applitools/tutorial-selenium-java-ultrafastgrid.git`, or download [this as a Zip file](https://github.com/applitools/tutorial-selenium-java-ultrafastgrid/archive/master.zip) and unzip it
2. Get an API key by logging into Applitools > Person Icon > My API Key
3. Navigate to just cloned folder tutorial-selenium-java-basic. 
5. Import the project as a *Maven* project in IntelliJ IDEA.
6. Navigate to AppTest class - src\test\java\com\applitools\quickstarts\AppTest in IntelliJ IDEA.
6. In IntelliJ IDEA or in any editor update file src\test\java\com\applitools\quickstarts\AppTest.java  and set your ApiKey in string 'config.setApiKey("...")' (or comment the string and set APPLITOOLS_API_KEY environment variable)
7. Run class AppTest from IntelliJ IDEA - tap Run, choose 'AppTest'.

Read more here: https://www.applitools.com/tutorials/selenium-java.html 

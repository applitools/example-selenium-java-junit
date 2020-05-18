# Pre-requisites:

1. Java is installed on your machine.
   
   * [Install JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
   
2. Maven is installed on your machine, JAVA_HOME environment variable is created, added to PATH, path to Maven is added to PATH too

   * [Install Maven, configure enviroment variables](https://maven.apache.org/install.html)

3. Chrome Webdriver is on your machine and is in the PATH. Here are some resources from the internet that'll help you.

   * https://splinter.readthedocs.io/en/0.1/setup-chrome.html
   * https://stackoverflow.com/questions/38081021/using-selenium-on-mac-chrome
   * https://www.youtube.com/watch?time_continue=182&v=dz59GsdvUF8

4. IntelliJ IDEA (or Eclipse) is installed on your machine if you want to run example from IDE.

   * [Install IntelliJ IDEA](https://www.jetbrains.com/idea/download/)  or [Install Eclipse](https://www.eclipse.org/downloads/)

     

# Steps to run this example

1. Git clone this repo 
   
   * `git clone https://github.com/applitools/tutorial-selenium-java-ultrafastgrid.git`, or download [this as a Zip file](https://github.com/applitools/tutorial-selenium-java-ultrafastgrid/archive/master.zip) and unzip it
   
2. Navigate to just cloned folder tutorial-selenium-java-basic.

3. Get an API key by logging into Applitools > Person Icon > My API Key

4. Open in any editor file src\test\java\com\applitools\quickstarts\AppTest.java  and set your ApiKey in string 'config.setApiKey("...")' (or comment the string and set APPLITOOLS_API_KEY environment variable) 

5. Run 'mvn -Dtest=AppTest test'.

6. If you want to run example from IDE perform next steps:

   6.1. Import the project as a *Maven* project in IntelliJ IDEA or Eclipse.

   6.2 Set Project SDK to your JDK (installed in Pre-requisites)  in Intellij - File > Project Structure > Project.

   6.3 Run or Debug class AppTest or method test().

   

Read more here: https://www.applitools.com/tutorials/selenium-java.html


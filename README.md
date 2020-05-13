# Pre-requisites:

1. Java, Maven, IntelliJ IDEA (or Eclipse) installed on your machine.
   * [Install JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
   * [Install Maven](https://maven.apache.org/install.html)
   * [Install IntelliJ IDEA](https://www.jetbrains.com/idea/download/)  or [Install Eclipse](https://www.eclipse.org/downloads/)
2. Chrome Webdriver is on your machine and is in the PATH. Here are some resources from the internet that'll help you.
   * https://splinter.readthedocs.io/en/0.1/setup-chrome.html
   * https://stackoverflow.com/questions/38081021/using-selenium-on-mac-chrome
   * https://www.youtube.com/watch?time_continue=182&v=dz59GsdvUF8

# Steps to run this example

1. Git clone this repo 

`git clone https://github.com/applitools/tutorial-selenium-java-ultrafastgrid.git`

2. Import the project as a *Maven* project in Eclipse or IntelliJ.
3. Set your API key in the _APPLITOOLS_API_KEY_ env variable. Get an API key by logging into Applitools > Person Icon > My API Key
4. Run 'mvn -Dtest=AppTest test' or click the 'Run' button in Eclipse/IntelliJ

Read more here: https://www.applitools.com/tutorials/selenium-java.html
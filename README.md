## Maven
1. Download apache maven 3.2.2. http://maven.apache.org/download.cgi
2. Install instructions http://maven.apache.org/download.cgi#Installation

## Eclipse
1. Eclipse versions Juno & Kepler now support maven. If older version is desired, install m2eclipse http://download.eclipse.org/technology/m2e/releases
2. Install TestNG plugin. http://testng.org/doc/download.html

## Chrome driver
1. Chrome driver has to be installed on the machine, to be able to test using selenium web driver.
2. Download latest version 2.10 from the following link
http://chromedriver.storage.googleapis.com/index.html?path=2.10/
3. Configure path to chromedriver executable in src/test/resources/config.properties
```
chromedriver.path=/home/reshma/software/chromedriver
```
## Selenium
1. No special setup required. maven will download necessary dependencies.
2. Selenium web driver quick reference wiki. http://docs.seleniumhq.org/docs/03_webdriver.jsp


## Xero web tests project setup
1. Clone this repository
2. Import project as existing maven project
```
From the main menu, Choose File > Import..
Select Maven> Existing Maven Projects
   If you don't see maven option. Please verify if m2eclipse is installed properly
Select Root directory to local clone of xero (eg: /home/reshma/gitrepos/xero)
Click finish , after eclipse lists project 
```
## Executing tests
1. Right click on test class and run as testng test.
2. Generating surefire report: Right click pom.xml, choose build.., type target "surefire-report:report" and run.
3. Report will be available @ "target/site/surefire-report.html"

## Configuration

Following are some configurable aspects of the web tests in file src/test/resources/config.properties

```
browser=chrome   [supported options chrome,firefox]
chromedriver.path=/home/reshma/software/chromedriver
```

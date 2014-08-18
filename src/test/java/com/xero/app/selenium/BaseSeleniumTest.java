/**
 * 
 */
package com.xero.app.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.xero.app.selenium.utils.ConfigReader;

/**
 * @author Reshma
 *
 */
public class BaseSeleniumTest {

	public String path;
	protected WebDriver driver;
	protected ConfigReader config = ConfigReader.getInstance();

	@BeforeClass
	public void preSetup() {
		// Code to login and navigate to repeating invoice page
		path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				config.get("chromedriver.path", "./chromedriver/chromedriver.exe"));
		String browser = config.get("browser", "chrome");
		if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}else{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://login.xero.com//");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(
				"reshma.malemarpuram@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(
				"xeroapp12");
		driver.findElement(By.xpath("//*[@id='submitButton']")).click();
	}

	@AfterClass
	public void postTeardown() {

		// code to logout and close the browser
		driver.findElement(
				By.xpath("//*[@id='xero-nav']/div[2]/div[1]/div[2]/a")).click();
		driver.findElement(
				By.xpath("//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a"))
				.click();
		driver.close();
	}

}

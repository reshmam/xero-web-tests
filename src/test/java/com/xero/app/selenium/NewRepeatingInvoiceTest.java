package com.xero.app.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewRepeatingInvoiceTest extends BaseSeleniumTest {

	@BeforeClass
	public void setup() {

		driver.findElement(By.xpath("//*[@id='Accounts']")).click();
		driver.findElement(
				By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a"))
				.click();
		driver.findElement(By.xpath("//*[@id='Accounts']")).click();
		driver.findElement(By.xpath("//*[@id='ext-gen1037']/span")).click();
		driver.findElement(By.xpath("//*[@id='ext-gen1036']/li[2]/a/b"))
				.click();

	}

	@Test
	void testCreateNewRepeatingInvoice() {

		// code to create a new repeating invoice by giving all valid inputs

		driver.findElement(By.xpath("//*[@id='PeriodUnit']")).sendKeys("4");
		driver.findElement(By.xpath("//*[@id='TimeUnit_toggle']")).click();
		driver.findElement(
				By.xpath("//*[@id='TimeUnit_suggestions']/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='ext-gen41']")).click();
		driver.findElement(By.linkText("25")).click();
		driver.findElement(By.xpath("//*[@id='DueDateDay']")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id='DueDateType_toggle']")).click();
		driver.findElement(
				By.xpath("//*[@id='DueDateType_suggestions']/div/div[2]"))
				.click();
		driver.findElement(By.xpath(" //*[@id='saveAsDraft']")).click();
		driver.findElement(
				By.xpath("html/body/form/div[2]/div[2]/div/div[2]/div[3]/div/div/div[1]/div[1]/div/input[2]"))
				.sendKeys("ABCltd");
		driver.findElement(
				By.xpath("html/body/form/div[2]/div[2]/div/div[2]/div[3]/div/div/div[1]/div[2]/div/input"))
				.sendKeys("1234");
		Actions action = new Actions(driver);
		action.doubleClick(
				driver.findElement(By
						.xpath("//*[@id='ext-gen19']/div[1]/table/tbody/tr/td[2]/div")))
				.perform();
		driver.findElement(
				By.xpath("html/body/form/div[2]/div[2]/div/div[2]/div[3]/div/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[2]/div/img"))
				.click();
		driver.findElement(By.xpath("html/body/div[8]/div/div[5]")).click();
		action.doubleClick(
				driver.findElement(By
						.xpath("//*[@id='ext-gen19']/div[2]/table/tbody/tr/td[2]/div")))
				.perform();
		driver.findElement(
				By.xpath("html/body/form/div[2]/div[2]/div/div[2]/div[3]/div/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[2]/div/img"))
				.click();
		driver.findElement(By.xpath("html/body/div[8]/div/div[6]")).click();
		driver.findElement(
				By.xpath("html/body/form/div[2]/div[2]/div/div[3]/div/span[1]/button"))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

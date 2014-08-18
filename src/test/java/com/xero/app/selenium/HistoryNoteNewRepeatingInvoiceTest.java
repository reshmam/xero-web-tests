package com.xero.app.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HistoryNoteNewRepeatingInvoiceTest extends BaseSeleniumTest {

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

	/**
	 * Code to check are we able to enter history note and save it.
	 */
	@Test
	void testHistoryNote() {

		driver.findElement(By.xpath("//*[@id='historyright']")).click();
		driver.findElement(By.xpath("//*[@id='HistoryNote']")).sendKeys(
				"Able to enter history note");
		driver.findElement(By.xpath("//*[@id='HistorySaveLink']")).click();
	}

}

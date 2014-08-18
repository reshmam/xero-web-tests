package com.xero.app.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchInvoiceInvalidInputsTest extends BaseSeleniumTest {

	@BeforeClass
	public void setup() {
		driver.findElement(By.xpath("//*[@id='Accounts']")).click();
		driver.findElement(
				By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a"))
				.click();
		driver.findElement(By.linkText("Repeating")).click();

	}

	/**
	 * checks the search by invalid Contact name
	 */
	@Test
	public void testSearchInvalidInputs() {
		driver.findElement(By.xpath("//*[@id='ext-gen47']/span")).click();

		driver.findElement(By.xpath("//*[@id='sb_txtReference']")).sendKeys(
				"bmw");
		driver.findElement(By.xpath("//*[@id='sbSubmit_']")).click();

		String str = driver
				.findElement(By.xpath("//*[@id='ext-gen40']/div[6]")).getText();
		Assert.assertEquals("There are no items to display.", str);
		// code to search by reference
		driver.findElement(By.xpath("//*[@id='sb_txtReference']")).clear();
		driver.findElement(By.xpath("//*[@id='sb_txtReference']")).sendKeys(
				"3333");
		driver.findElement(By.xpath("//*[@id='sbSubmit_']")).click();

		str = driver.findElement(By.xpath("//*[@id='ext-gen40']/div[6]"))
				.getText();
		Assert.assertEquals("There are no items to display.", str);
	}

}

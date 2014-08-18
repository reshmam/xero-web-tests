package com.xero.app.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchInvoiceTest extends BaseSeleniumTest {

	@BeforeClass
	public void setup() {

		driver.findElement(By.xpath("//*[@id='Accounts']")).click();
		driver.findElement(
				By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a"))
				.click();
		driver.findElement(By.linkText("Repeating")).click();

	}

	@Test
	void testSearchInvoice() {
		driver.findElement(By.xpath("//*[@id='ext-gen47']/span")).click();

		// code to verify the search by Contact name

		driver.findElement(By.xpath("//*[@id='sb_txtReference']")).sendKeys(
				"ABCltd");
		driver.findElement(By.xpath("//*[@id='sbSubmit_']")).click();

		WebElement table = driver.findElement(By.id("ext-gen48"));
		int i = 0;
		for (WebElement rowElmt : table.findElements(By.tagName("tr"))) {
			List<WebElement> cols = rowElmt.findElements(By.tagName("td"));
			if (i > 0)
				Assert.assertEquals("ABCltd", cols.get(1).getText());
			i = 1;
		}

		// code to search by reference
		/*
		 * driver.findElement(By.xpath("//*[@id='sb_txtReference']")).clear();
		 * driver
		 * .findElement(By.xpath("//*[@id='sb_txtReference']")).sendKeys("1234"
		 * ); driver.findElement(By.xpath("//*[@id='sbSubmit_']")).click();
		 * 
		 * table = driver.findElement(By.id("ext-gen48")); i=0; for (WebElement
		 * rowElmt : table.findElements(By.tagName("tr"))) { List<WebElement>
		 * cols = rowElmt.findElements(By.tagName("td")); if(i>0)
		 * Assert.assertEquals("1234",cols.get(2).getText()); i=1; }
		 */

	}

}

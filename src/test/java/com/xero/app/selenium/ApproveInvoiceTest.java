package com.xero.app.selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApproveInvoiceTest extends BaseSeleniumTest {

	 
   /**
    * 
    */
	@BeforeClass
   	 public void setup()  {
	 
			driver.findElement(By.xpath("//*[@id='Accounts']")).click();
			driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a")).click();
			driver.findElement(By.linkText("Repeating")).click();
			
		}
	 
   /**
    *  Approve Invoice Test
    */
	@Test
	 void testApproveInvoice(){
    	
		WebElement table = driver.findElement(By.id("ext-gen48"));
		int i=0;
		for (WebElement rowElmt : table.findElements(By.tagName("tr")))
		{    
		    List<WebElement> cols = rowElmt.findElements(By.tagName("td"));
		  if(i>0)
		  {		 
		  	  if(cols.get(1).getText().equals("ABCltd"))
		  	  {
		  		  cols.get(0).click();
		  		  
		  	  }
     		} i=i+1;
		 }
		 driver.findElement(By.xpath("//*[@id='ext-gen41']")).click();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 String currentWindowId = driver.getWindowHandle();
         //retrive all windows id
         Set<String> allWindows = driver.getWindowHandles();
         //switch all windows on by one
             for (String windowId : allWindows) {
                  driver.switchTo().window(windowId);
                   
                   try {
                        driver.findElement(By.xpath("//*[@id='create02']")).click();
                       }
                   catch(Exception ex){}
                 //switch to parent window again
                   
                 driver.switchTo().window(currentWindowId);
             }
       
		
       		table = driver.findElement(By.id("ext-gen48"));
		for (WebElement rowElmt : table.findElements(By.tagName("tr")))
		{    
		    List<WebElement> cols = rowElmt.findElements(By.tagName("td"));
		  if(i>0)
		  {		 
		  	  if(cols.get(1).getText().equals("ABCltd"))
		  	  {
		  		Assert.assertEquals(cols.get(8).getText(),"Approved  ");
		  	  }
     		} i=i+1;
		 }
		
	}
      
}


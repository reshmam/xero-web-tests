package com.xero.app.selenium;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvoiceDateNewRepeatingInvoiceTest extends BaseSeleniumTest {
    
    @BeforeClass
   	 public  void setup()  {
		 
		 	driver.findElement(By.xpath("//*[@id='Accounts']")).click();
			driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='Accounts']")).click();
			driver.findElement(By.xpath("//*[@id='ext-gen1037']/span")).click();
			driver.findElement(By.xpath("//*[@id='ext-gen1036']/li[2]/a/b")).click();
    }
	 
    /**
     * checks while creating new repeating invoice by giving invoice date that has already occurred
		  will pop a window saying "Next Invoice Date has occurred"
     */
    @Test
	 void testNextInvoiceDate(){

		driver.findElement(By.xpath("//*[@id='PeriodUnit']")).sendKeys("4");
		driver.findElement(By.xpath("//*[@id='TimeUnit_toggle']")).click();		
		driver.findElement(By.xpath("//*[@id='TimeUnit_suggestions']/div/div[1]")).click(); 
		driver.findElement(By.xpath("//*[@id='ext-gen41']")).click();	
		driver.findElement(By.linkText("10")).click();
		String currentWindowId = driver.getWindowHandle();
        //retrive all windows id
        Set<String> allWindows = driver.getWindowHandles();
        //switch all windows on by one
            for (String windowId : allWindows) {
                 driver.switchTo().window(windowId);
                  String text = "";
                  try {
                        text = driver.findElement(By.xpath("//*[@id='ext-gen72']")).getText();
                      }
                  catch(Exception ex){}
                  //check if you get text
                  if(text.equals("Next Invoice Date has occurred")){                
                          	   System.out.println("found text"); 
                          	   driver.findElement(By.xpath("//*[@id='ext-gen75']")).click();
                               break;
                              }
                             //switch to parent window again
                            driver.switchTo().window(currentWindowId);
            }
	  }
	  
	

}

package com.xero.app.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelpinNewRepeatingInvoiceTest extends BaseSeleniumTest {
	 
 	 @BeforeClass
    public  void setup()  {
 		 
			driver.findElement(By.xpath("//*[@id='Accounts']")).click();
			driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='Accounts']")).click();
			driver.findElement(By.xpath("//*[@id='ext-gen1037']/span")).click();
			driver.findElement(By.xpath("//*[@id='ext-gen1036']/li[2]/a/b")).click();
		
		}
	  @Test
	 void checkWhatsthis(){
		  
		  //Code to check are we able to get help by clicking on "what's This?"in Creating new repeating invoice page.
		  driver.findElement(By.xpath("//*[@id='OG_Glossary_RepeatingInvCreate']/span")).click();
		  String currentWindowId = driver.getWindowHandle();
          //retrive all windows id
          Set<String> allWindows = driver.getWindowHandles();
          //switch all windows on by one
          
              for (String windowId : allWindows) {
                   driver.switchTo().window(windowId);
                    String text = "";
                    try {
                          text = driver.findElement(By.xpath("//*[@id='ext-gen66']/p")).getText();
                        }
                    catch(Exception ex){}
                    //check if you get text
                    if(text.equals("Repeat Invoice or Bill � Create or Edit")){                
                            	       
                            //close popup
                           // driver.close();
                            break;
                                }
                               //switch to parent window again
                              driver.switchTo().window(currentWindowId);
                    }
 }	
	 	 


}

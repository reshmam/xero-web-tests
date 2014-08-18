package com.xero.app.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApprovewithnoTranSelectedTest extends BaseSeleniumTest {
    
	 
    @BeforeClass
   	 public  void setup()  {
		 
			driver.findElement(By.xpath("//*[@id='Accounts']")).click();
			driver.findElement(By.xpath("//*[@id='xero-nav']/div[2]/div[2]/div/ul/li[2]/ul/li[2]/a")).click();
			driver.findElement(By.linkText("Repeating")).click();
			
		}
	 
    @Test
	 void testApprove() throws InterruptedException{
    	//code to check when tried to approve with no transaction selected
		
    	 driver.findElement(By.xpath("//*[@id='ext-gen41']")).click();
    	Thread.sleep(5000);
		 String currentWindowId = driver.getWindowHandle();
         //retrive all windows id
         Set<String> allWindows = driver.getWindowHandles();
         //switch all windows on by one
       
             for (String windowId : allWindows) {
                  driver.switchTo().window(windowId);
                  String text="";
                  String str= driver.findElement(By.xpath("//*[@id='ext-gen335']")).getText();
              
                  System.out.println(str); 
                  try {
                	  text = driver.findElement(By.xpath("//*[@id='ext-gen335']")).getText();
                       System.out.println(text);          
                  }
                   catch(Exception ex){}
                 //check if you get text
                  if(text.equals("No items selected")){                
                          	   System.out.println("found text"); 
                          	driver.findElement(By.xpath("//*[@id='create02']")).click();
                               break;
                              }
                             //switch to parent window again
                            driver.switchTo().window(currentWindowId);

             }
       
			
	}	      
	    
       
}


package com.crm.generic.webDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	//specify which browser 
	public void waitForPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//specify browser and web element
	public void waitForElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//switch to new Window based on url	
	public void switchToTabOnUrl(WebDriver driver,String partialURL) 
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> i=set.iterator();
		
		while(i.hasNext())
		{
			String window = i.next();
			driver.switchTo().window(window);
			
			@Nullable
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) 
			{
				break;
			}
		}
	}

	//switch to new Window/tab based on Title	
		public void switchToTabOnTitle(WebDriver driver,String partialTitle) 
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> i=set.iterator();
			
			while(i.hasNext())
			{
				String window = i.next();
				driver.switchTo().window(window);
				
				@Nullable
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(partialTitle)) 
				{
					break;
				}
			}
		}
		
	//switch to frame using index
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		
		//switch to frame using name
		public void switchToFrame(WebDriver driver,String nameID)
		{
			driver.switchTo().frame(nameID);
		}
				
		//switch to frame using  webelement
		public void switchToFrame(WebDriver driver,WebElement element)
		{
		  driver.switchTo().frame(element);
		}
		
		//switch to alert	to accept
		public void switchToAlertAndAccept(WebDriver driver) 
		{
			driver.switchTo().alert().accept();
		}
		
		//switch to alert to dismiss	
		public void switchToAlertAndDismiss(WebDriver driver) 
		{
			driver.switchTo().alert().dismiss();
		}
		
		//for drop-down by index
		public void select(WebElement element,int index)
		{
			Select select=new Select(element);
			select.selectByIndex(index);
		}
		//for drop-down by text
		public void select(WebElement element,String text)
		{
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}

		//for mouse actions
		public void mouseMovementOneElement(WebDriver driver,WebElement element) 
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).perform();
		}
		
		//for double click
		public void doubleClick(WebDriver driver,WebElement element) 
		{
			Actions action=new Actions(driver);
			action.doubleClick(element).perform();

		}
}

package com.crm.contactTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Exception {
		//read data from property file
		FileUtility fLib = new FileUtility();
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		//generate Random number
		JavaUtility jLib=new JavaUtility();
		
		
		//read data from excel
		ExcelUtility eLib=new ExcelUtility();
		String LASTNAME=eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNum();
	
		//test script must be able to run in different browser
				WebDriver driver=null;
				if(BROWSER.equals("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equals("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("edge"))
				{
					driver=new EdgeDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}
				
		//Step1: login to App
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step2: navigate to contact module
			driver.findElement(By.linkText("Contacts")).click();
			
			//step3: click on "Create Organization" button
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			//step4: enter last name to create new Organization
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
			//step5: verify last name
			String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
			if (actLastName.equals(LASTNAME)) 
			{
				System.out.println(LASTNAME+" information is verified==pass");
			}
			else
			{
				System.out.println(LASTNAME+" information is not verified==fail");

			}
			driver.quit();
	}

}

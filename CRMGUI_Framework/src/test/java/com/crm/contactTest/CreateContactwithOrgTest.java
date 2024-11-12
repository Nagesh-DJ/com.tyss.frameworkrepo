package com.crm.contactTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;
import com.crm.generic.webDriverUtility.WebDriverUtility;

//its an integration test scenario
public class CreateContactwithOrgTest {

	public static void main(String[] args) throws Exception 
	{
		/* create Object */
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//read common data from Json file
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");

		//generate random num
		String orgName=eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNum();
		String LASTNAME=eLib.getDataFromExcel("contact", 1, 2);
	
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
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step2: navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3: click on "Create Organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step4: enter org name to create new Organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step5: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//step6: click on create Organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//step7: enter last name to create new Organization
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		//switch to child Window
		wLib.switchToTabOnUrl(driver, "module=Accounts");
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch to parent window
		wLib.switchToTabOnUrl(driver, "Contacts&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//step: verify Header phone number info with expected result
				String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (headerInfo.contains(LASTNAME))
				{
					System.out.println(LASTNAME+" header verified ==PASS");
				}
				else
				{
					System.out.println(LASTNAME+" header not verified ==FAIL");

				}
		
		//step: verify Org name with expected Result
		String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) 
		{
			System.out.println(orgName+" information is verified==pass");
		}
		else
		{
			System.out.println(orgName+" information is not verified==fail");

		}
		driver.quit();
	
	}

}

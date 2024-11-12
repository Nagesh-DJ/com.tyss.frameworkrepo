package com.crm.orgTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;
import com.crm.generic.webDriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;
import com.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.crm.objectRepositoryUtility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Exception {
		/* Create Object for utility class */
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//read data from property file
	
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		//generate Random number
	
		
		
		//read data from excel
		
		String OrgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
	
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
		LoginPage lp = new LoginPage(driver);
		
		/*
		 * lp.getUsernameEdit().sendKeys("admin");
		 * lp.getPasswordEdit().sendKeys("admin"); 
		 * lp.getLoginButton().click();
		 */
		
	//using business logic
		lp.LoginToApp(USERNAME, PASSWORD);
		
		//step2: navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		//step3: click on "create organization" button
	     OrganizationsPage op=new OrganizationsPage(driver);
	     op.getCreateNewOrg().click();
	     
		//step4: enter details and create new organization
	     CreatingNewOrganizationPage cNewPage=new CreatingNewOrganizationPage(driver);
	     cNewPage.createNewOrgAndSave(OrgName);
		
		//step5: verify Header msg with expected output
		OrganizationInfoPage orgInfoPage=new OrganizationInfoPage(driver);
		String actOrgName=orgInfoPage.getHeaderMsg().getText();
		if(actOrgName.contains(OrgName))
		{
			System.out.println(OrgName+" name is verified ==PASS");	
		}
		else
		{
			System.out.println(OrgName+" name is not verified ==FAIL");

		}
		
		//go back to organization page
		hp.getOrgLink().click();
		
		//search for organization
		//op.getSearchEdt().sendKeys(OrgName);
		op.getSearchEdt().sendKeys("Nagesh");
		wLib.select(op.getSearchDropDown(), "Organization Name");
		op.getSearchButton().click();
	
		//In dynamic web table select and Delete org
		//to click on delete link
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']/../../td[8]/a[text()='del']")).click();
		
		//to handle alert or pop-up
		driver.switchTo().alert().accept();
				
		//step6:Log-out 
		hp.logOut();
	   	
		driver.quit();
	}
}


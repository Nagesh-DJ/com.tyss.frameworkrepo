package testNG.com.crm.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.generic.dabaseUtility.DataBaseUtility;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;

public class b_BaseClass {
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void configBS() throws SQLException
	{
		System.out.println("===connect to DB,Report config===");
		dLib.getDBConnection();
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void configBC(String browser) throws IOException
	{
		System.out.println("--launch browser--");
		String BROWSER=browser;//taking input from testNG.xml
				//fLib.getDataFromPropertiesFile("browser");
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
		
	} 
	
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
	public void configBM() throws IOException
	{
		System.out.println("login");
		//get data from property file
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);	
		lp.LoginToApp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void configAM()
	{
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		hp.logOut();
	}
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void configAC()
	{
		System.out.println("--close browser--");
		driver.quit();
	}

	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void configAS() throws SQLException
	{
		System.out.println("===close DB,Report back-up===");
		dLib.closeDBConnection();
	}

}

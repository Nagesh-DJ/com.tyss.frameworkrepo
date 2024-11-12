package testNG.com.crm.contactTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;

import testNG.com.crm.baseutility.b_BaseClass;

public class CreateContactTest extends b_BaseClass
{
	@Test(groups = "SmokeTest")
	 public void CreateContactTest() throws Exception {

		// read data from excel
		String LASTNAME = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNum();

		// step2: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// step3: click on "Create Contact" button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// step4: enter last name to create new Organization
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// step5: verify last name
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(actLastName, LASTNAME);
	}
	
	@Test(groups = "RegressionTest")
	public void createContactWithSupportDateTest()
	{
		//complete code here
		System.out.println("executing createContactWithSupportDateTest");
	}
	@Test(groups = "RegressionTest")
	public void createContactWithOrgTest()
	{
		//complete code here
		System.out.println("executing createContactWithOrgTest");
	}
}

/* actually develop like this
 * 
 * // step2: navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on "Create Contact" button
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewOrgBtn().click();
		
		
		// step4: enter last name to create new Contact
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.createContact(LASTNAME);
		
		// step5: verify last name
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(LASTNAME)) {
			System.out.println(LASTNAME + " information is verified==pass");
		} else {
			System.out.println(LASTNAME + " information is not verified==fail");
		}
 */











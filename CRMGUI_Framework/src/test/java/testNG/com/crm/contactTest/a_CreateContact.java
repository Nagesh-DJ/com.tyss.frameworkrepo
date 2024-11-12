package testNG.com.crm.contactTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.objectRepositoryUtility.ContactPage;
import com.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.crm.objectRepositoryUtility.HomePage;

import testNG.com.crm.baseutility.b_BaseClass;

public class a_CreateContact extends b_BaseClass
{

	@Test(groups = "SmokeTest")
	public void CreateContactTest() throws Exception {

		// read data from excel
		String LASTNAME = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNum();

		// step2: navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on "Create Contact" button
			ContactPage cp=new ContactPage(driver);
			cp.getClickCreateNewCntbtn().click();
			
		// step4: enter last name to create new Contact
			CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
			ccp.createConatct(LASTNAME);
			
		// step5: verify last name
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(LASTNAME)) {
			System.out.println(LASTNAME + " information is verified==pass");
		} else {
			System.out.println(LASTNAME + " information is not verified==fail");
		}
	}
}

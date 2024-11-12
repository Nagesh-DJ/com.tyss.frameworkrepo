package testNG.com.crm.orgTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webDriverUtility.JavaUtility;
import com.crm.generic.webDriverUtility.WebDriverUtility;
import com.crm.objectRepositoryUtility.CreatingNewOrganizationPage;
import com.crm.objectRepositoryUtility.HomePage;
import com.crm.objectRepositoryUtility.LoginPage;
import com.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.crm.objectRepositoryUtility.OrganizationsPage;

import testNG.com.crm.baseutility.b_BaseClass;

public class CreateOrganizationTest extends b_BaseClass {
	/*
	 * @Test 
	 * public void createOrgTest() throws Exception {
	 * 
	 * //read data from excel
	 * 
	 * String OrgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
	 * //step2: navigate to organization module HomePage hp=new HomePage(driver);
	 * hp.getOrgLink().click();
	 * 
	 * //step3: click on "create organization" button OrganizationsPage op=new
	 * OrganizationsPage(driver); op.getCreateNewOrg().click();
	 * 
	 * //step4: enter details and create new organization
	 * CreatingNewOrganizationPage cNewPage=new CreatingNewOrganizationPage(driver);
	 * cNewPage.createNewOrgAndSave(OrgName);
	 * 
	 * //step5: verify Header msg with expected output OrganizationInfoPage
	 * OrganizationInfoPage orgInfoPage=new OrganizationInfoPage(driver); String
	 * actOrgName=orgInfoPage.getHeaderMsg().getText();
	 * if(actOrgName.contains(OrgName)) {
	 * System.out.println(OrgName+" name is verified ==PASS"); } else {
	 * System.out.println(OrgName+" name is not verified ==FAIL");
	 * 
	 * } }
	 * 
	 */
	@Test(groups = "SmokeTest")
	public void CreateOrTest() {
		System.out.println("executing CreateOrgTest");
	}

	@Test(groups = "RegressionTest")
	public void createOrgWithPhoneNumberTest() {
		// complete code here
		System.out.println("execute createOrgWithPhoneNumberTest");
	}

	@Test(groups = "RegressionTest")
	public void createOrgWithIndustriesTest() {
		// complete code here
		System.out.println("execute createOrgWithIndustriesTest");
	}

}

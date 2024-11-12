package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement enterOrgName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="c")
	private WebElement industryDropDown;
	
	

	
	//business logic since multiple actions
	public void createNewOrgAndSave(String orgName)
	{
		enterOrgName.sendKeys(orgName);
		saveButton.click();
	}
	
	//create Org with org name and industry type (drop-down)
	public void createNewOrgAndSave(String orgName,String industry)
	{
		enterOrgName.sendKeys(orgName);
		//for Drop down
		Select sel=new Select(industryDropDown);
		sel.selectByVisibleText(industry);
		saveButton.click();
	}

}

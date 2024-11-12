package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrg;

	public WebElement getCreateNewOrg() {
		return createNewOrg;
	}	
	
	//for search text
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement  searchEdt;
	
	//for drop-down
	@FindBy(id = "bas_searchfield")
	private WebElement searchDropDown;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}
	

	@FindBy(name = "submit")
	private WebElement searchButton;
	
	public WebElement getSearchButton() 
	{
		return searchButton;
	}
	
}

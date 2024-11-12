package com.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage 
{
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement enterLastName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement clickSavebtn;
	
	public WebElement getEnterLastName() {
		return enterLastName;
	}

	public WebElement getClickSavebtn() {
		return clickSavebtn;
	}
	//business logic
	public void createConatct(String lastname)
	{
		enterLastName.sendKeys(lastname);
		clickSavebtn.click();
	}
	
}

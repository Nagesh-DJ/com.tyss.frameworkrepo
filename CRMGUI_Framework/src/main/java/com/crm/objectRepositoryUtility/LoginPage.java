package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//create a constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//step1:create a separate class
	//step2:Object creation/identification
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//step3:Object initialization using PageFactory
	
		
	//step4: Object encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	//using business logic
	public void LoginToApp(String username,String password)
	{
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();
	}
	
	//using business logic using url overloaded method
		public void LoginToApp(String Url,String username,String password)
		{
			driver.get(Url);
			driver.manage().window().maximize();
			usernameEdit.sendKeys(username);
			passwordEdit.sendKeys(password);
			loginButton.click();
		}
		
	


}

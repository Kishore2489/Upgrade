package com.qa.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit'][@data-auto='login']")
	WebElement LoginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	* The method is used to log Login
	* @param uname This is the Username for Login method 
	* @param pwd This is the Password for Login method 
	*/
	public OfferPage Login(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new OfferPage();
		
	}
	
	
	
	
	


}

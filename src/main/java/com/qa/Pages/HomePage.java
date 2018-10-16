package com.qa.Pages;

import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.BaseClass.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id="loan-amount")
	WebElement loanAmount;
	
	@FindBy(xpath="//*[@id=\"loan-purpose\"]")
	WebElement loanPurpose;
	
	@FindBy(xpath="//a[text()='Check Your Rate']")
	WebElement CheckRateBtn;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public  void adminViaDropDown() {
		
		Random r = new Random();
		int Low = 1;
		int High = 5;
		int x = r.nextInt(High-Low) + Low;
		
		Select s = new Select(driver.findElement(By.id("loan-purpose-select")));
		s.selectByIndex(x);
		
	}
	
	public PersonalInfoPage checkRate(String rate)
	{
		
		loanAmount.sendKeys(rate);
		System.out.println("loan amount entered: " +rate);
		adminViaDropDown();
		CheckRateBtn.click();
		System.out.println("Check your Rate is clicked");
		return new PersonalInfoPage();
	}

}




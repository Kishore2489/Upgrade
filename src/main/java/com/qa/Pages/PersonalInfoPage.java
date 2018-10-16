package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.TestBase;

public class PersonalInfoPage extends TestBase{
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='geosuggest__input']")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="zipCode")
	WebElement zipCode;
	
	@FindBy(name="dateOfBirth")
	WebElement dob;
	
	@FindBy(name="income")
	WebElement individualIncome;
	
	@FindBy(name="additionalIncome")
	WebElement additionalIncome;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='agreements']/../div")
	WebElement checkBox;
	
	@FindBy(xpath="//button[@type=\"submit\"][normalize-space(.='Check Your Rate')]")
	WebElement Submit;
	
	
	public PersonalInfoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OfferPage fillData(String FirstName,String LastName,String HomeAddress,
			String City, String State, String ZipCode, String DOB,
			String IndividualIncome ,String AnnualIncome,
			String UserName, String Password) {
		
		System.out.println(driver.getTitle());
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		address.sendKeys(HomeAddress);
		city.sendKeys(City);
		state.sendKeys(State);
		zipCode.sendKeys(ZipCode);
		dob.sendKeys(DOB);
		individualIncome.sendKeys(IndividualIncome);
		additionalIncome.sendKeys(AnnualIncome);
		username.sendKeys(UserName);
		password.sendKeys(Password);
		checkBox.click();
		Submit.click();
		
		return new OfferPage();
		
	}

}

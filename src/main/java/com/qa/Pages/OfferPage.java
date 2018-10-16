package com.qa.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.BaseClass.TestBase;

public class OfferPage extends TestBase {
	
	public static String amt;
	public static String payment;
	public static String loan;
	public static String apr;
	
	@FindBy(xpath="//*[@data-auto='userLoanAmount']")
	WebElement loanAmount;
	
	@FindBy(xpath="//*[@data-auto='defaultMonthlyPayment']")
	WebElement monthlyPayment;
	
	@FindBy(xpath="//*[@data-auto='defaultLoanTerm']")
	WebElement loanTerm;
	
	@FindBy(xpath="//*[@data-auto='defaultAPR']")
	WebElement APR;

	@FindBy(xpath="(//label[@for='header-nav-toggle'][normalize-space(.=\"Menu\")])[1]")
	WebElement Menu;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signOut;
	
	
	public OfferPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	* The method stores the value of Loan amount, Monthly Payment, loan term and APR rates
	* 
	*/
	public void getDetails()
	{
		amt = loanAmount.getText().trim();
		payment = monthlyPayment.getText().trim();
		loan = loanTerm.getText().trim();
		apr = APR.getText().trim();
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", Menu);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(signOut));
		signOut.click();
		

	
		
	}
	
	public void validatePageValues(String amt, String payment, String loan,String apr)
	{
		
		System.out.println("loan amount validated");
		Assert.assertEquals(loanAmount.getText(),amt);
		Assert.assertEquals(monthlyPayment.getText(), payment);
		System.out.println("monthly payment validated");
		Assert.assertEquals(loanTerm.getText(), loan);
		System.out.println("loan payment validated");
		Assert.assertEquals(APR.getText(), apr);
		System.out.println("apr amt validated");
		
	}
	
	public String validatePageUrl()
	{
		return driver.getCurrentUrl();
	}

}

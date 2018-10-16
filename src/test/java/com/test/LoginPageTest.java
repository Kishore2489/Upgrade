package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseClass.TestBase;
import com.qa.Pages.LoginPage;
import com.qa.Pages.OfferPage;

public class LoginPageTest extends TestBase{
		
		LoginPage lp;
		OfferPage of;
		public LoginPageTest()
		{
			super();
		}
		
		/* Initiating the  Browser */
		@BeforeMethod
		public void setUp() throws InterruptedException
		{
			logininit();
			lp = new LoginPage();
			
		}
		
		/**
		* The method verifies the Amount, Payment, Loan and APR
		* matches the corresponding values generated in previous screen
		*
		*/
		@Test(dependsOnMethods={"com.test.HomePageTest.SignUp"})
		public void Login()
		{
			of = lp.Login(prop.getProperty("UserName"),prop.getProperty("Password"));
			of.validatePageValues(OfferPage.amt, OfferPage.payment, OfferPage.loan, OfferPage.apr);	
			
		}
		
		/* Closing Browser */
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

	}




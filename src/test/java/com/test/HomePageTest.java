package com.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseClass.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.OfferPage;
import com.qa.Pages.PersonalInfoPage;

public class HomePageTest extends TestBase {
		
		HomePage hp;
		PersonalInfoPage pp;
		OfferPage of;
		LoginPage lp;
		
		public HomePageTest()
		{
			super();
		}
		
		/* Initiating Browser */
		@BeforeMethod
		public void setUp() throws InterruptedException
		{
			initialization();
			hp = new HomePage();
		}
		
		
		
		/**
		* The method allows to enter amount and reason for loan
		* Checks the rate after filling personal details 
		* Create a user account with User Name and password 
		* Generates Amount, Payment, Loan and APR values
		*
		*/
		@Test(priority=1)
		public void SignUp()
		{
			pp = hp.checkRate(prop.getProperty("rate"));
			of = pp.fillData(prop.getProperty("FirstName"),prop.getProperty("LastName"),prop.getProperty("HomeAddress"),prop.getProperty("City"),prop.getProperty("State"),prop.getProperty("ZipCode"),prop.getProperty("DOB"),prop.getProperty("IndividualIncome"),prop.getProperty("AnnualIncome"),prop.getProperty("UserName"),prop.getProperty("Password"));
			of.getDetails();
			
					
		}
		
		/* Closing Browser */
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
		
	}



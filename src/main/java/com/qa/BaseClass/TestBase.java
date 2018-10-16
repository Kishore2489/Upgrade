package com.qa.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
		
		public static WebDriver driver;
		
		public static Properties prop;
		public static String workingDir;
		
		public TestBase()
		{
			try {
				prop = new Properties();
				workingDir = System.getProperty("user.dir");
				FileInputStream fis = new FileInputStream(workingDir+"/src/main/java/com/qa/Config/config.properties");
				prop.load(fis);		
			}
			
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public static void initialization() throws InterruptedException
		{
			String browserName = prop.getProperty("browser");
			if(browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",workingDir+"/src/main/java/com/qa/driver/chromedriver.exe");
				driver = new ChromeDriver();	
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
		public static void logininit() throws InterruptedException
		{
			String browserName = prop.getProperty("browser");
			if(browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",workingDir+"/src/main/java/com/qa/driver/chromedriver.exe");
				driver = new ChromeDriver();	
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(prop.getProperty("loginurl"));
		}
}

package Hemanth;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	
	public void intialize() throws IOException {
		driver = initializeDriver();
		
	}
	 
	
	@Test(dataProvider ="getData")
	public void basePageNavigation(String emailId,String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		Log.info("URL Launched");
		
		LandingPage lp = new LandingPage(driver);
		LoginPage l= lp.getLogin();
		Log.info("Clicked on Login NAV button");
		l.getemailID().sendKeys(emailId);
		Log.info("enter email id");
		l.getpassword().sendKeys(password);
		Log.info("enter password");
		System.out.println(text);
		l.getLogin().click();
		Log.info("Clicked on Login Button");
		
	}
	
	
	@AfterTest
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
	
	@DataProvider	
	public Object[][] getData() {
		
		Object[][] a = new Object[2][3];
		
		a[0][0]="hemanth@gmail.com";
		a[0][1]="Hemanth";
		a[0][2]="Hemanth";
		
		a[1][0]="ironman@gmail.com";
		a[1][1]="ironman";
		a[1][2]="ironman";
		return a ;
		
	}

}

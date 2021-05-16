package Hemanth;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;


public class verifyNAVBar extends base {

	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	
@BeforeTest
	
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("URL Launched");
	}
	
	
	@Test
	public void navBar() throws IOException {
		
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getnavigationBar().isDisplayed());	
	    Log.info("Nav bar displayed");
	    
	    
		
	}
	
@AfterTest
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
}

package Hemanth;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.base;

public class verifyTitle extends base{

	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	
@BeforeTest
	
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("URL Launched");
	}
	
	@Test
	public void title() throws IOException {
		
		LandingPage lp = new LandingPage(driver);		
		String homepagetxt = lp.getHomepagetext().getText();		
		Assert.assertEquals(homepagetxt, "FEATURED COURSES");
		Log.info("Home page text verified successfully");
		
	}
	
@AfterTest
	
	public void closeBrowser() {
		
		driver.quit();
	}
}

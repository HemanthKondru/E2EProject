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
import pageObjects.forgotPWDpage;
import pageObjects.LoginPage;
import resources.base;

public class verifyforgotPWD extends base{

	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	
@BeforeTest
	
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("URL Launched");
	}
	
	@Test
	public void title() throws IOException, InterruptedException {
		
		LandingPage lp =new LandingPage(driver);
		LoginPage l =lp.getLogin();
		Log.info("navigated to Login Page");
		forgotPWDpage fp= l.getforgotPWD();
		Log.info("navigated to forgot pwd page");
		fp.getemail().sendKeys("Hemanth");
		Log.info("enter email id in forgor PWD page");
	}
	


@AfterTest
	
	public void closeBrowser() {
		
		driver.quit();
	}
}

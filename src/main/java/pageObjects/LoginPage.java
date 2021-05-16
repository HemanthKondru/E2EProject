package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
	public WebDriver driver;
	
    By emailID= By.xpath("//input[@id='user_email']");
    By password= By.xpath("//input[@id='user_password']");
    By Login= By.xpath("//input[@type='submit']");
    By forgotPWD = By.xpath("//a[contains(text(),'Forgot Password?')]");
    public LoginPage(WebDriver driver) {
    	
		this.driver = driver;
	}



	public WebElement getemailID() {
    	return driver.findElement(emailID);
    }
    
	public WebElement getpassword() {
    	return driver.findElement(password);
    }
	public WebElement getLogin() {
    	return driver.findElement(Login);
    }
	
	public forgotPWDpage getforgotPWD() {
		 driver.findElement(forgotPWD).click();
    	 forgotPWDpage fp =new forgotPWDpage(driver);
    	 return fp;
	}

}

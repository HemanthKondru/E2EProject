package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPWDpage {
	
	
	public WebDriver driver;
	
    By email= By.xpath("//input[@type='email']");
   
    
    public forgotPWDpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getemail() {
    	return driver.findElement(email);
    }
	
    

}

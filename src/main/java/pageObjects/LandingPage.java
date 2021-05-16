package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
    By login= By.xpath("//span[contains(text(),'Login')]");
    By text= By.xpath("//div[@class='text-center']/h2");
    By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
    
    public LandingPage(WebDriver driver) {
		this.driver = driver;
	}


	public LoginPage getLogin() {
    	 driver.findElement(login).click();
    	 LoginPage l = new LoginPage(driver);
    	 return l;
    	
    }
    
	public WebElement getHomepagetext() {
    	return driver.findElement(text);
    }
	
	public WebElement getnavigationBar() {
    	return driver.findElement(navigationBar);
    }
	
    

}

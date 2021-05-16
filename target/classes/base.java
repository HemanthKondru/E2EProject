package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop ;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\heman\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName = System.getProperty("browser");
		
		//mvn test -Dbrowser=ie/chrome from cmd prompt
		//String browserName = prop.getProperty("browser");
		
		if( browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\work\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println("given browser is not configured");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
		
	public String getScreenShot(String testcaeName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\reports\\"+testcaeName+".png";
		FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;
		
		
	}
	
	
	
	
	
	
		
		
		
		
}

	
	
	


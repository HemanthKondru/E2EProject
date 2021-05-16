package Hemanth;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import resources.extentReportsNg;

public class Listeners extends base implements ITestListener{
	ExtentTest test; 
	ExtentReports extent = extentReportsNg.getReportObject();
	ThreadLocal<ExtentTest> ExtentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentReports extent = extentReportsNg.getReportObject();
		String testmethodName = result.getMethod().getMethodName();
		test= extent.createTest(testmethodName);
		ExtentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest.get().log(Status.PASS, "test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String testmethodName = result.getMethod().getMethodName();
		try {
			ExtentTest.get().addScreenCaptureFromPath(getScreenShot(testmethodName,driver));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	

}

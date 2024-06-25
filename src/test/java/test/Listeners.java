package test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import pojo.Browser;
import utility.Reports;
import utility.Screenshots;

public class Listeners extends BaseTest implements ITestListener {
	
	
	  public void onStart(ITestContext result)
	  { 
		  reports=Reports.configureReport();
	  }
	  
	 
	  public void onFinish(ITestContext result)
	  {
		  reports.flush(); 
	  }
	  
	public void onTestStart(ITestResult result)
	{  
		System.out.println("Test Started:"+result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Success:"+result.getName());

		test.log(Status.PASS, result.getName());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped:"+result.getName());

		test.log(Status.SKIP, result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Fail:"+result.getName());

		test.log(Status.FAIL, result.getName());
		try
		{
		  Screenshots.takeScreenshots(driver, result.getName());	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	

}

package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports configureReport()
	{

	     ExtentReports reports=new ExtentReports();
	     ExtentSparkReporter htmlReporter=new ExtentSparkReporter("ExtentReport.html");
	     reports.attachReporter(htmlReporter);
	     reports.setSystemInfo("Suitname","Regrassion");
	     reports.setSystemInfo("Created By","Swati");
	     return reports;
	     
	}
	
}

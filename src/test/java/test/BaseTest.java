package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import pom.CartPage;
import pom.NaptolHomePage;
import pom.NaptolLoginPage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;

public class BaseTest {

	public static WebDriver driver;
	public NaptolHomePage naptolHomePage;
	public ProductResultPage productResultPage;
    public ProductDetailsPage productDetailsPage;
    public CartPage cartPage;
    public NaptolLoginPage naptolLoginPage;
    public static ExtentTest test;
   
	
	public static void switchToChildBrowser()
	{
		Set<String> handles=driver.getWindowHandles();
		Iterator <String> i=handles.iterator();
		while(i.hasNext())
		{
		   driver.switchTo().window(i.next());
		  // driver.switchTo().window(i.next());
		}
	}
	
}

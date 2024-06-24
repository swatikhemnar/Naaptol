package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.NaptolLoginPage;

public class LoginTest extends BaseTest {
	
	@BeforeMethod
	public void OpenApplication()
	{
		driver=Browser.launchApplication();
	}
	
	@Test
	public void verifyIsUserIsAbleToLogin() throws InterruptedException
	{
		naptolHomePage=new NaptolHomePage(driver);
		String beforeLogin=naptolHomePage.getNameOfLoginOrRegister();
		naptolHomePage.clickOnLoginOrRegister();
		NaptolLoginPage naptolLoginPage=new NaptolLoginPage(driver);
		naptolLoginPage.enterMobileNoToMobileNumberFeild("9096211102");
		naptolLoginPage.clickOnContionueButton();
		Thread.sleep(Duration.ofSeconds(20));
		naptolLoginPage.clickOnSubmit();
		Assert.assertTrue(naptolLoginPage.isLogOutDisplayed());
	}

}

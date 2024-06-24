package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import pom.CartPage;
import pom.NaptolHomePage;
import pom.NaptolLoginPage;
import pom.OrderDetailPage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;

public class LoginAfterProceedToCheckOutTest extends BaseTest {
	
	
	@Test
	public void verifyIfUserIsAbleToClickOnProceedToCheckOutButton() throws InterruptedException
	{
		   naptolHomePage=new NaptolHomePage(driver);
	       naptolHomePage.enterProductToSearch("cooker");
	       naptolHomePage.clickOnSearchIcon();
	       productResultPage=new ProductResultPage(driver);
	       productResultPage.selectDesiredProduct(0);
	       switchToChildBrowser();
	       productDetailsPage=new ProductDetailsPage(driver);
	       productDetailsPage.ClickOnClickToBuyButton();
	       cartPage=new CartPage(driver);
		   cartPage.clickOnProceedToCheckOut();
		   naptolLoginPage=new NaptolLoginPage(driver);
		   
		   OrderDetailPage orderDetailPage=new OrderDetailPage(driver);
		   orderDetailPage.enterMobNoToMobileNumberFeildForProceedToCheckOut("9096211102");
		   orderDetailPage.clickOnContinue();
		   Thread.sleep(20);
		   orderDetailPage.clickOnSubmit();
		   Assert.assertTrue(orderDetailPage.isOrderSummaryDisplayed());
		   
		   
		   
		    

	}

	

}

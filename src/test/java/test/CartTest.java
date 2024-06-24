package test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.NaptolLoginPage;
import pom.OrderDetailPage;
import pom.PaymentPage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;
import pom.ShippingAddressPage;

public class CartTest extends BaseTest{
	
	@BeforeMethod
	public void OpenApplication()
	{
		driver=Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsAbleToAddProductsInCart()
	{
		 naptolHomePage=new NaptolHomePage(driver);
		 naptolHomePage.enterProductToSearch("cooker");
		 naptolHomePage.clickOnSearchIcon();
		 
		 productResultPage=new ProductResultPage(driver);
		 productResultPage.selectDesiredProduct(1);
		 
		 switchToChildBrowser();
		 
		 productDetailsPage=new ProductDetailsPage(driver);
		 String expectedName=productDetailsPage.getProductNameOnChildBrowser();
		 double expectedPrice=productDetailsPage.getProductPriceOnChildBrowser();
		 double expectedShippingPrice=productDetailsPage.getShippingPriceOnChildBrowser();
		 productDetailsPage.ClickOnClickToBuyButton();
		 
		 cartPage=new CartPage(driver);
		 cartPage.ClickOnContinueShopping();
		 
		 naptolHomePage=new NaptolHomePage(driver);
		 naptolHomePage.enterProductToSearch("mobile");
		 naptolHomePage.clickOnSearchIcon();
		 
		 productResultPage=new ProductResultPage(driver);
		 productResultPage.selectDesiredProduct(2);
		 
		 switchToChildBrowser();
		 
		 productDetailsPage=new ProductDetailsPage(driver);
		 String expectedName1=productDetailsPage.getProductNameOnChildBrowser();
		 double expectedPrice1=productDetailsPage.getProductPriceOnChildBrowser();
		 double expectedShippingPrice1=productDetailsPage.getShippingPriceOnChildBrowser();
		 productDetailsPage.ClickOnClickToBuyButton();
		 
		 Assert.assertEquals(2,cartPage.getNoOfProductAddedInCart());
		 
		 Assert.assertEquals(expectedName,cartPage.getProductNameInCart(1));
		 Assert.assertEquals(expectedPrice,cartPage.getProductPriceInCart(2));
		 Assert.assertEquals(expectedShippingPrice,cartPage.getShippingPrice(2));
		  
		Assert.assertEquals(expectedName1,cartPage.getProductNameInCart(0));
		Assert.assertEquals(expectedPrice1,cartPage.getProductPriceInCart(1));
		Assert.assertEquals(expectedShippingPrice1,cartPage.getShippingPrice(1));
		 
		 	
	}
	
	@Test
	public void verifyIfUserIsAbleTORemoveProductsFromCart()
	{
		 naptolHomePage=new NaptolHomePage(driver);
		 naptolHomePage.enterProductToSearch("cooker");
		 naptolHomePage.clickOnSearchIcon();
		 
		 productResultPage=new ProductResultPage(driver);
		 productResultPage.selectDesiredProduct(1);
		 
		 switchToChildBrowser();
		 
		 productDetailsPage=new ProductDetailsPage(driver);
		 productDetailsPage.ClickOnClickToBuyButton();
		 
		 cartPage=new CartPage(driver);
		 cartPage.ClickOnContinueShopping();
		 
		 naptolHomePage=new NaptolHomePage(driver);
		 naptolHomePage.enterProductToSearch("mobile");
		 naptolHomePage.clickOnSearchIcon();
		 
		 productResultPage=new ProductResultPage(driver);
		 productResultPage.selectDesiredProduct(2);
		 
		 switchToChildBrowser();
		 
		 productDetailsPage=new ProductDetailsPage(driver);
	     productDetailsPage.ClickOnClickToBuyButton();
		 
		 
		 cartPage.clickOnRemove(0);
		// cartPage.clickOnRemove(1);
		 Assert.assertEquals(1,cartPage.getNoOfProductAddedInCart());
	}
	
	@Test
	public void verifyOrderAmount()
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
       Assert.assertEquals(cartPage.getOrderAmount(1),cartPage.getProductPriceInCart(1)+cartPage.getShippingPrice(1) );
	}
	
	@Test
	public void verifyCartAmountWithMultipleProduct()
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
	       cartPage.ClickOnContinueShopping();
	       naptolHomePage=new NaptolHomePage(driver);
	       naptolHomePage.enterProductToSearch("mobile");
	       naptolHomePage.clickOnSearchIcon();
	       productResultPage=new ProductResultPage(driver);
	       productResultPage.selectDesiredProduct(2);
	       switchToChildBrowser();
	       productDetailsPage=new ProductDetailsPage(driver);
	       productDetailsPage.ClickOnClickToBuyButton();
	       Assert.assertEquals(cartPage.getCartAmount(), (cartPage.getOrderAmount(1)+cartPage.getOrderAmount(2)));
	       	
	}
	
	@Test
	public void verifyTotalAmountWithMultipleProduct()
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
	       cartPage.ClickOnContinueShopping();
	       naptolHomePage=new NaptolHomePage(driver);
	       naptolHomePage.enterProductToSearch("mobile");
	       naptolHomePage.clickOnSearchIcon();
	       productResultPage=new ProductResultPage(driver);
	       productResultPage.selectDesiredProduct(2);
	       switchToChildBrowser();
	       productDetailsPage=new ProductDetailsPage(driver);
	       productDetailsPage.ClickOnClickToBuyButton();
	       Assert.assertEquals(cartPage.getTotalAmount(),(cartPage.getCartAmount()+cartPage.getDiscountAmount()));
	       	
	}


	@Test
	public void verifyIfUserIsAbleToLoginAfterProceedToCheckOutButton() throws InterruptedException
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
		   Assert.assertTrue(naptolLoginPage.isLoginBarDispalyed());
		   
		   OrderDetailPage orderDetailPage=new OrderDetailPage(driver);
		   orderDetailPage.enterMobNoToMobileNumberFeildForProceedToCheckOut("7218124230");
		   orderDetailPage.clickOnContinue();
		   Thread.sleep(Duration.ofSeconds(30));
		   orderDetailPage.clickOnSubmit();
		   Assert.assertTrue(orderDetailPage.isLogoutDispalyed());   
	}
	
	@Test
	public void verifyIfUserIsAbleToFillShippingAddressForm() throws InterruptedException
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
		   orderDetailPage.enterMobNoToMobileNumberFeildForProceedToCheckOut("8975934529");
		   orderDetailPage.clickOnContinue();
		   Thread.sleep(Duration.ofSeconds(30));
		   orderDetailPage.clickOnSubmit();
		   
		   ShippingAddressPage shippingAddressPage=new ShippingAddressPage(driver);
		   shippingAddressPage.getTitle();
		   
		   Actions actions=new Actions(driver);
		   
		   actions.keyDown(Keys.TAB);
		   actions.sendKeys("Advait");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);
		   
		   actions.keyDown(Keys.TAB);
		   actions.sendKeys("Khemnar");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   
		   actions.keyDown(Keys.TAB);
		   actions.sendKeys("Hadpsar,Pune-412208");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   
		   actions.keyDown(Keys.TAB);
		   actions.sendKeys("Pune Solapur Highway");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   actions.keyDown(Keys.TAB);
		   actions.sendKeys("412208");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   actions.keyDown(Keys.TAB);
		   shippingAddressPage.getState();
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   actions.keyDown(Keys.TAB);
		   shippingAddressPage.getCity();
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   actions.keyDown(Keys.TAB);
           actions.sendKeys("8975934529");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   actions.keyDown(Keys.TAB);
           actions.sendKeys("");
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   actions.keyDown(Keys.TAB);
           actions.click();
		   actions.keyUp(Keys.TAB);
		   Thread.sleep(2000);

		   
		   actions.build().perform();
		   
		   System.out.print("test completed.....");
		   
		  // Assert.assertTrue(shippingAddressPage.isshipAddressDisplayed());
		   
		  shippingAddressPage.clickOnShipAddressButton();
		  
		  PaymentPage paymentPage=new PaymentPage(driver);
		  
		  Assert.assertTrue(paymentPage.istypeOfPyementSliderDispayed());

	}
	
	}
 
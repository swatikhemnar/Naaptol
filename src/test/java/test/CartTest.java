package test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;

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
		 String expectedPrice=productDetailsPage.getProductPriceOnChildBrowser();
		 String expectedShippingPrice=productDetailsPage.getShippingPriceOnChildBrowser();
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
		 String expectedPrice1=productDetailsPage.getProductPriceOnChildBrowser();
		 String expectedShippingPrice1=productDetailsPage.getShippingPriceOnChildBrowser();
		 productDetailsPage.ClickOnClickToBuyButton();
		 
		 Assert.assertEquals(2,cartPage.getNoOfProductAddedInCart());
		 
		 Assert.assertEquals(expectedName,cartPage.getProductNameInCart(1));
		 Assert.assertEquals(expectedPrice,cartPage.getProductPriceInCart(2));
		 Assert.assertEquals(expectedShippingPrice,cartPage.getShippingPrice(2));
		 
		
		 
		Assert.assertEquals(expectedName1,cartPage.getProductNameInCart(0));
		Assert.assertEquals(expectedPrice1,cartPage.getProductPriceInCart(1));
		Assert.assertEquals(expectedShippingPrice1,cartPage.getShippingPrice(1));
		 
		 cartPage.clickOnRemove(1);
		 cartPage.clickOnRemove(0);
		 Assert.assertEquals(cartPage.getTextofNoProductInCart(),"You have No Items in Cart !!!");
		 
		 //Assert.assertEquals(expectedName,cartPage.getProductNameInCart(1));
		 //Assert.assertEquals(expectedPrice,cartPage.getProductPriceInCart(2));
		 //Assert.assertEquals(expectedShippingPrice,cartPage.getShippingPrice(2));
		 
		
		
	}

}

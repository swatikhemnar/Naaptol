package test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;

@Listeners(test.Listeners.class)

public class ProductSearchTest extends BaseTest {
	
	  @BeforeMethod public void OpenApplication()
	  {
	      driver=Browser.launchApplication(); 
	  }
	 
	@Test(priority=2)
	public void verifyIfUserIsAbleToSearchProduct()
	{
		reports.createTest("verifyIfUserIsAbleToSearchProduct");
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		//naptolHomePage.enterProductToSearch("iphone");
		naptolHomePage.enterProductToSearch("mobile");
		naptolHomePage.clickOnSearchIcon();
		//Assert.assertTrue(driver.getTitle().contains("iphone"));
		Assert.assertTrue(driver.getTitle().contains("mobile"));
		Assert.assertTrue(naptolHomePage.getNumberOfProductDispalyed()>0);
		
	}
	
	@Test(priority=1)
	public void verifyIfUserIsAbleToClickOnLoginLink()
	{
		reports.createTest("verifyIfUserIsAbleToClickOnLoginLink");
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.clickOnLoginOrRegister();
		boolean result=naptolHomePage.isMobileNoOnLoginPopUpDisplayed();
        Assert.assertTrue(result);
        
      //Assert.assertTrue(false);
       
        ///String expectedTitle="Online Shopping India, Shop Mobile Phone, Mens & Womens Wear, Jewellery, Home Appliances at Naaptol.com";
      	//String actualTitle=driver.getTitle();
      	//Assert.assertEquals(actualTitle, expectedTitle);
              
	}
	
	
	@Test(priority=3)
	public void verifyIfUserIsAbleToClickOnTrackOrderLink()
	{
		reports.createTest("verifyIfUserIsAbleToClickOnTrackOrderLink");
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.clickOnTrackOrder();
		String expectedTitle="Naaptol Track Order - Track Online Order Status";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	@Test(priority=4)
	public void verifyIfUserIsAbleToDisplayShoppingCategories()
	{
		reports.createTest("verifyIfUserIsAbleToDisplayShoppingCategories");
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naptolHomePage.isListedItemDisplayed());
		
	}
	
	
	@Test(priority=5)
	public void verifyIfUserIsAbleToClickOnShoppingCart()
	{
		reports.createTest("verifyIfUserIsAbleToClickOnShoppingCart");
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.clickOnShoppingCart();
		Assert.assertTrue(naptolHomePage.isMyshoppincartDisplayed());
		
	}
	
	
	  @AfterMethod public void closeApplication()
	  { 
		  driver.close(); 
	  }
	 
}

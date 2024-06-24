package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;

public class ProductSearchTest extends BaseTest {
	@BeforeMethod
	public void OpenApplication()
	{
		driver=Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsAbleToSearchProduct()
	{
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		//naptolHomePage.enterProductToSearch("iphone");
		naptolHomePage.enterProductToSearch("mobile");
		naptolHomePage.clickOnSearchIcon();
		//Assert.assertTrue(driver.getTitle().contains("iphone"));
		Assert.assertTrue(driver.getTitle().contains("mobile"));
		Assert.assertTrue(naptolHomePage.getNumberOfProductDispalyed()>0);
		
	}
	
	@Test
	public void verifyIfUserIsAbleToClickOnLoginLink()
	{
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.clickOnLoginOrRegister();
		boolean result=naptolHomePage.isMobileNoOnLoginPopUpDisplayed();
        Assert.assertTrue(result);
        
      //Assert.assertTrue(false);
       
        ///String expectedTitle="Online Shopping India, Shop Mobile Phone, Mens & Womens Wear, Jewellery, Home Appliances at Naaptol.com";
      	//String actualTitle=driver.getTitle();
      	//Assert.assertEquals(actualTitle, expectedTitle);
              
	}
	
	
	@Test
	public void verifyIfUserIsAbleToClickOnTrackOrderLink()
	{
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.clickOnTrackOrder();
		String expectedTitle="Naaptol Track Order - Track Online Order Status";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	@Test
	public void verifyIfUserIsAbleToDisplayShoppingCategories()
	{
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.viewShoppingCategories(driver);
		Assert.assertTrue(naptolHomePage.isListedItemDisplayed());
		
	}
	
	
	@Test
	public void verifyIfUserIsAbleToClickOnShoppingCart()
	{
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.clickOnShoppingCart();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Shopping Cart: ']")).isDisplayed());
		
	}
	
	@AfterMethod
	public void closeApplication()
	{
		driver.close();
	}

}

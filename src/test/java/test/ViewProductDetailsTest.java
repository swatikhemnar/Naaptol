package test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductDetailsPage;
import pom.ProductResultPage;

public class ViewProductDetailsTest extends BaseTest{
	
	@BeforeMethod
	public void openApplication()
	{
		driver=Browser.launchApplication();
		
	}
	
	@Test
	public void verifyIfUserIsAbleToViewProductDetailsFromQuickView() {
		
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearchIcon();
		
		ProductResultPage productResultPage=new ProductResultPage(driver);
		String productTitle=productResultPage.getProductTitle(1);
		String productPrice=productResultPage.getProductPrice(1);
		productResultPage.moveToDesiredProduct(driver, 1);
		productResultPage.clickOnQuickView(1);
	    Assert.assertEquals(productTitle, productResultPage.getProductTitleOnQuickView());
		Assert.assertEquals(productPrice, productResultPage.getProductPriceOnQuickView());
				
	}
	
	@Test
	public void verifyIfUserIsAbleToViewProductDetailsByClickOnProduct()
	{
		NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearchIcon();
        
		ProductResultPage productResultPage=new ProductResultPage(driver);
		String ExpectedTitle=productResultPage.getProductTitle(0);
		String ExpectedPrice=productResultPage.getProductPrice(0);
		productResultPage.selectDesiredProduct(0);
		Set<String> handles=driver.getWindowHandles();
		Iterator <String> i=handles.iterator();
		driver.switchTo().window(i.next());
		driver.switchTo().window(i.next());
		
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
		
		Assert.assertEquals(ExpectedTitle,productDetailsPage.getProductNameOnChildBrowser());
		Assert.assertEquals(ExpectedPrice, productDetailsPage.getProductPriceOnChildBrowser());
		
		
		
		
		
	}

}

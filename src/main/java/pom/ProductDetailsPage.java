package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	@FindBy(xpath="//div[@id='square_Details']//h1") private WebElement childBrowserProductName;
	@FindBy(xpath="//div[@id='square_Details']//span[@class='offer-price']") private WebElement childBrowserProductPrice;
	@FindBy(xpath="//a[@id='cart-panel-button-0']")private WebElement clickToBuy;
	
	
	public ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnClickToBuyButton()
	{
		clickToBuy.click();
	}

	public String getProductNameOnChildBrowser()
	{
		return childBrowserProductName.getText();
	}
	
	public String getProductPriceOnChildBrowser()
	{
		String P[]=childBrowserProductPrice.getText().split(" ");
		return P[0];
	}
 
	public String getShippingPriceOnChildBrowser()
	{
		String P[]=childBrowserProductPrice.getText().split(" ");
		return P[2];
	}
	
	

}

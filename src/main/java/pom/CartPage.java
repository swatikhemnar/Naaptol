package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(xpath="//ul[@id='cartData']") private List<WebElement> noOfProductsAddedInCart;
	@FindBy(xpath="//ul[@id='cartData']//h2") private List<WebElement> productNameInCart;
	@FindBy(xpath="//li[@class='head_UPrice']") private List<WebElement> productPriceInCart ;
	@FindBy(xpath="//li[@class='head_ship']") private List<WebElement> shippingPrice;
	@FindBy(xpath="//ul[@id='shopCartHead']//a") private WebElement continueShopping;
	@FindBy(xpath="//a[text()='Remove']") private List<WebElement> remove;
	@FindBy(xpath="(//section[@id='ShoppingCartPopup']//span[@class='font-bold'])[1]")private WebElement noProductInCart;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getTextofNoProductInCart()
	{
		return noProductInCart.getText();
	}
	public void clickOnRemove(int index)
	{
		remove.get(index).click();
	}
	public void ClickOnContinueShopping()
	{
		continueShopping.click();
		
	}
	public int getNoOfProductAddedInCart()
	{
		return noOfProductsAddedInCart.size();
	}
	
	public String getProductNameInCart(int index)
	{
		return productNameInCart.get(index).getText();
	}
	
	public String getProductPriceInCart(int index)
	{
		//Start index from 1 as 0 is table heading
		return productPriceInCart.get(index).getText().substring(3);
	}
	
	public String getShippingPrice(int index)
	{
		//Start index from 1 as 0 is table heading
		return shippingPrice.get(index).getText().substring(3);
	}
}

package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

	@FindBy(xpath="//ul[@id='cartData']") private List<WebElement> noOfProductsAddedInCart;
	@FindBy(xpath="//ul[@id='cartData']//h2") private List<WebElement> productNameInCart;
	@FindBy(xpath="//li[@class='head_UPrice']") private List<WebElement> productPriceInCart ;
	@FindBy(xpath="//li[@class='head_ship']") private List<WebElement> shippingPrice;
	@FindBy(xpath="//ul[@id='shopCartHead']//a") private WebElement continueShopping;
	@FindBy(xpath="//a[text()='Remove']") private List<WebElement> remove;
	@FindBy(xpath="//li[@class='head_Amount']") private List<WebElement> orderAmount;
	@FindBy(xpath="//ul[@id='cartTotal']//label") private WebElement cartAmount; 
	@FindBy(xpath="//span[@id='totalPayableAmount']") private WebElement totalAmount; 
	@FindBy(xpath="//span[@id='cvDiscount']") private WebElement discountAmount; 
	@FindBy(xpath="//a[@class='red_button2']") private WebElement proceedToCheckOut;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
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
	
	public Double getProductPriceInCart(int index)
	{
		//Start index from 1 as 0 is table heading
		return Double.parseDouble(removeCommaFromString(productPriceInCart.get(index).getText().substring(3)));
	}
	
	public Double getShippingPrice(int index)
	{
		//Start index from 1 as 0 is table heading
		return Double.parseDouble(removeCommaFromString(shippingPrice.get(index).getText()).substring(3));
	}
	
	public double getOrderAmount(int index) {
		
		//start index form 1 as 0 is heading
		return Double.parseDouble(removeCommaFromString(orderAmount.get(index).getText()));
		
	}
	
	public double getCartAmount()
	{
		return Double.parseDouble(removeCommaFromString(cartAmount.getText().substring(3)));
	}
	
	public double getTotalAmount()
	{
		return Double.parseDouble(removeCommaFromString(totalAmount.getText()));
	}
	

	public double getDiscountAmount()
	{
		return Double.parseDouble(removeCommaFromString(discountAmount.getText()));
	}
	
	public void clickOnProceedToCheckOut() {
		proceedToCheckOut.click();

	}
	
}

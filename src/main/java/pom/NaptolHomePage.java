package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage{
	
	@FindBy(xpath="//a[@id='login-panel-link']")private WebElement loginOrRegister;
	@FindBy(xpath="//a[text()='Track Order']")private WebElement trackOrder;
	@FindBy(xpath="//div[@class='cate_head']") private WebElement shoppingCategory;
	@FindBy(xpath="//input[@id='header_search_text']") private WebElement searchFeild;
	@FindBy(xpath="(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]") private WebElement searchIcon;
	@FindBy(xpath="(//a[@id='cart-panel-link'])[2]") private WebElement shoppingCart;
	@FindBy(xpath="//div[@id='mainMenuContent']//ul//li[1]//a//span") private WebElement listIteam;
	@FindBy(xpath="//div[@id='page1']/div") private List <WebElement> productList;
	@FindBy(xpath="//input[@id='registration-basic-panel-mobile']") private WebElement MobileNoOnLoginPopUp;
	
	public NaptolHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public void clickOnLoginOrRegister()
	{
		loginOrRegister.click();
	}
	
	public void clickOnTrackOrder()
	{
		trackOrder.click();
	}
	
	public void viewShoppingCategories(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(shoppingCategory);
		action.perform();		
	}
	
	public void enterProductToSearch(String product)
	{
		searchFeild.sendKeys(product);
	}

	public void clickOnSearchIcon()
	{
		searchIcon.click();
	}
	
	public void clickOnShoppingCart()
	{
		shoppingCart.click();
	}
	
	public boolean isListedItemDisplayed()
	{
		return listIteam.isDisplayed();
	}
	
	public int getNumberOfProductDispalyed()
	{
		return productList.size();
	}
	
	
	public boolean isMobileNoOnLoginPopUpDisplayed() 
	{	
		return MobileNoOnLoginPopUp.isDisplayed();
	}
}

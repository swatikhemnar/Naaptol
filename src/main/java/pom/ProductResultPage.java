package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductResultPage {
	WebDriver driver;
	@FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy(xpath="//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> quickView;
	@FindBy(xpath="//div[@class='item_title']//a") private List<WebElement> productTitle;
	@FindBy(xpath="//span[@class='offer-price']") private List<WebElement> offerPrice;
	@FindBy(xpath="//div[@id='square_Details']//h1") private WebElement productTitleOnQuickView;
	@FindBy(xpath="//div[@id='square_Details']//span[@class='offer-price']") private WebElement offerPriceOnQuickView;
	
	
	
	public ProductResultPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void moveToDesiredProduct(WebDriver driver,int index)
	{
		Actions action=new Actions(driver);
		action.moveToElement(products.get(index));
		action.perform();
		
	}
   
	public void selectDesiredProduct(int index)
	{
		products.get(index).click();
	}
	
	
	public void clickOnQuickView(int index)
	{
		quickView.get(index).click();
	}
	
	
	public String getProductPrice(int index) {
		return offerPrice.get(index).getText();
	}
	
	public String getProductTitleOnQuickView() {
		return productTitleOnQuickView.getText();
		
	}
	
	public String getProductPriceOnQuickView() {
		String [] P= offerPriceOnQuickView.getText().split(" ");
		return P[0];
	}

	public String getProductTitle(int index) {
		// TODO Auto-generated method stub
		return productTitle.get(index).getText();
	}
}

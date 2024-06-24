package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
	
	@FindBy(xpath="//select[@name='fktitle_id']")private WebElement title;
	@FindBy(xpath="//a[@id='shipAddress1']")private WebElement shipAddressButton;
	@FindBy(xpath="//select[@name='state']")private WebElement state;
	@FindBy(xpath="//select[@name='city']")private WebElement city;
	@FindBy(xpath="")private WebElement firstName;
	@FindBy(xpath="")private WebElement lastName;
	@FindBy(xpath="")private WebElement completeAddress;
	@FindBy(xpath="")private WebElement landmark;
	@FindBy(xpath="")private WebElement pincode;
	@FindBy(xpath="")private WebElement mobileNum;
	@FindBy(xpath="")private WebElement LandlineNum;
	@FindBy(xpath="")private WebElement saveAndProceed;
	
	
	public ShippingAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getTitle()
	{
	   Select obj=new Select(title);
	   obj.selectByIndex(0);
	}
	
	public void getState()
	{
	   Select obj=new Select(state);
	   obj.selectByVisibleText("MAHARASHTRA");
	}
	
	public void getCity()
	{
	   Select obj=new Select(state);
	   obj.selectByIndex(0);
	}
	
	public boolean isshipAddressDisplayed()
	{
		return shipAddressButton.isDisplayed();
	}
	
	public void clickOnShipAddressButton()
	{
		shipAddressButton.click();
	}

}

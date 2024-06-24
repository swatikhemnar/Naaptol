package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pojo.Browser;

public class OrderDetailPage {
	@FindBy(xpath="//input[@id='gc-registration-basic-panel-submit']") private WebElement cantinue;
	@FindBy(xpath="//input[@id='gc-registration-otp-panel-submit']") private WebElement submit;
	@FindBy(xpath="(//input[@placeholder='Enter mobile number'])[2]") private WebElement mobNoOfProceedToCheckOut;
    @FindBy(xpath="//div[@class='summaryData clearfix']") private WebElement orderSummary;
    @FindBy(xpath="//a[text()='Logout']") private WebElement logout;
    
    
	public OrderDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enterMobNoToMobileNumberFeildForProceedToCheckOut(String mobileNo)
	{
		mobNoOfProceedToCheckOut.sendKeys(mobileNo);
		
	}
	
	public boolean isOrderSummaryDisplayed()
	{
		return orderSummary.isDisplayed();
	}
	
	
	public boolean isLogoutDispalyed()
	{
		return logout.isDisplayed();
	}
	public void clickOnContinue()
	{
		cantinue.click();
	}
	
	
	public void clickOnSubmit() {
		submit.click();
	}
}

package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolLoginPage {

	
	@FindBy(xpath="//input[@id='registration-basic-panel-mobile']") private WebElement mobileNumberFeild;
	@FindBy(xpath="//div[@class='clearfix']//div[@class='small_links']") private WebElement loginBar;
	@FindBy(xpath="//input[@id='registration-basic-panel-submit']") private WebElement continueButton;
	@FindBy(xpath="//div[@class='summaryData clearfix']") private WebElement orderSummary;
	@FindBy(xpath="//input[@id='registration-otp-panel-submit']")private WebElement submit;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logout;
	

	public NaptolLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterMobileNoToMobileNumberFeild(String mobNo)
	{
		mobileNumberFeild.sendKeys(mobNo);
	}
	
	
	public void clickOnContionueButton()
	{
		continueButton.click();
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	public boolean isLoginBarDispalyed()
	{
		return loginBar.isDisplayed();
	}
	public boolean isorderSummaryDispalyed()
	{
		return orderSummary.isDisplayed();
	}
	
	
	public boolean isLogOutDisplayed() 
	{
		return logout.isDisplayed();

	}
	
}

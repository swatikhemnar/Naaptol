package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolLoginPage {

	
	@FindBy(xpath="//input[@id='registration-basic-panel-mobile']") private WebElement mobileNumberFeild;
	
	
	
	public NaptolLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterMobileNoToMobileNumberFeild(String mobNo)
	{
		mobileNumberFeild.sendKeys(mobNo);
	}
	
}

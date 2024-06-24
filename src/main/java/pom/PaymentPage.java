package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	@FindBy(xpath="//ul[@class='verticalslider_tabs']") private WebElement typeOfPaymentSlider;
	
	
	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean istypeOfPyementSliderDispayed()
	{
		return typeOfPaymentSlider.isDisplayed();
	}
	

}

package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {

	public static void takeScreenshots(WebDriver driver,String name) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination=new File("D:\\ElipseNew\\Naptol\\src\\main\\resources"+name+".png");
		
		FileHandler.copy(source, destination);
		
		
	}
}

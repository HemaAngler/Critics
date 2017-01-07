package browserCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Alerts 
{
	WebDriver driver;

	@BeforeClass
	public void beforeClass() 
	{ 
		System.setProperty("webdriver.chrome.driver", "E:\\Software_Backup\\Selenium\\Chrome_Latest\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
	}

	@Test
	public void simpleAlert() 
	{
		//Simple alerts just have a OK button on them. 
		//They are mainly used to display some information to the user. 
		Alert A1 = driver.switchTo().alert();
		String getAlertMsg = A1.getText();
		System.out.println(getAlertMsg);
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
}

//Alert is a pop up window that comes up on screen.
//Alerts can be a result of many users action like button click.
//Alerts are different from regular windows. The main difference is alerts are blocking in nature.
//It will not allow any action in the underlying web page when it is present.
//It throws UnhandledAlertException: Modal dialog present
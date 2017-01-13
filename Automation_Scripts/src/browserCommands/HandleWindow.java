package browserCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class HandleWindow 
{
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software_Backup\\Selenium\\Chrome_Latest\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void handleWindow() throws Exception
	{
		driver.get("http://www.guru99.com/");
		Thread.sleep(5000);
		String getMainWindow = driver.getWindowHandle();
		System.out.println("Main Window:"+getMainWindow);
		Set<String> getAllWindows = driver.getWindowHandles();
		int windowscount = getAllWindows.size();
		System.out.println("All Windows Size:"+windowscount);
		for(String currentWindow : getAllWindows)
		{
			if(currentWindow.equals(getMainWindow))
			{
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}
		//driver.switchTo().window(getMainWindow);
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
}

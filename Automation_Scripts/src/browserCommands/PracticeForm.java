package browserCommands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeForm 
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
	public void testForm() throws Exception
	{
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		
		driver.findElement(By.name("firstname")).sendKeys("Hema");
		Thread.sleep(2000);
		
		driver.findElement(By.name("lastname")).sendKeys("latha");
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("latha");
		Thread.sleep(2000);
		
		WebElement getTextValue = driver.findElement(By.xpath("html/body/div[1]/div[5]/div[2]/div/div/form/fieldset/div[1]/a[2]/strong"));
		String getText =  getTextValue.getText();
		System.out.println("Text:"+getText);
		Thread.sleep(2000);
		
		WebElement submitBtn = driver.findElement(By.id("submit"));
		String getTag =  submitBtn.getTagName();
		System.out.println("Tag:"+getTag);
		
		org.openqa.selenium.Dimension d = submitBtn.getSize();
		System.out.println("Width:"+d.width);
		System.out.println("Height:"+d.height);
		
		
		Point p = submitBtn.getLocation();
		System.out.println("X coordinate:"+p.x);
		System.out.println("Y Coordinate:"+p.y);
		
		Thread.sleep(2000);
		
		List<WebElement> chkExperience = driver.findElements(By.name("exp"));
		for(WebElement w : chkExperience)
		{
			String getVal = w.getAttribute("value");
			if(getVal.equals("5"))
			{
				w.click();
			}
		}
		Thread.sleep(2000);

		List<WebElement> chkAutomationTool = driver.findElements(By.name("tool"));
		for(int i=0;i<chkAutomationTool.size();i++)
		{
			String getVal = chkAutomationTool.get(i).getText();
			if(getVal.equals("Selenium Webdriver"))
			{
				chkAutomationTool.get(i).click();
			}
		}
		Thread.sleep(2000);
		
	}

	@AfterClass
	public void afterClass() 
	{
		driver.close();
	}

}

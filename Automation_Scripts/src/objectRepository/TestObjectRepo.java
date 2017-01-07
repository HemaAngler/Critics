package objectRepository;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestObjectRepo 
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
	public void register() throws Exception
	{
		String getSourceFilePath = System.getProperty("user.dir");
		System.out.println("Source File Path:"+getSourceFilePath);
		FileInputStream fis = new FileInputStream("D:\\Workspace\\Automation_Scripts\\src\\objectRepository\\object.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		driver.get("http://automationpractice.com");
		//driver.findElement(By.cssSelector("#menu-item-374 > a")).click();
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}

}


//In selenium WebDriver software automation testing tool, There Is not any built In facility to create object repository. 
//So maintenance of page objects(Page element locators) becomes very hard If you will write all objects of page on code level. 
//Let me give you one simple example - You have one search button on page of software web application and you have used It(Using Id locator) In many of your test cases. 
//Now supposing someone has changed Its Id In your application then what you will do? You will go for replacing Id of that element In all test cases wherever It Is used? 
//It will create overhead for you. 
//Simple solution to remove this overhead Is creating object repository using properties File support of java software development language. 
//In properties file, First we can write element locator of software web element and then we can use It In our test cases.
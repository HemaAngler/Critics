package browserCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class ActionEvents 
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
	//Action Class - Handle Keyboard and Mouse Events.
	@Test(priority=0,enabled=false)
	public void mouseHover() throws Exception
	{
		driver.get("http://automationpractice.com");
		WebElement ele = driver.findElement(By.linkText("Women"));
		Actions a = new Actions(driver);
		Action aa = a.moveToElement(ele).build();
		aa.perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[2]/ul/li[1]/a"))).build().perform();
		Thread.sleep(2000);
	}

	@Test(priority=1,enabled=false)
	public void dragAndDrop() throws Exception
	{
		//Drag and Drop an element
		driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
		WebElement drag = driver.findElement(By.id("dragdiv"));
		WebElement drop = driver.findElement(By.id("dropdiv"));

		Actions a = new Actions(driver);
		/*a.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
		Thread.sleep(2000);*/
		a.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(2000);
	}

	@Test(priority=2,enabled=false)
	public void dragAndDropBy() throws Exception
	{
		/*Suppose, We have an element which you wants to drag and drop 
		by 100 pixel offset In horizontal direction 
		or 100 pixel offset In Vertical direction 
		or both the directions at the same time 
		then you can use dragAndDropBy method of webdriver's Actions class.*/

		//new Actions(driver).dragAndDropBy(dragElementFrom, 100, 0).build() .perform();
		//new Actions(driver).dragAndDropBy(dragElementFrom, 0, 100).build() .perform();

		//new Actions(driver).dragAndDropBy(dragElementFrom, -100, -100).build() .perform();

		driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
		WebElement drag = driver.findElement(By.id("dragdiv"));

		Actions a = new Actions(driver);
		a.dragAndDropBy(drag, 100, 0).build().perform();
		Thread.sleep(5000);
		//To generate alert after horizontal direction drag and drop. VIEW EXAMPLE
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
		Thread.sleep(5000);
		driver.switchTo().alert().accept(); 

		//To drag and drop element by 100 pixel offset In Vertical direction Y.
		new Actions(driver).dragAndDropBy(drag, 0, 100).build().perform();  

		//To generate alert after Vertical direction drag and drop.
		javascript.executeScript("alert('Element Is drag and drop by 100 pixel offset In Vertical direction.');");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();

		//To drag and drop element by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.
		new Actions(driver).dragAndDropBy(drag, -100, -100).build().perform();

		//To generate alert after horizontal and vertical direction drag and drop.
		javascript.executeScript("alert('Element Is drag and drop by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.');");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=3,enabled=false)
	public void selectJqueryItems() throws Exception
	{
		//To select jquery selectable items
		driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
		List<WebElement> selectableItems = driver.findElements(By.xpath("//ol[@id='selectable']/*"));
		
		Actions a = new Actions(driver);
		a.clickAndHold(selectableItems.get(2)).clickAndHold(selectableItems.get(5)).click();
		Action selectItems = a.build();
		selectItems.perform();
		Thread.sleep(2000);
	}
	
	@Test(priority=4,enabled=false)
	public void doubleClick() throws Exception
	{
		//To double click on buttons
		driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
		WebElement ele = driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"));
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
		Thread.sleep(2000);
	}
	
	@Test(priority=5,enabled=true)
	public void moveSlider() throws Exception
	{
		//Move Jquery Slider.
		driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
}

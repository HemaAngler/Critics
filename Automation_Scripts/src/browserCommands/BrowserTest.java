package browserCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class BrowserTest 
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
  
  @Test(priority=0)
  public void browserCmd() 
  {
	  String url="http://www.store.demoqa.com/";
	  
	  driver.get(url);
	   
	  String title=driver.getTitle();
	  System.out.println("Webpage Title:"+title);
	  int titleLen=title.length();
	  System.out.println("Title Length:"+titleLen);
	  
	  String actualurl=driver.getCurrentUrl();
	  System.out.println("Current URL:"+actualurl);
	  
	  if(actualurl.equals(url))
	  {
		  System.out.println("Verification Success");
	  }
	  else
	  {
		  System.out.println("Verification Fails");
	  }
	  
	  String pageSource=driver.getPageSource();
	  //System.out.println("Page Source:"+pageSource);
	  int pageSrcLen=pageSource.length();
	  System.out.println("Page Source Length:"+pageSrcLen);
  }
  
  @Test(priority=1)
  public void navigationCmd() throws Exception
  {
	  driver.navigate().to("http://www.DemoQA.com");
	  
	  driver.findElement(By.cssSelector("#menu-item-374 > a")).click();
	  
	  driver.navigate().back();
	  Thread.sleep(2000);
	  
	  driver.navigate().forward();
	  Thread.sleep(2000);
	  
	  driver.navigate().refresh();
	  Thread.sleep(2000);  
  }
  
  @Test(priority=2)
  public void selectMethods() throws Exception
  {
	  driver.get("http://toolsqa.wpengine.com/automation-practice-form");
	  
	  WebElement ele1=driver.findElement(By.id("continents"));
	  Select sel1=new Select(ele1);
	  
	  sel1.selectByVisibleText("Australia");	  
	  Thread.sleep(4000);	  
	  sel1.selectByIndex(6);  
	  Thread.sleep(4000);  
	  //sel.selectByValue("Australia");  
	  //Thread.sleep(4000);
	  boolean chk1=sel1.isMultiple();
	  System.out.println("Is Multiple:"+chk1);
	  
	  WebElement ele2=driver.findElement(By.id("selenium_commands"));
	  Select sel2=new Select(ele2);
	  boolean chk2=sel2.isMultiple();
	  System.out.println("Is Multiple:"+chk2);
	  
	  List<WebElement> lst1=sel1.getOptions();
	  for(int i=0;i<lst1.size();i++)
	  {
		  System.out.println("Options 1:"+lst1.get(i).getText());
	  }
	  
	  List<WebElement> lst2=sel2.getOptions();
	  for(WebElement e : lst2)
	  {
		  System.out.println("Options 2:"+e.getText());
	  }
	  
	  sel2.selectByVisibleText("WebElement Commands");
	  sel2.selectByVisibleText("Browser Commands");
	  sel2.selectByVisibleText("Switch Commands");
	  sel2.selectByVisibleText("Wait Commands");
	  
	  List<WebElement> selectedLst=sel2.getAllSelectedOptions();
	  for(WebElement e : selectedLst)
	  {
		  System.out.println("Before Deselection:"+e.getText());
	  }
	  
	  String firstSelectedText=sel2.getFirstSelectedOption().getText();
	  System.out.println("First Selected Option Text:"+firstSelectedText);
	  Thread.sleep(4000);
	  
	  sel2.deselectByVisibleText("Browser Commands");
	  Thread.sleep(2000);
	  sel2.deselectByIndex(2);
	  Thread.sleep(2000);
	  //sel2.deselectByValue("Wait Commands");
	  
	  String firstSelectedText1=sel2.getFirstSelectedOption().getText();
	  System.out.println("First Selected Option Text after Deselection:"+firstSelectedText1);
	  Thread.sleep(4000);
	  
	  Thread.sleep(2000);
	  sel2.deselectAll();
	  
	  List<WebElement> selectedLst1=sel2.getAllSelectedOptions();
	  for(WebElement e : selectedLst1)
	  {
		  System.out.println("After Deselection:"+e.getText());
	  } 
  }
  
  @Test(priority=3) 
  public void checkradioOperations() throws Exception
  {
	  driver.findElement(By.id("exp-2")).click();
	  
	  boolean chk3= driver.findElement(By.id("profession-0")).isSelected();
	  if(chk3==true)
	  {
		  driver.findElement(By.id("profession-1")).click();
	  }
	  else
	  {
		  driver.findElement(By.id("profession-0")).click();
	  }
	  
	  List<WebElement> chkboxList=driver.findElements(By.name(""));
	  for(int i=0;i<chkboxList.size();i++)
	  {
		  String getVal=chkboxList.get(i).getAttribute("value");
		  if(getVal.equals("Selenium Webdriver"))
		  {
			  chkboxList.get(i).click();
		  }
	  }
	  Thread.sleep(5000);
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}

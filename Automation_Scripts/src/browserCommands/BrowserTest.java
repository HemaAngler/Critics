package browserCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class BrowserTest 
{
  WebDriver driver;
  
  /*@BeforeClass
  public void beforeClass() 
  { 
	  System.setProperty("webdriver.chrome.driver", "E:\\Software_Backup\\Selenium\\Chrome_Latest\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }*/
  
  @BeforeClass
  @Parameters({"browser"})
  public void beforeClass(String browser) 
  { 
	  if(browser.equals("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "E:\\Software_Backup\\Selenium\\geckodriver.exe");
		  driver = new FirefoxDriver();
	  }
	  else if(browser.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "E:\\Software_Backup\\Selenium\\Chrome_Latest\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
  @Test(priority=0)
  public void browserCmd() 
  {
	  String url="http://www.store.demoqa.com/";
	  
	  //Loads a new web page in current browser window.
	  driver.get(url);
	  
	  //Fetches the title of the current web page.
	  String title=driver.getTitle();
	  System.out.println("Webpage Title:"+title);
	  //Returns the title length of the current web page.
	  int titleLen=title.length();
	  System.out.println("Title Length:"+titleLen);
	  
	  //Returns the URL of the page currently loaded in the web browser.
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
	  
	  //Returns the source code of the web page.
	  String pageSource=driver.getPageSource();
	  System.out.println("Page Source:"+pageSource);
	  //Returns the source code length of the web page
	  int pageSrcLen=pageSource.length();
	  System.out.println("Page Source Length:"+pageSrcLen);
  }
  
  @Test(priority=1)
  public void navigationCmd() throws Exception
  {
	  //Loads a new web page in the current browser window.
	  driver.navigate().to("http://www.DemoQA.com");
	  
	  driver.findElement(By.cssSelector("#menu-item-374 > a")).click();
	  
	  //It performs same operation as clicking back button in the web browser.
	  //Takes backward by one page on the browsers history.
	  driver.navigate().back();
	  Thread.sleep(2000);
	  
	  //It performs same operation as clicking forward button in the web browser.
	  //Takes forward by one page on the browsers history.
	  driver.navigate().forward();
	  Thread.sleep(2000);
	  
	  //It performs same operation as pressing F5 on keyboard.
	  //It refresh the current web page.
	  driver.navigate().refresh();
	  Thread.sleep(2000);  
  }
  
  @Test(priority=2)
  public void selectMethods() throws Exception
  {
	  driver.get("http://toolsqa.wpengine.com/automation-practice-form");
	  
	  WebElement ele1=driver.findElement(By.id("continents"));
	  Select sel1=new Select(ele1);
	  
	  //Select option based on the visible text.
	  sel1.selectByVisibleText("Australia");	  
	  Thread.sleep(4000);	
	  //Select option based on the index provided by the user.
	  sel1.selectByIndex(6);  
	  Thread.sleep(4000);  
	  //Select option based on the value provided in the "value" attribute.
	  //sel.selectByValue("Australia");  
	  //Thread.sleep(4000);
	  //Check whether select allows multiple selection.
	  boolean chk1=sel1.isMultiple();
	  System.out.println("Is Multiple:"+chk1);
	  
	  WebElement ele2=driver.findElement(By.id("selenium_commands"));
	  Select sel2=new Select(ele2);
	  boolean chk2=sel2.isMultiple();
	  System.out.println("Is Multiple:"+chk2);
	  
	  //Displays all the options
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
	  
	  //Returns the selected options.
	  List<WebElement> selectedLst=sel2.getAllSelectedOptions();
	  for(WebElement e : selectedLst)
	  {
		  System.out.println("Before Deselection:"+e.getText());
	  }
	  
	  //Returns the first selected option.
	  String firstSelectedText=sel2.getFirstSelectedOption().getText();
	  System.out.println("First Selected Option Text:"+firstSelectedText);
	  Thread.sleep(4000);
	  
	  //Deselect option based on the visible text
	  sel2.deselectByVisibleText("Browser Commands");
	  Thread.sleep(2000);
	  //DeSelect option based on the index provided by the user.
	  sel2.deselectByIndex(2);
	  Thread.sleep(2000);
	  //DeSelect option based on the value provided in the "value" attribute.
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
	  //Select checkbox/radio button based on ID.
	  driver.findElement(By.id("exp-2")).click();
	  
	  //Select checkbox/radio button using isSelected().
	  boolean chk3= driver.findElement(By.id("profession-0")).isSelected();
	  if(chk3==true)
	  {
		  driver.findElement(By.id("profession-1")).click();
	  }
	  else
	  {
		  driver.findElement(By.id("profession-0")).click();
	  }
	  
	  //Select checkbox/radio button based on value.
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
	  //Close the current window that the web driver is currently controlling.
	  driver.close();
	  //Close all the windows opened by the web driver.
	  //driver.quit();
  }

}

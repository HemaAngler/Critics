package pack_testng;

import org.testng.annotations.Test;

import config.WebConstants;
import executionEngine.BaseClass;
import utility.RepositoryParser;

public class Test_Class1 extends RepositoryParser
{
	@Test(priority=0)
	public void login() throws Exception
	{
		BaseClass.driver.get("http://automationpractice.com");
		Thread.sleep(2000);
		super.locateElement(WebConstants.SIGNIN).click();
		super.locateElement(WebConstants.USERNAME).sendKeys("hemaramanujam2010@gmail.com");
		super.locateElement(WebConstants.PASSWORD).sendKeys("sairam123");
		super.locateElement(WebConstants.SUBMIT).click();
		Thread.sleep(2000);
		//throw new RuntimeException();
	}
	
	@Test(priority=1,dependsOnMethods={"login"})
	public void orderHistory() throws Exception
	{
		super.locateElement(WebConstants.ORDERHISTORY).click();
		super.locateElement(WebConstants.BACKBTN).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2,dependsOnMethods={"login","orderHistory"})
	public void creditSlips()
	{
		super.locateElement(WebConstants.CREDITSLIPS).click();
		super.locateElement(WebConstants.BACKBTN).click();
	}
	
	@Test(priority=3)
	public void wishList()
	{
		super.locateElement(WebConstants.WISHLISTLINK).click();
		super.locateElement(WebConstants.BACKTOACC).click();
	}
}

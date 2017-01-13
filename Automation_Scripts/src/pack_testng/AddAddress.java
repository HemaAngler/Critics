package pack_testng;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import executionEngine.BaseClass;

public class AddAddress extends BaseClass
{
	@Test
	public void addAddress() throws Exception
	{
		BaseClass.driver.get("http://automationpractice.com");
		Thread.sleep(2000);
		BaseClass.driver.findElement(By.linkText("Sign in")).click();
		BaseClass.driver.findElement(By.id("email")).sendKeys("hemaramanujam2010@gmail.com");
		BaseClass.driver.findElement(By.id("passwd")).sendKeys("sairam123");
		BaseClass.driver.findElement(By.id("SubmitLogin")).click();
	
		BaseClass.driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/ul/li[3]/a")).click();
		BaseClass.driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/ul/li[1]/a")).click();
		
		/*String getPageTitle = BaseClass.driver.getTitle();
		System.out.println(getPageTitle);
		if(getPageTitle.equals("My account - My Store"))
		{
			throw new SkipException("Skip Exception");
		}*/
	}
}

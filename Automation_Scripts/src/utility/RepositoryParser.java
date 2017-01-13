package utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.Constants;
import executionEngine.BaseClass;

public class RepositoryParser extends BaseClass
{
	public FileInputStream fis;
	public Properties prop = new Properties();

	public WebElement locateElement(String locatorName)
	{
		WebElement element = null;
		try
		{
			fis = new FileInputStream(Constants.PATH_OBJECTREPO);
			prop.load(fis);
			element = driver.findElement(getLocator(locatorName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return element;
	}

	public By getLocator(String locatorName)
	{
		By locator = null;

		String locatorProperty = prop.getProperty(locatorName);
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];

		switch(locatorType)
		{
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator=By.name(locatorValue);
			break;
		case "ClassName":
			locator=By.className(locatorValue);
			break;
		case "LinkText":
			locator=By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator=By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator=By.tagName(locatorValue);
			break;
		case "Xpath":
			locator=By.xpath(locatorValue);
			break;
		case "CssSelector":
			locator=By.cssSelector(locatorValue);
			break;
		}
		return locator;
	}



}

package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInfo {
	
	@FindBy (xpath="//input[@id='first-name']")
	private WebElement Fname;
	
	@FindBy (xpath="//input[@id='last-name']")
	private WebElement Lname;

	@FindBy (xpath="//input[@id='postal-code']")
	private WebElement Zip;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement Continue;
	
	public YourInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterFname(String fname)
	{
		Fname.sendKeys(fname);
	}
	
	public void EnterLname(String lname)
	{
		Lname.sendKeys(lname);
	}
	
	public void EnterZip(String zip)
	{
		Zip.sendKeys(zip);
	}
	
	public void Continue()
	{
		Continue.click();
	}
	
	public void EnterInfo()
	{
		Fname.sendKeys("abc");
		Lname.sendKeys("xyz");
		Zip.sendKeys("0000");
		Continue.click();
	}

}

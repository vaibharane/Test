package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;

public class LoginPage {
	
	@FindBy (xpath="//input[@id='user-name']") 
	private WebElement username;
	
	@FindBy (xpath="//input[@id='password']") 
	private WebElement password;
	
	@FindBy (xpath="//input[@id='login-button']") 
	private WebElement Login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendusername(String a)
	{
		username.sendKeys(a);
	}
	public void sendpassword(String p)
	{
		password.sendKeys(p);
	}
	public void Login()
	{
		Login.click();
	}
	public void LoginToApplication(String s,String b)
	{
		username.sendKeys(s);
		password.sendKeys(b);
		Login.click();
	}
}

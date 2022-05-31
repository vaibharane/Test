package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver openchromebrowser()
	{
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\browser\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
		
	}
	
	public static WebDriver openFirefoxbrowser()
	{
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\browser\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
		
	}



}

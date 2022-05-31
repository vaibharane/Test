package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browsers.Base;
import POMClasses.HomePage;
import POMClasses.LoginPage;
import Utils.Utility;

public class VerifyLogin_AddToCart {
	
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	
	SoftAssert soft;
	@Parameters ("browsername")
	
	@BeforeTest
	public void launchbrowser1(String browser)
	{
		System.out.println(browser);
		System.out.print("Bye");
		if(browser.equals("chrome"))
		{
			driver=Base.openchromebrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver=Base.openFirefoxbrowser();
			
		}
	}
	
	@BeforeClass
	public void lcreatePOMobjects()
	{
		 loginpage=new LoginPage(driver);
		 homepage=new HomePage(driver);
	}
	@BeforeMethod
	public void logintoapplication() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
driver.get("https://www.saucedemo.com/");
		String data=Utility.getexcelsheetdata("Sheet1",1,0);
		System.out.println(data);
		loginpage.sendusername(data);
		
		data=Utility.getexcelsheetdata("Sheet1",1,1);
		System.out.println(data);
		loginpage.sendpassword(data);
		
		loginpage.Login();
		homepage=new HomePage(driver);
		soft=new SoftAssert();
		
	}
	@Test(priority=-1)
	public void verifyhomepage()
	{
    String url=driver.getCurrentUrl();
		soft.assertEquals("https://www.saucedemo.com/inventory.html", url);
		System.out.println("P3");
		soft.assertAll();
		
	}
	@Test
	public void verifyaddtocart()
	{
		homepage.dropdown();
		homepage.AddToCart1();
		homepage.AddToCart2();
		homepage.GoToCart();
String url1=driver.getCurrentUrl();
		
Assert.assertEquals("https://www.saucedemo.com/cart.html", url1);
	System.out.println("P4");
	}
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		System.out.println(result.getStatus());
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.capturescreenshot(driver);
		}
		
		homepage.clickonmenu();
		homepage.logout();
	}
	@AfterClass
	public void clearobject()
	{
		loginpage=null;
		homepage=null;
	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver=null;
		System.out.println("close");
		System.gc();  //garbage collection
	}
	

}

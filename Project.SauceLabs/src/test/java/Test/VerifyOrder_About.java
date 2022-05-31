package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
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

import Browsers.Base;
import POMClasses.AboutPage;
import POMClasses.HomePage;
import POMClasses.LoginPage;
import POMClasses.Overview;
import POMClasses.YourCart;
import POMClasses.YourInfo;
import Utils.Utility;

public class VerifyOrder_About {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	AboutPage aboutpage;
	YourCart yourcart;
	YourInfo yourinfo;
	Overview overview;
	int row;
	
	
	@Parameters ("browsername")
	@BeforeTest
	public void launchbrowser(String browser)
	{
		System.out.println(browser);
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
	public void createPOMobjects()
	{
		 loginpage=new LoginPage(driver);
	     homepage=new HomePage(driver);
		aboutpage=new AboutPage(driver);
		yourcart=new YourCart(driver);
		yourinfo=new YourInfo(driver);
		 overview=new Overview(driver);
	}
	@BeforeMethod
	public void logintoapplication() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://www.saucedemo.com/");
				
				LoginPage loginpage=new LoginPage(driver);
				String data=Utility.getexcelsheetdata("Sheet1",1,0);
			    System.out.println(data);
				loginpage.sendusername(data);
				data=Utility.getexcelsheetdata("Sheet1",1,1);
			    System.out.println(data);
				loginpage.sendpassword(data);
				loginpage.Login();
			
				
	}
	@Test(priority=-1,invocationCount=2)
	public void verifyorder() throws EncryptedDocumentException, IOException
	{
		System.out.println("P1");
		homepage.dropdown();
		homepage.AddToCart1();
		homepage.AddToCart2();
		homepage.GoToCart();
        yourcart.CheckOut();
        row=1;
        String data=Utility.getexcelsheetdata("Sheet1",row,2);
        System.out.println(data);
		yourinfo.EnterFname(data);
		data=Utility.getexcelsheetdata("Sheet1",row,3);
	    System.out.println(data);
		yourinfo.EnterLname(data);
		data=Utility.getexcelsheetdata("Sheet1",row,4);
	    System.out.println(data);
		yourinfo.EnterZip(data);
		yourinfo.Continue();
		overview.Finish();
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://www.saucedemo.com/checkout-complete.html");
		row++;
		
	}
	@Test
	public void verifyautomatedtesting()
	{
		System.out.println("P2");
		homepage.about();
        aboutpage.clickautomatedtesting();	
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://saucelabs.com/solutions/automated-testing");
		
	}
	@AfterMethod
	public void logout(ITestResult result) throws IOException
	{
		System.out.println(result.getStatus());
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.capturescreenshot(driver);
		}
		homepage.clickonmenu();
		homepage.logout();
		System.out.println("logoutmethod2");
	}
	@AfterClass
	public void clearobject()
	{
		loginpage=null;
		homepage=null;
		aboutpage=null;
        yourcart=null;
		yourinfo=null;
		overview=null;
	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		driver=null;
		System.out.println("close");
		System.gc(); 
	}
	

}

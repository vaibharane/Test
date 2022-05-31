package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POMClasses.AboutPage;
import POMClasses.HomePage;
import POMClasses.LoginPage;
import POMClasses.Overview;
import POMClasses.YourCart;
import POMClasses.YourInfo;
import Utils.Utility;

public class TestClass {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium and Chrome files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	//1st test case verify login functionality	
		driver.get("https://www.saucedemo.com/");
		
		LoginPage loginpage=new LoginPage(driver);
		String data=Utility.getexcelsheetdata("Sheet1",1,0);
		System.out.println(data);
		loginpage.sendusername(data);
	    data=Utility.getexcelsheetdata("Sheet1",1,1);
		loginpage.sendpassword(data);
		loginpage.Login();
		
		String url=driver.getCurrentUrl();
		
		if(url.equals("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
	/*	HomePage homepage=new HomePage(driver);
		homepage.clickonmenu();
		homepage.logout();
		//driver.close();
		
//2nd test case
		driver.get("https://www.saucedemo.com/");
		
	    loginpage=new LoginPage(driver);
		loginpage.sendusername();
		loginpage.sendpassword();
		loginpage.Login();
		homepage=new HomePage(driver);
		homepage.dropdown();
		homepage.AddToCart1();
		homepage.AddToCart2();
		homepage.GoToCart();
String url1=driver.getCurrentUrl();
		
		if(url1.equals("https://www.saucedemo.com/cart.html"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	//3rd test case	
		YourCart yourcart=new YourCart(driver);
		yourcart.CheckOut();
		
		YourInfo yourinfo=new YourInfo(driver);
		yourinfo.EnterFname();
		yourinfo.EnterLname();
		yourinfo.EnterZip();
		yourinfo.Continue();
		
		Overview overview=new Overview(driver);
		overview.Finish();
		String url4=driver.getCurrentUrl();
		System.out.println(url4);
		
		homepage.clickonmenu();
		homepage.logout();
		
		//4th test case
		
		loginpage.sendusername();
		loginpage.sendpassword();
		loginpage.Login();
		
		homepage.about();
		AboutPage aboutpage=new AboutPage(driver);
		aboutpage.clickautomatedtesting();
		
		String url2=driver.getCurrentUrl();
		System.out.println(url2);
		*/
		
		
	}

}

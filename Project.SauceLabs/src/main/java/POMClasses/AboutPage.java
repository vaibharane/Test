package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
	
	@FindBy (xpath="(//div[@class='nav-menu'])[2]")
	private WebElement solution;
	@FindBy (xpath="(//span[text()='Automated Testing'])[2]")
	private WebElement automatedtesting;
	
	WebDriver driver;
	
	public AboutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void clickautomatedtesting()
	{
		Actions a=new Actions(driver);
		a.moveToElement(solution).perform();
		a.moveToElement(automatedtesting).perform();
		a.click().perform();
		
		
	}

	
	
	
	
}

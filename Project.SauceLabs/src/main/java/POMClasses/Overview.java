package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview {
	
	@FindBy (xpath="//button[@id='finish']")
	private WebElement Finish;
	
	public Overview(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Finish()
	{
		Finish.click();
	}

}

package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	@FindBy (xpath="//select[@class='product_sort_container']") 
	private WebElement  dropdown;
	
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") 
	private WebElement AddToCart1;
	
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-backpack']") 
	private WebElement AddToCart2;
	
	@FindBy (xpath="//a[@class='shopping_cart_link']")
	private WebElement Cart;
	
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")
	private WebElement Menu;
	
	@FindBy (xpath="//a[@id='logout_sidebar_link']")
	private WebElement LogOut;
	
	@FindBy (xpath="//a[@id='about_sidebar_link']")
	private WebElement about;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void dropdown()
	{
		Select s=new Select(dropdown);
		s.selectByVisibleText("Price (high to low)");
	}
	public void AddToCart1()
	{
		AddToCart1.click();
	}
	public void AddToCart2()
	{
		AddToCart2.click();
	}
	public void GoToCart()
	{
		Cart.click();
	}
	public void clickonmenu()
	{
		Menu.click();
	}
	public void logout()
	{
		LogOut.click();
	}
	public void about()
	{
		Menu.click();
		about.click();
	}
	

}

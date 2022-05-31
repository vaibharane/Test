package Test;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGKeywords {
	
	@BeforeClass
	public void beforeclas()
	{
		System.out.println("beforeclass");
	}

	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("beforemethod");
	}
	@Test(priority=0,invocationCount=2,enabled=false)
	public void testA()
	{
		System.out.println("A");
	}
	@Test
	public void testB() throws InterruptedException
	{
		System.out.println("B");
		
	}
	@Test(priority=0)
	public void testC()
	{
		System.out.println("C");
	}
	@Test
	public void testD()
	{
		System.out.println("D");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("aftermethod");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("afterclass");
	}
	
	
	
	
	
	
	
	
	
}

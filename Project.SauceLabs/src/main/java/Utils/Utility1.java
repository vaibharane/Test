package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility1 {
	
	public static void capturescreenshot(WebDriver driver) throws IOException
	{
		
		DateFormat format=new SimpleDateFormat("dd-MM-yyyy HH mm ss");
		Date date=new Date();
		String d=format.format(date);
		System.out.println(d);
		
		TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\New folder\\Test10101"+ d +".jpeg");
		FileHandler.copy(source, dest);
		
		//Utility.capturescreenshot(driver);
		
	}
	
		public static String get() throws EncryptedDocumentException, IOException
		{
			String path="src\\main\\resources\\testdata\\Saucelab.xlsx";
			FileInputStream file=new FileInputStream(path);
			String d=WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
			return d;
			
		}
		
		
		
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String s=Utility1.get();
		System.out.println();
		}
	
		
		
	}
	
	
	



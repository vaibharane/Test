package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void capturescreenshot(WebDriver driver) throws IOException
	{
		  DateFormat format=new SimpleDateFormat("dd-MM-yyyy HH mm ss");
			
			Date systemdate=new Date();
			
			String d=format.format(systemdate);
			System.out.println(d);
			
			System.out.println("test123"+d);
		
		TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\New folder\\Test10101"+ d +".jpeg");
		FileHandler.copy(source, dest);
	}
	                                      
	public static String getexcelsheetdata(String x,int y,int z) throws EncryptedDocumentException, IOException
	{
		String data;
		
		String path="E:\\New folder\\Saucelab.xlsx";
		FileInputStream file=new FileInputStream(path);
		Cell cell=WorkbookFactory.create(file).getSheet(x)
		.getRow(y).getCell(z);
		try
		{
			data=cell.getStringCellValue();//sheet, row,cell
		}
		catch(IllegalStateException e)//shee1,1,0//sheet1,row1,cell1
		{
			double d=cell.getNumericCellValue();
			int a=(int)d;
			data=Integer.toString(a);
			
		}
		return data;
		
	}
	
	
}

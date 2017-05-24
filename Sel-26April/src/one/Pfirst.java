package one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Pfirst {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void frun(String s) {
	
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	  driver.findElement(By.id("lst-ib")).sendKeys(s);
		driver.findElement((By.xpath(".//*[@id='_fZl']"))).click();
		

  }

  @DataProvider
  public Object[][] dp() throws IOException {
   Object [][] rtn=f("C://Users/dedua/git/App-V1/Sel-26April/UserInput/Book1.xlsx",0);
return rtn; 
     
  }
public String[][] f(String fpath, int i) throws IOException {
	// TODO Auto-generated method stub
	
	String[][] tabA=null;
	InputStream fname = null;
	XSSFWorkbook wb = null;

	try {
		fname = new FileInputStream(fpath);
		wb = new XSSFWorkbook(fname);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	XSSFSheet sheet = wb.getSheetAt(0);
	XSSFRow row;
	XSSFCell cell;
	
	int rnum=sheet.getLastRowNum()+1;
	int cnum= sheet.getRow(0).getLastCellNum();
	tabA=new String[rnum][cnum];
	for(int i1=0;i1<rnum;i1++)
	{
		
		for(int j=0;j<cnum;j++)
		{
			
			tabA[i1][j]=sheet.getRow(i1).getCell(j).getStringCellValue();
		}
	}
	/*Iterator itr = sheet.rowIterator();
	

	while (itr.hasNext()) {

		cell = (XSSFCell) itr.next();
		cell.getStringCellValue();

	}*/
	
	return tabA;
}

@BeforeClass
  public void beforeClass() {
 
	  System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\dedua\\Downloads\\geckodriver-v0.16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://google.com");}

  @AfterClass
  public void afterClass() {
 driver.quit();
  }

 
}

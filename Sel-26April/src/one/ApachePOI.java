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

public class ApachePOI {

	

	public void readxl(String fpath) throws IOException {

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
		Iterator itr = sheet.rowIterator();

		while (itr.hasNext()) {

			cell = (XSSFCell) itr.next();
			f(cell);

		}
		fname.close();

	}

	private void f(XSSFCell cell) {
		// TODO Auto-generated method stub

		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys(cell.getStringCellValue());
		driver.findElement((By.xpath(".//*[@id='_fZl']"))).click();
		driver.findElement(
				(By.xpath(".//*[@id='rso']/div/div/div[1]/div/div/h3/a")))
				.click();*/

	}
	
	public static void main(String[] args)
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\dedua\\Downloads\\geckodriver-v0.16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://google.com");
		
	}

}

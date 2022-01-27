
package Reprice_GB_main;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Reprice_GB.Step03_Response2_Reprice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lib.Excel;

public class Response2_Reprice {
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet = "Login";
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		// System.setProperty("webdriver.chrome.driver","C:\\Chrome
		// driver\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();

		// id = Excel.getCellValue(xlsFilePath, sheet, 2, 0);
		// paswd = Excel.getCellValue(xlsFilePath, sheet, 2, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 8, 2);

		// String url1 = "https://" + id + ":" + paswd + "@" + url;

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Test to add response

	@Test(priority = 0)
	public void add_response() throws IOException, InterruptedException {

		Step03_Response2_Reprice addresp = new Step03_Response2_Reprice(driver);
		addresp.login("twoigb001@gb.com", "woi2cool");
		addresp.openRequest();
		addresp.alertcall();
		addresp.RepriceSkill();
	}

	@Test(priority = 1)
	public void add_response1() throws IOException, InterruptedException {

		Step03_Response2_Reprice addresp = new Step03_Response2_Reprice(driver);
		addresp.login("twoide002a@de.com", "woi2cool");
		addresp.openRequest();

	}
}

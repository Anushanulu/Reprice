
package Reprice_US_main;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Reprice_US.Step05_Response1_Reprice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lib.Excel;

public class Response1_Reprice {
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
		url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);

		// String url1 = "https://" + id + ":" + paswd + "@" + url;

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Test to add response2
	/*
	 * @Test(priority=0) public void resp2login() throws IOException,
	 * InterruptedException {
	 * 
	 * Step03_AddResponse_Reprice addresp = new
	 * Step03_AddResponse_Reprice(driver);
	 * addresp.login("marvel@ibm.com","csa2test"); }
	 * 
	 * @Test(priority=1) public void resp2_search_request() throws
	 * InterruptedException {
	 * 
	 * Step03_AddResponse_Reprice search = new
	 * Step03_AddResponse_Reprice(driver); search.openRequest(); }
	 * 
	 * @Test(priority=2) public void resp2_alertcall() throws
	 * InterruptedException {
	 * 
	 * Step03_AddResponse_Reprice alertcall = new
	 * Step03_AddResponse_Reprice(driver); alertcall.alertcall(); }
	 * 
	 * @Test(priority=3) public void resp2_reprice() throws InterruptedException
	 * { Step03_AddResponse_Reprice reprice = new
	 * Step03_AddResponse_Reprice(driver); reprice.RepriceSkill(); }
	 */

	

	// Test to add response1
	@Test(priority = 0)
	public void resp1login() throws IOException, InterruptedException {

		Step05_Response1_Reprice addresp = new Step05_Response1_Reprice(driver);
		addresp.login("twoius001@us.ibm.com", "woi4tst");
		addresp.openRequest();
		addresp.alertcall();
		addresp.RepriceSkill();
	}

}

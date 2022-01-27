package Reprice_IN_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Reprice_IN.Step03and05_CreateRequest_resp1Repricehistory;

import java.io.IOException;

import org.apache.log4j.Logger;

import lib.Excel;

public class CreateRequestAuth_resp1Repricehistory {
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

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project
		// csa\\Softwares\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();

		// id = Excel.getCellValue(xlsFilePath, sheet, 12, 0);
		// paswd = Excel.getCellValue(xlsFilePath, sheet, 12, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 13, 2);

		// String url1 = "https://" + id + ":" + paswd + "@" + url;

		driver.get(url);
		driver.manage().window().maximize();
	}

	// test to Login to the application as RIPC
	@Test(priority = 0)
	public void RIPC_Login() throws InterruptedException {

		Step03and05_CreateRequest_resp1Repricehistory login = new Step03and05_CreateRequest_resp1Repricehistory(driver);
		login.login();
	}

	@Test(priority=1)
 	public void searchRequest() throws IOException, InterruptedException 
 	{

		Step03and05_CreateRequest_resp1Repricehistory search = new Step03and05_CreateRequest_resp1Repricehistory(driver);
 	 search.SearchRequest();
 	}
  @Test(priority=2)
 	public void RepriceHistory() throws IOException, InterruptedException 
 	{

	  Step03and05_CreateRequest_resp1Repricehistory history = new Step03and05_CreateRequest_resp1Repricehistory(driver);
	  history.RepriceHistoryResp2();
 	}
}

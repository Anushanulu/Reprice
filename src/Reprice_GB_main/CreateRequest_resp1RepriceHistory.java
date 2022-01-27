package Reprice_GB_main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Reprice_GB.Step04_CreateRequest_resp2RepriceHistory;
import lib.Excel;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import lib.Excel;


public class CreateRequest_resp1RepriceHistory {
	
	//public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath =System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	//public static String xlsFilePath = System.getProperty("./src/TnM_Review_Core/src/main/resources/testdata/testdata.xls");
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");

		//ProfilesIni ini = new ProfilesIni();
		//FirefoxProfile profile = ini.getProfile("default");
		//WebDriver driver =  new FirefoxDriver(profile);

		driver = new FirefoxDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		url = Excel.getCellValue(xlsFilePath, sheet, 7, 2);
		


		driver.get(url); 
		driver.manage().window().maximize();
	}	

	@Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException 
	{

		Step04_CreateRequest_resp2RepriceHistory login = new Step04_CreateRequest_resp2RepriceHistory(driver);
		login.login();
	}
  @Test(priority=1)
 	public void searchRequest() throws IOException, InterruptedException 
 	{

	  Step04_CreateRequest_resp2RepriceHistory search = new Step04_CreateRequest_resp2RepriceHistory(driver);
 	 search.SearchRequest();
 	}
  @Test(priority=2)
 	public void RepriceHistory() throws IOException, InterruptedException 
 	{

	  Step04_CreateRequest_resp2RepriceHistory history = new Step04_CreateRequest_resp2RepriceHistory(driver);
	  history.RepriceHistoryResp2();
 	}
}

		

package Reprice_GB_main;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Reprice_GB.Step02_AddResponseGB;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lib.Excel;




public class AddResponse
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath =System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;


	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 2, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 2, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 8, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	



	// Test to add response
	/*@Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException 
	{

		Step02_AddResponseGB addresp = new Step02_AddResponseGB(driver); 
	    addresp.login();
	}
	@Test(priority=1)
	public void search_request() throws InterruptedException 
	{

		Step02_AddResponseGB search = new Step02_AddResponseGB(driver); 
		search.openRequest();
		//search.waitForFormOverlayDisappear();
	}
	@Test(priority=2)
	public void alertmininmize() throws InterruptedException
	{
		Step02_AddResponseGB alertcall = new Step02_AddResponseGB(driver); 
		alertcall.alertcall();
	} 
	@Test(priority=3)
 	public void create_res() throws InterruptedException 
 	{

	  Step02_AddResponseGB btnclick = new Step02_AddResponseGB(driver);
	  //btnclick.waitForFormOverlayDisappear();
	  btnclick.buttonClick();
 	}
	 
	
	
  @Test(priority=4)
 	public void add_Attachement() 
 	{

	  Step02_AddResponseGB attachemnt = new Step02_AddResponseGB(driver); 
	  attachemnt.addAttachement();
 	}
//  @Test(priority=5)
//	public void fill_resdetails() throws IOException, InterruptedException  
//	{
//	  ResponseCreation resdetails = new ResponseCreation(driver); 
//	  resdetails.resDetails("fresp", "mresp", "lresp");
//	  //resdetails.resDetails();
//	}
  @Test(priority=5)
	public void fill_resdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponseGB resdetails = new Step02_AddResponseGB(driver); 
	  for (int i=1; i<98; i++)
	  {
				resdetails.resDetails("fresp"+i, "mresp"+i, "lresp"+i);
				break;
	  }
	}
  @Test(priority=6)
	public void fill_resAttrdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponseGB resattrs = new Step02_AddResponseGB(driver); 
	  resattrs.resAttributeDetails();
	}
  @Test(priority=7)
	public void fill_ratesdetails() throws IOException, InterruptedException  
	{
	 int j = 40;
	  Step02_AddResponseGB rates = new Step02_AddResponseGB(driver); 
	  for (int i=1; i<98; i++)
	  {
		  j = i + j++;
		  rates.resRates(String.valueOf(j), String.valueOf(j));
				break;
	  }
	  
	
	}
  @Test(priority=8)
	public void save_Form() throws IOException, InterruptedException  
	{
	  Step02_AddResponseGB save = new Step02_AddResponseGB(driver); 
	  save.saveForm();
	}*/
	
	@Test(priority=0)
	public void add_response() throws IOException, InterruptedException
	{

		Step02_AddResponseGB addresp = new Step02_AddResponseGB(driver);
			addresp.login("twoide002a@de.com","woi2cool");
			addresp.openRequest();
			addresp.alertcall();
			addresp.buttonClick();
			addresp.addAttachement();
			addresp.resDetails("fresp", "mresp", "lresp");
			addresp.resAttributeDetails();
			addresp.resRates("30","30");
			addresp.saveForm();
				//addresp.closing();
	}
	@Test(priority=1)
	public void add_response1() throws IOException, InterruptedException
	{
		
		Step02_AddResponseGB addresp1 = new Step02_AddResponseGB(driver);
				//addresp.nav();
		addresp1.login("twoigb001@gb.com","woi2cool");
		addresp1.openRequest();
		addresp1.alertcall();
		addresp1.buttonClick();
		addresp1.addAttachement();
		addresp1.resDetails("fresp1", "mresp1", "lresp1");
		addresp1.resAttributeDetails();
		addresp1.resRates("40","40");
		addresp1.saveForm();
				//addresp.closing();
	}
}

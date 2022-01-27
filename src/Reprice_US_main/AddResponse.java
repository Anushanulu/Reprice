
package Reprice_US_main;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Reprice_US.Step02_AddResponse;

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
		url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	



	// Test to add response
	/*@Test(priority=0)
	public void resp1_login() throws IOException, InterruptedException
	{

		Step02_AddResponse addresp = new Step02_AddResponse(driver); 
	    addresp.login("twoius001@us.ibm.com","woi4tst");
	}
	@Test(priority=1)
	public void resp1_search_request() throws InterruptedException 
	{

		Step02_AddResponse search = new Step02_AddResponse(driver); 
		search.openRequest();
		//search.waitForFormOverlayDisappear();
	}
	@Test(priority=2)
	public void resp1_alertmininmize() throws InterruptedException
	{
		Step02_AddResponse alertcall = new Step02_AddResponse(driver); 
		alertcall.alertcall();
	} 
	@Test(priority=3)
 	public void resp1_create_res() throws InterruptedException 
 	{

	  Step02_AddResponse btnclick = new Step02_AddResponse(driver);
	  //btnclick.waitForFormOverlayDisappear();
	  btnclick.buttonClick();
 	}
	 
	
	
  @Test(priority=4)
 	public void resp1_add_Attachement() 
 	{

	  Step02_AddResponse attachemnt = new Step02_AddResponse(driver); 
	  attachemnt.addAttachement();
 	}
  @Test(priority=5)
	public void resp1_fill_resdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponse resdetails = new Step02_AddResponse(driver); 
	  resdetails.resDetails("fresp", "mresp", "lresp");
	  //resdetails.resDetails();
	}
  @Test(priority=6)
	public void resp1_fill_resAttrdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponse resattrs = new Step02_AddResponse(driver); 
	  resattrs.resAttributeDetails();
	}
  @Test(priority=7)
	public void resp1_fill_ratesdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponse rates = new Step02_AddResponse(driver); 
	  rates.resRates("30","30");
	}
  @Test(priority=8)
	public void resp1_save_Form() throws IOException, InterruptedException  
	{
	  Step02_AddResponse save = new Step02_AddResponse(driver); 
	  save.saveForm();
	 // driver.close();
	}
  
  
  
  
//Test to add response2
	@Test(priority=9)
	public void resp2login() throws IOException, InterruptedException 
	{

		Step02_AddResponse addresp = new Step02_AddResponse(driver); 
	    addresp.login("marvel@ibm.com","csa2test");
	}
	@Test(priority=10)
	public void resp2_search_request() throws InterruptedException 
	{

		Step02_AddResponse search = new Step02_AddResponse(driver); 
		search.openRequest();
		//search.waitForFormOverlayDisappear();
	}
	@Test(priority=11)
	public void resp2_alertmininmize() throws InterruptedException
	{
		Step02_AddResponse alertcall = new Step02_AddResponse(driver); 
		alertcall.alertcall();
	} 
	@Test(priority=12)
	public void resp2_create_res() throws InterruptedException 
	{

	  Step02_AddResponse btnclick = new Step02_AddResponse(driver);
	  //btnclick.waitForFormOverlayDisappear();
	  btnclick.buttonClick();
	}
 @Test(priority=13)
	public void resp2_add_Attachement() 
	{

	  Step02_AddResponse attachemnt = new Step02_AddResponse(driver); 
	  attachemnt.addAttachement();
	}
 @Test(priority=14)
	public void resp2_fill_resdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponse resdetails = new Step02_AddResponse(driver); 
	  resdetails.resDetails("fresp1", "mresp1", "lresp1");
	  //resdetails.resDetails();
	}
 @Test(priority=15)
	public void resp2_fill_resAttrdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponse resattrs = new Step02_AddResponse(driver); 
	  resattrs.resAttributeDetails();
	}
 @Test(priority=16)
	public void resp2_fill_ratesdetails() throws IOException, InterruptedException  
	{
	  Step02_AddResponse rates = new Step02_AddResponse(driver); 
	  rates.resRates("40","40");
	}
 @Test(priority=17)
	public void resp2_save_Form() throws IOException, InterruptedException  
	{
	  Step02_AddResponse save = new Step02_AddResponse(driver); 
	  save.saveForm();
	//  driver.close();
	}*/
	@Test(priority=0)
	public void add_response() throws IOException, InterruptedException
	{

		Step02_AddResponse addresp = new Step02_AddResponse(driver);
			addresp.login("twoius001@us.ibm.com","woi4tst");
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
		
		Step02_AddResponse addresp = new Step02_AddResponse(driver);
				//addresp.nav();
		addresp.login("marvel@ibm.com","csa2test");
		addresp.openRequest();
		addresp.alertcall();
		addresp.buttonClick();
		addresp.addAttachement();
		addresp.resDetails("fresp1", "mresp1", "lresp1");
		addresp.resAttributeDetails();
		addresp.resRates("40","40");
		addresp.saveForm();
				//addresp.closing();
	}
}

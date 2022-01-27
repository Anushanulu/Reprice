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

import Reprice_GB.Step01_CreateRequest_GB;
import lib.Excel;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import lib.Excel;


public class CreateRequest_GB {
	
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

	  Step01_CreateRequest_GB login = new Step01_CreateRequest_GB(driver);
		login.login();
	}
//  @Test(priority=1)
//	public void switching_insta() 
//	{
//
//	  Step01_CreateRequest_GB insta = new Step01_CreateRequest_GB(driver);
//		insta.switch_instance();
//	}
  @Test(priority=2)
 	public void create_req() 
 	{

 	  Step01_CreateRequest_GB req = new Step01_CreateRequest_GB(driver);
		req.Create_New_Request();
 	}
  /*@Test(priority=3)
 	public void switch_cntry() 
 	{

 	  Step01_CreateRequest_GB cntry = new Step01_CreateRequest_GB(driver);
 	   cntry.switch_country();
 	}*/
  @Test(priority=4)
	public void skill_req() 
	{

	  Step01_CreateRequest_GB skillreq = new Step01_CreateRequest_GB(driver);
		skillreq.Skill_Request();
		
	}		
/*@Test(priority=5)
	public void chang_requestor() 
	{

	Step01_CreateRequest_GB chngreq = new Step01_CreateRequest_GB(driver);
	  chngreq.Change_Requestor();
		
	}*/	
@Test(priority=6)
	public void select_requestor() 
	{

	Step01_CreateRequest_GB selectreq = new Step01_CreateRequest_GB(driver);
	  selectreq.Select_Requestor();
		
	}
@Test(priority=7)
	public void select_jrss() 
	{

	Step01_CreateRequest_GB jrss = new Step01_CreateRequest_GB(driver);
		jrss.Select_JRSS();
		
	}
@Test(priority=8)
	public void req_details() 
	{

	Step01_CreateRequest_GB reqdetials = new Step01_CreateRequest_GB(driver);
	  reqdetials.Request_detailpage();
		
	}
@Test(priority=9)
	public void loc_details() 
	{

	Step01_CreateRequest_GB loc = new Step01_CreateRequest_GB(driver);
		loc.Skill_detailLocationpage();
		
	}
@Test(priority=10)
	public void alert_call() 
	{

	Step01_CreateRequest_GB call = new Step01_CreateRequest_GB(driver);
	   call.isAlertPresent();
		
	}
@Test(priority=11)
	public void rates_details() 
	{

	Step01_CreateRequest_GB rate = new Step01_CreateRequest_GB(driver);
	   rate.Skill_detail_skillpricepage();
		
	}
@Test(priority=12)
	public void sup_slection() throws InterruptedException 
	{

	Step01_CreateRequest_GB sup = new Step01_CreateRequest_GB(driver);
		sup.SupplierSelectionPage();
		
	}				

}

		
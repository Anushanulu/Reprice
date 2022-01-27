package Reprice_GB;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

public class Step03_Response2_Reprice {

	private WebDriver driver;
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet = "Login";

	// Login to application
	@FindBy(xpath = "//button[contains(text(), 'Log in')]")
	private WebElement login_btn;
	@FindBy(xpath = ".//*[@id='username']")
	private WebElement Username_box;
	@FindBy(xpath = ".//*[@id='continue-button']")
	private WebElement continue_btn;
	@FindBy(xpath = ".//*[@id='password']")
	private WebElement Password_Box;
	@FindBy(id = "signinbutton")
	private WebElement Signin_Button;

	// Search for a request
	@FindBy(xpath = ".//*[@name='search']")
	private WebElement Advance_search_tab;
	@FindBy(xpath = "//*[contains(@id,'ibm-label-')][1]/span/input")
	private WebElement Req_Num_field;
	@FindBy(xpath = ".//button[@class='bx--btn bx--btn--primary']")
	private WebElement Search_btn;
	@FindBy(xpath = " .//a[@class='ng-star-inserted']")
	private WebElement Request_Number_link;

	// Adding response details
	@FindBy(xpath = "//button[contains(text(), 'Feedback')]")
	private WebElement feedback;
	@FindBy(xpath = ".//*[@id='selectAll']")
	private WebElement chkbox;
	@FindBy(xpath = "//button[contains(text(), 'Add Response')]")
	private WebElement btn_Add_response;
	// @FindBy (xpath="//input[@id=�
	// hj-survey-lbl-1�]/parent::form/preceding-sibling::span") private
	// WebElement alertminimize;
	@FindBy(xpath = "//button[@class='_hj-OO1S1__styles__openStateToggle']")
	private WebElement alertminimize;
	// @FindBy (xpath
	// ="//*[contains(@id,'mat-expansion-panel-header-12')]/span[2]") private
	// WebElement attachment_arrow;
	@FindBy(xpath = "//span[@class='headerTitle' and contains(text(),'Attachments')]")
	private WebElement attachment_arrow;
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	private WebElement Save_btn;
	@FindBy(xpath = "//button[contains(text(), ' Add Response File ')]/following-sibling::input")
	private WebElement Resp_Attachment;
	@FindBy(xpath = "//span[@class='headerTitle' and contains(text(),'Response Details')]")
	private WebElement resdetails_arrow;
	@FindAll({ @FindBy(xpath = "//div[@class='mat-drawer-backdrop ng-star-inserted mat-drawer-shown']") })
	private List<WebElement> ResponseForm_OverLay;

	// Filling responser details
	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	private WebElement First_Name;
	@FindBy(xpath = "//input[@formcontrolname='middleName']")
	private WebElement Middle_Name;
	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	private WebElement LastName_Surname;

	@FindBy(id = "dobPickerOverlay")
	private WebElement DOB_Field;
	@FindBy(xpath = "//mat-calendar[contains(@id,'mat-datepicker')]/div/mat-month-view/table/tbody/tr[4]/td[3]")
	private WebElement DOB_InCalender;
	@FindBy(xpath = "//input[@id='citizenShip']")
	private WebElement Citizenship;
	// @FindBy (xpath =
	// "//*[@id='citizenShip']/div/div[2]/ibm-dropdown-list/ul/li") private
	// String Citizenship_list ;
	@FindBy(xpath = "//div[@class='bx--list-box__menu-item__option' and contains(text(), 'United Kingdom')]")
	private WebElement Citizenship_list;
	@FindBy(xpath = "//input[@id='noneOfAbove']")
	private WebElement none_chkbox;

	// Response attributes
	@FindBy(xpath = "//span[@class='headerTitle' and contains(text(),'Requirement Attributes')]")
	private WebElement resattrs_arrow;
	@FindBy(id = "mat-input-0")
	private WebElement Startdt_Field;
	// @FindBy (xpath=
	// "//div[contains(@id,'mat-datepicker')]/div/mat-month-view/table/tbody/tr[4]/td[3]")
	// private WebElement Startdt_Calender;
	@FindBy(xpath = "//*[@formcontrolname='expectedEndDate']")
	private WebElement Enddt_Field;
	// @FindBy (xpath=
	// "//*[@id='mat-datepicker']/div/mat-month-view/table/tbody/tr[4]/td[7]")
	// private WebElement enddt_Calender;
	@FindBy(xpath = "//mat-calendar[contains(@id,'mat-datepicker')]/div/mat-month-view/table/tbody/tr[2]/td[5]")
	private WebElement Startdt_Calender;
	@FindBy(xpath = "//mat-calendar[contains(@id,'mat-datepicker')]/div/mat-month-view/table/tbody/tr[4]/td[5]")
	private WebElement enddt_Calender;
	// @FindBy (xpath= "//*[@id='priceLevCd']") private WebElement skill_lvl;
	// @FindBy (xpath= "*[@id='priceLevCd']/div/ibm-dropdown-list/ul/li[1]")
	// private WebElement skill_lvl_drpdown;
	@FindBy(xpath = "//button[@class='bx--list-box__field']")
	private WebElement skill_lvl;
	@FindBy(xpath = "//div[@class='bx--list-box__menu-item__option' and contains(text(),'Band 6')]")
	private WebElement skill_lvl_drpdown;

	// Res rates
	@FindBy(xpath = "//span[@class='headerTitle' and contains(text(),'Response Pricing')]")
	private WebElement resrates_arrow;
	@FindBy(xpath = "//*[@formcontrolname='straightTimeBillRate']")
	private WebElement st_Rate;
	@FindBy(xpath = "//*[@formcontrolname='straightWages']")
	private WebElement st_Wage;
	@FindBy(xpath = "//*[@formcontrolname='overTimeBillRate']")
	private WebElement ot_Rate;

	// Submit response
	// @FindBy (xpath ="//*[contains(@id, 'checkBoxId-001-0')]") private
	// WebElement redy_submission_chkbox ;
	// @FindBy (xpath =
	// "//input[@id='checkBoxId-001-0']/parent::label/span[@class='checkmark']")
	// private WebElement redy_submission_chkbox ;
	@FindBy(xpath = "//input[@id='selectAll']/parent::label[@class='container']/span[@class='checkmark']")
	private WebElement SelectAll_Checkbox;
	// @FindAll({@FindBy (xpath ="//*[contains(@id, 'checkBoxId')]")}) private
	// List<WebElement> redy_submission_chkbox ;
	@FindBy(xpath = "//button[contains(text(),'Confirm submit')]")
	private WebElement confirm_submit;
	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	private WebElement Submit_btn;

	// Reprice
	@FindBy(xpath = "//td[@class='rowCell']/a")
	private WebElement skilllink_toReprice;

	@FindBy(xpath = "//div[@class='button-div-footer']//button[@class='bx--btn bx--btn--primary ng-star-inserted'][normalize-space()='Reprice']")
	private WebElement Reprice_btn;

	@FindBy(xpath = "//span[contains(text(),'Lowest supplier rate :')]/parent::div/following-sibling::div//span[@class='content-text']")
	private WebElement Lowest_Sup_Rate_val;
	@FindBy(xpath = "//span[contains(text(),'My lowest submitted rate :')]/parent::div/following-sibling::div//span[@class='content-text']")
	private WebElement My_Lowest_Sub_Rate_val;

	// Initialize the web elements
	public Step03_Response2_Reprice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// login
	public void login(String un1, String pwd1) throws IOException, InterruptedException {

		WebDriverWait wait1 = new WebDriverWait(driver, 180);
		wait1.until(ExpectedConditions.visibilityOf(login_btn));

		login_btn.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 180);
		wait2.until(ExpectedConditions.visibilityOf(Username_box));
		Username_box.clear();
		// Username_box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 5, 0));
		Username_box.sendKeys(un1);
		continue_btn.click();
		Thread.sleep(1000);
		Password_Box.clear();
		// Password_Box.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 5, 1));
		Password_Box.sendKeys(pwd1);

		Signin_Button.click();

	}

	public void openRequest() throws InterruptedException {

		WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Advance_search_tab));

		Advance_search_tab.click();

		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOf(Req_Num_field));
		Req_Num_field.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 2, 15));

		Search_btn.click();

		WebDriverWait wait5 = new WebDriverWait(driver, 160);
		wait5.until(ExpectedConditions.visibilityOf(Request_Number_link));

		/* code to capture screenshot */
		// Shutterbug.shootPage(driver,
		// ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project
		// csa\\Practice Automation\\NPrice\\UK");

		Request_Number_link.click();
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(btn_Add_response));
		// btn_Add_response.click();
		// waitForFormOverlayDisappear();
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
				.save(System.getProperty("user.dir") + "\\test-output\\snaps\\UK\\");

		System.out.println("Lowest Supplier Rate is:" + Lowest_Sup_Rate_val.getText());
		System.out.println("My Lowest Submitted Rate is:" + My_Lowest_Sub_Rate_val.getText());
	}

	public void RepriceSkill() {
		WebDriverWait wait19 = new WebDriverWait(driver, 160);
		wait19.until(ExpectedConditions.visibilityOf(skilllink_toReprice));
		skilllink_toReprice.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", resrates_arrow);
		WebDriverWait wait15 = new WebDriverWait(driver, 160);
		wait15.until(ExpectedConditions.visibilityOf(st_Rate));
		st_Rate.clear();
		st_Rate.sendKeys("25");
		WebDriverWait wait16 = new WebDriverWait(driver, 160);
		wait16.until(ExpectedConditions.visibilityOf(st_Wage));
		st_Wage.clear();
		st_Wage.sendKeys("25");

		/*WebDriverWait wait20 = new WebDriverWait(driver, 160);
		wait20.until(ExpectedConditions.visibilityOf(ot_Rate));
		ot_Rate.clear();
		ot_Rate.sendKeys("15");*/
		WebDriverWait wait21 = new WebDriverWait(driver, 160);
		wait21.until(ExpectedConditions.visibilityOf(Reprice_btn));
		Reprice_btn.click();
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
				.save(System.getProperty("user.dir") + "\\test-output\\snaps\\US\\");

		System.out.println("Lowest Supplier Rate is:" + Lowest_Sup_Rate_val.getText());
		System.out.println("My Lowest Submitted Rate is:" + My_Lowest_Sub_Rate_val.getText());

	}

	public void alertcall() throws InterruptedException {
		try {
			// Thread.sleep(20000);
			// WebDriverWait wait06 = new WebDriverWait(driver, 600);
			// wait06.until(ExpectedConditions.visibilityOf(alertminimize));

			alertminimize.click();
			// JavascriptExecutor js = (JavascriptExecutor)driver;
			// js.executeScript("arguments[0].click();", alertminimize);

		} // try
		catch (NoAlertPresentException Ex) {
			System.out.println("there is no popup");
		} // catch
	}

	public void waitForFormOverlayDisappear() throws InterruptedException {
		int count = 0;
		while (ResponseForm_OverLay.size() != 0 && count < 20) {
			Thread.sleep(1000);
			count++;
		}
	}

}

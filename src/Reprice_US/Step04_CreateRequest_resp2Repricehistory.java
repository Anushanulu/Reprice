package Reprice_US;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

//import generics.Screenshots;

public class Step04_CreateRequest_resp2Repricehistory {

	private WebDriver driver;
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet = "Login";

	// OTP Screen code
	// @FindBy (xpath = ".//a[@class='delivery method-link' and @type='totp']")
	// private WebElement Totp_Link;
	@FindBy(xpath = ".//div[@id='totp_item']")
	private WebElement Totp_Link;
	// @FindBy(id = "otp") private WebElement passcodeBox;
	// @FindBy(id = "btn_submit") private WebElement SubmitPasscode;

	@FindBy(xpath = "//span[@id='credentialSignin']")
	private WebElement cred_login;
	// @FindBy ( xpath= "//input[@id='otp-input']") private WebElement otp_box;
	// @FindBy(id = "submit_btn") private WebElement otp_submit_btn;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement login_username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement login_password;
	@FindBy(id = "login-button")
	private WebElement login_Button;
	@FindBy(id = "otp-input")
	private WebElement passcodeBox;
	@FindBy(id = "submit_btn")
	private WebElement SubmitPasscode;
	@FindBy(xpath = "//label[@id='totp_label']")
	private WebElement Authenticator_App_option;
	@FindBy(xpath = "//input[@id='newTotp-otp-input']")
	private WebElement EnterAccessCode_Box;
	@FindBy(xpath = "//button[contains(text(),'Next: Verify')]")
	private WebElement Verify_Button;
	@FindBy(xpath = "//input[@id='otp-input']")
	private WebElement OTP_TextBox;
	@FindBy(xpath = "//button[@id='submit_btn']")
	private WebElement OTP_Submit_Button;

	@FindBy(xpath = ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ")
	private WebElement RequestCreated;
	@FindBy(xpath = ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ")
	private WebElement RequestCreated_Header;

	@FindBy(css = ".beeheard-overlay-close")
	private WebElement popup_close;

	
	//Search request
	@FindBy(xpath = ".//*[@id='left-nav']/div/a[8]")
	private WebElement LHS_Search_tab;
	@FindBy(id = "FLD_REQ_NUM_SEARCH")
	private WebElement Request_Num_Fld;
	@FindBy(name = "GO")
	private WebElement Search_GO_btn;
	@FindBy(xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a")
	private WebElement Request_Num_link;

	@FindBy(xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a")
	private WebElement Requested_Skill;

	//Reprice history
	@FindBy(xpath = "//*[@id='nonFinalCandForm']/table[1]/tbody/tr[2]/td[3]/div[2]/a")
	private WebElement RepriceHistory_Resp2;
	@FindBy(xpath = "//*[@id='nonFinalCandForm']/table[1]/tbody/tr[3]/td[3]/div[2]/a")
	private WebElement RepriceHistory_Resp1;

	
	// Initialize the web elements
	public Step04_CreateRequest_resp2Repricehistory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Function to login to the application
	public void login() throws IOException, InterruptedException {

		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(cred_login));
		cred_login.click();

		// new login changes
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(login_Button));
		wait01.until(ExpectedConditions.elementToBeClickable(login_Button));
		login_username.clear();
		login_username.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 1, 0));
		Thread.sleep(1000);
		login_password.clear();
		login_password.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 1, 1));

		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
				.save(System.getProperty("user.dir") + "\\test-output\\snaps\\US\\");
		login_Button.click();

		try {
			Totp_Link.click();
			String otpKeyStr = "WEIBVLBVWMVAZZPZ";// csatestus1@c25a0161.toronto.ca.ibm.com
			Totp totp = new Totp(otpKeyStr);
			String twoFactorCode = totp.now();

			OTP_TextBox.sendKeys(twoFactorCode);
			System.out.println("value fetched from box= " + OTP_TextBox.getAttribute("value"));

			OTP_Submit_Button.click();
			System.out.println("clicked on OTP submit button");
		} catch (Exception e) {
			System.out.println("no OTP screen");
			// e.printStackTrace();
		}
	}

	public void SearchRequest() {
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(LHS_Search_tab));

		LHS_Search_tab.click();

		WebDriverWait wait03 = new WebDriverWait(driver, 160);
		wait03.until(ExpectedConditions.visibilityOf(Request_Num_Fld));

		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		Search_GO_btn.click();

		WebDriverWait wait04 = new WebDriverWait(driver, 160);
		wait04.until(ExpectedConditions.visibilityOf(Request_Num_link));

		Request_Num_link.click();
	}

	public void RepriceHistoryResp2() throws InterruptedException {
		WebDriverWait wait05 = new WebDriverWait(driver, 160);
		wait05.until(ExpectedConditions.visibilityOf(Requested_Skill));

		Requested_Skill.click();

		WebDriverWait wait06 = new WebDriverWait(driver, 160);
		wait06.until(ExpectedConditions.visibilityOf(RepriceHistory_Resp2));
		RepriceHistory_Resp2.click();

		Thread.sleep(1000);
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
				.save(System.getProperty("user.dir") + "\\test-output\\snaps\\US\\");

	}

	public static boolean isloadComplete(WebDriver driver) {
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
				|| ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
}
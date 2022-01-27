package Reprice_GB;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step04_CreateRequest_resp2RepriceHistory {

	private WebDriver driver;
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet = "Login";

	// Define the element
	@FindBy(xpath = ".//*[@id='content-main']/p[2]/a")
	private WebElement loginToContractor_Link;
	@FindBy(id = "btn_signin")
	private WebElement Signin_Button;
	@FindBy(xpath = ".//*[@id='desktop']")
	private WebElement Username_Box;
	@FindBy(xpath = ".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]")
	private WebElement Password_Box;
	@FindBy(xpath = ".//*[@id='content-main']/form[1]/div/span/input")
	private WebElement Create_New_Request;

	// New login code
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
	@FindBy(xpath = ".//div[@id='totp_item']")
	private WebElement Totp_Link;
	@FindBy(xpath = "//input[@id='otp-input']")
	private WebElement OTP_TextBox;
	@FindBy(xpath = "//button[@id='submit_btn']")
	private WebElement OTP_Submit_Button;

	// Search request
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

	// Reprice history
	@FindBy(xpath = "//*[@id='nonFinalCandForm']/table[1]/tbody/tr[2]/td[3]/div[2]/a")
	private WebElement RepriceHistory_Resp2;
	@FindBy(xpath = "//*[@id='nonFinalCandForm']/table[1]/tbody/tr[3]/td[3]/div[2]/a")
	private WebElement RepriceHistory_Resp1;

	// Initialize the web elements
	public Step04_CreateRequest_resp2RepriceHistory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Function to login to the application
	// Click on the link again as workaround
	public void login() throws IOException, InterruptedException {

		// WebDriverWait wait = new WebDriverWait(driver, 180);
		// wait.until(ExpectedConditions.visibilityOf(loginToContractor_Link));
		//
		// loginToContractor_Link.click();
		WebDriverWait wait00 = new WebDriverWait(driver, 180);
		wait00.until(ExpectedConditions.visibilityOf(cred_login));
		cred_login.click();

		// new login changes
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(login_Button));
		wait01.until(ExpectedConditions.elementToBeClickable(login_Button));
		login_username.clear();
		login_username.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 7, 0));
		Thread.sleep(1000);
		login_password.clear();
		login_password.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 7, 1));

		// Shutterbug.shootPage(driver,
		// ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") +
		// "\\src\\test\\resources\\Screens\\GB");
		login_Button.click();
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 50);
			wait1.until(ExpectedConditions.visibilityOf(Authenticator_App_option));

			Authenticator_App_option.click();
			System.out.println("Authenticator option is selected for authentication");
		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println("Page to select Authenticator app option is not displayed");
			e.printStackTrace();
		}

		try {

			String otpKeyStr = "3E7WO4EQTMXUPMPG";// csatestgb1@c25a0161.toronto.ca.ibm.com
			Totp totp = new Totp(otpKeyStr);
			String twoFactorCode = totp.now();

			OTP_TextBox.sendKeys(twoFactorCode);
			System.out.println("value fetched from box= " + OTP_TextBox.getAttribute("value"));

			OTP_Submit_Button.click();
			System.out.println("clicked on OTP submit button");
			WebDriverWait wait02 = new WebDriverWait(driver, 100);
			wait02.until(ExpectedConditions.visibilityOf(Create_New_Request));
			System.out.println("Title of page= " + driver.getTitle());
		} catch (Exception e) {
			System.out.println("no OTP screen");
			e.printStackTrace();
			WebDriverWait wait02 = new WebDriverWait(driver, 100);
			wait02.until(ExpectedConditions.visibilityOf(Create_New_Request));
			System.out.println("Title of page= " + driver.getTitle());
		}

	}

	public void SearchRequest() {
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(LHS_Search_tab));

		LHS_Search_tab.click();

		WebDriverWait wait03 = new WebDriverWait(driver, 160);
		wait03.until(ExpectedConditions.visibilityOf(Request_Num_Fld));

		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 2, 15));
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

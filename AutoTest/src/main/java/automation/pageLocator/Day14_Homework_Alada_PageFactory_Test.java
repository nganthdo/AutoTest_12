package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_Homework_Alada_PageFactory_Test {

	private WebDriver driver;

	public Day14_Homework_Alada_PageFactory_Test(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}

	// Đăng Ký menu
	@FindBy(xpath = "//a[text()='Đăng Ký']")
	WebElement menuRegister;

	// Đăng Ký form
	@FindBy(xpath = "//input[@id='txtFirstname']")
	WebElement txtFullName;
	@FindBy(xpath = "//input[@id='txtEmail']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='txtCEmail']")
	WebElement txtReEmail;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='txtCPassword']")
	WebElement txtRePassword;
	@FindBy(xpath = "//input[@id='txtPhone']")
	WebElement txtPhone;
	@FindBy(xpath = "//input[@id='chkRight']")
	WebElement chbAgree;
	@FindBy(xpath = "//button[contains(text(),'ĐĂNG KÝ') and @type='submit']")
	WebElement btnRegister;

	// Chỉnh sửa thông tin
	
	@FindBy(xpath = "//div[@class='avatar2']/child::i") WebElement menuAccount;
	
	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
	WebElement menuEditAccount;
	
	@FindBy(xpath = "//div[text()='Thông tin đăng nhập']") WebElement labelThongTinDangNhap;
	
	@FindBy(xpath = "//input[@id='txtpassword']")
	WebElement txtCurrentPassword;
	@FindBy(xpath = "//input[@id='txtnewpass']")
	WebElement txtNewPass;
	@FindBy(xpath = "//input[@id='txtrenewpass']")
	WebElement txtReNewPass;
	@FindBy(xpath = "//button[contains(text(),'Lưu mật khẩu mới')]")
	WebElement btnSaveInfo;

	public void RegisterFunction(String fullname, String email, String reEmail, String password, String rePassword,
			String phone) {
		menuRegister.click();

		txtFullName.clear();
		txtFullName.sendKeys(fullname);

		txtEmail.clear();
		txtEmail.sendKeys(email);

		txtReEmail.clear();
		txtReEmail.sendKeys(reEmail);

		txtPassword.clear();
		txtPassword.sendKeys(password);

		txtRePassword.clear();
		txtRePassword.sendKeys(rePassword);

		txtPhone.clear();
		txtPhone.sendKeys(phone);

		if (chbAgree.isSelected() == false) {
			chbAgree.click();
		}

		btnRegister.click();

	}

	public void ChangePasswordFunction(String curPass, String newPass) {

		menuAccount.click();
		menuEditAccount.click();
		
		// scroll down to "Thông tin đăng nhập" section
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", labelThongTinDangNhap);
		
		txtCurrentPassword.clear();
		txtCurrentPassword.sendKeys(curPass);

		txtNewPass.clear();
		txtNewPass.sendKeys(newPass);

		txtReNewPass.clear();
		txtReNewPass.sendKeys(newPass);

		btnSaveInfo.click();
	}

}

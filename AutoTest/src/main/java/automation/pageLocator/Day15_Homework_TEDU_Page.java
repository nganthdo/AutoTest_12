package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day15_Homework_TEDU_Page {

	private WebDriver driver;

	public Day15_Homework_TEDU_Page(WebDriver _driver) {

		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}

	// Login Form
	@FindBy(id = "UserName")
	WebElement textUsername;
	@FindBy(id = "Password")
	WebElement textPassword;
	@FindBy(xpath = "//button[text()='Đăng nhập']")
	WebElement btnLogin;

	@FindBy(id = "onesignal-slidedown-cancel-button")
	WebElement btnCancelSubscription;

	@FindBy(id = "my_account")
	WebElement menuMyAccount;
	@FindBy(xpath = "//a[@title='Đổi mật khẩu']")
	WebElement menuChangePassword;

	// Change Password form
	@FindBy(xpath = "//input[@id='OldPassword']")
	WebElement textOldPassword;
	@FindBy(id = "NewPassword")
	WebElement textNewPassword;
	@FindBy(id = "ConfirmNewPassword")
	WebElement textConfirmNewPassword;

	@FindBy(xpath = "//input[@value='Cập nhật']")
	WebElement btnUpdatePass;
	
	// Search Course
	@FindBy(name="keyword") WebElement textKeywordSearch;
	@FindBy(xpath = "//button[@class='button-search btn btn-primary']") WebElement btnSearch;
	
	

	public void LoginFunction(String username, String password) {

		btnCancelSubscription.click();
		textUsername.clear();
		textUsername.sendKeys(username);

		textPassword.clear();
		textPassword.sendKeys(password);

		btnLogin.click();

	}

	public void ChangePasswordFunction(String oldPass, String newPass) throws InterruptedException {

		// btnCancelSubscription.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", menuMyAccount);

		js.executeScript("arguments[0].click();", menuChangePassword);
		Thread.sleep(3000);

		textOldPassword.sendKeys(oldPass);
		textNewPassword.sendKeys(newPass);
		textConfirmNewPassword.sendKeys(newPass);

		btnUpdatePass.click();
	}
	
	public void SearchCourseFunction(String keyword) {
		
		
		textKeywordSearch.clear();
		textKeywordSearch.sendKeys(keyword);
		
		btnSearch.click();
	}
	
	

}

package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory_Practice_Day14 {
	private WebDriver driver;
	
	// using FindBy annotation 
	@FindBy(id="txtLoginUsername") WebElement textEmail;
	@FindBy(id="txtLoginPassword") WebElement textPassword;
	@FindBy(xpath = "//button[text()='ĐĂNG NHẬP' and @type='submit']") WebElement btnLogin;
	
	@FindBy(xpath = "//div[@class='avatar2']/child::i") WebElement menuLogout;
	@FindBy(xpath = "//a[text() = 'Thoát']") WebElement btnLogout;
	
	public LoginPageFactory_Practice_Day14(WebDriver _driver) {

		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LoginFunction(String email, String password) {
		textEmail.clear();
		textEmail.sendKeys(email);
		textPassword.clear();
		textPassword.sendKeys(password);
		btnLogin.click();
	}
	public void LogoutFunction() {
		menuLogout.click();
		btnLogout.click();
		
		
	}

}
 
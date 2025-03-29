package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Login_Page extends CommonBase {

	private WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void loginFunction(String email, String password) {
		type(By.id("email"), email);
		type(By.id("password"), password);
		click(By.xpath("//button[text()='Đăng nhập']"));
	}

}

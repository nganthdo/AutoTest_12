package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alada_LoginPage {
	private WebDriver driver;

	public Alada_LoginPage(WebDriver _driver) {

		this.driver = _driver;
	}

	public void LoginFunction(String email, String password) {
		WebElement textEmail = driver.findElement(By.id("txtLoginUsername"));
		if (textEmail.isDisplayed()) {
			// clear default data in textbox
			textEmail.clear();
			textEmail.sendKeys(email);
		}

		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		if (textPassword.isDisplayed()) {
			// clear default data in textbox
			textPassword.clear();
			textPassword.sendKeys(password);
		}

		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
		if (btnSignin.isDisplayed()) {
			btnSignin.click();
		}

	}

}

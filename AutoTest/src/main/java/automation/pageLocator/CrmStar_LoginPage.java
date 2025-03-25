package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmStar_LoginPage {

	private WebDriver driver;
	

	public CrmStar_LoginPage(WebDriver _driver) {

		this.driver = _driver;
	}

	public void LoginFunction(String email, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		txtEmail.clear();
		txtEmail.sendKeys(email); 
		WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

		txtPassword.clear();
		txtPassword.sendKeys(password);

		WebElement btnSignin = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Đăng nhập']")));

		btnSignin.click();

	}
	
	

}

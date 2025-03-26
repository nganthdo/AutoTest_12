package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Alada_PageFactory_Homework_Day14;
import automation.pageLocator.LoginPageFactory_Practice_Day14;

public class Alada_PageFactory_SignupTest_Homework_Day14 extends CommonBase {

	String textEmail = "emma003@test.com";
	String textPassword = "123456";
	String textNewPass = "1234567";

	@BeforeMethod
	public void openBrowserTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_ALADA);

	}

	@Test(priority = 1)
	public void RegisterSuccessfully() {

		// 1. Signup a new account
		Alada_PageFactory_Homework_Day14 signup = new Alada_PageFactory_Homework_Day14(driver);
		signup.RegisterFunction("Emma002 ", textEmail, textEmail, textPassword, textPassword, "0901234567");

		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
	}

	// 2. Change password
	@Test(priority = 2)
	public void ChangePassword() {
		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction(textEmail, textPassword);
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());

		Alada_PageFactory_Homework_Day14 changePass = new Alada_PageFactory_Homework_Day14(driver);
		changePass.ChangePasswordFunction(textPassword, textNewPass, textNewPass);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			String alertMsg = alert.getText();
			System.out.println(alertMsg);

			assertTrue(alertMsg.equals("Cập nhật mật khẩu mới thành công!"));

			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert not found");
		}
	}

	// 3. Login with new password
	@Test(priority = 3)
	public void LoginSuccessfully_NewPass() {
		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction(textEmail, textNewPass);
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

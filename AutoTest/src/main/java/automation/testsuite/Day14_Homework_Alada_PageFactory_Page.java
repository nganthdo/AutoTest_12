package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.devtools.v129.storage.model.StorageBucketsDurability;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day14_Homework_Alada_PageFactory_Test;
import automation.pageLocator.LoginPageFactory_Practice_Day14;

public class Day14_Homework_Alada_PageFactory_Page extends CommonBase {

	String textEmail = "emma0016@mailinator.com";
	String textPassword = "123456";
	String textNewPass = "1234567";

	@BeforeMethod
	public void openBrowserTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_ALADA);

	}

	@Test(priority = 1)
	public void RegisterSuccessfully() {

		// 1. Signup a new account
		Day14_Homework_Alada_PageFactory_Test signup = new Day14_Homework_Alada_PageFactory_Test(driver);
		signup.RegisterFunction("Emma0016", textEmail, textEmail, textPassword, textPassword, "0901234567");

		isElementDisplay(By.xpath("//a[text()='Khóa học của tôi']"));
	}
	
	public void LoginSuccessfully() {
		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction(textEmail, textPassword);
		isElementDisplay(By.xpath("//a[text()='Khóa học của tôi']"));
	}

	// 2. Change password
	@Test(priority = 2)
	public void ChangePassword() {
		
		LoginSuccessfully();

		Day14_Homework_Alada_PageFactory_Test changePass = new Day14_Homework_Alada_PageFactory_Test(driver);
		changePass.ChangePasswordFunction(textPassword, textNewPass);

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
		isElementDisplay(By.xpath("//a[text()='Khóa học của tôi']"));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		
	}

}

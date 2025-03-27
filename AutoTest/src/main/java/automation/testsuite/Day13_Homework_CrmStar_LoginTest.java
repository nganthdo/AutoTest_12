package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.CrmStar_LoginPage;

public class Day13_Homework_CrmStar_LoginTest extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_CRMSTAR);
	}

	// login successfully
	@Test(priority = 1)
	public void LoginSuccessfully() {
		CrmStar_LoginPage login = new CrmStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");

		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}

	// failed login with incorrect email
	@Test(priority = 2)
	public void LoginFail_IncorrectEmail() {
		CrmStar_LoginPage login = new CrmStar_LoginPage(driver);
		login.LoginFunction("admin123@gmail.com", "12345678");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement warningMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class = 'fl-message' and contains(text(),'Email hoặc mật khẩu không đúng')]")));

		assertTrue(warningMsg.isDisplayed());
	}
	
	// failed login with incorrect password
	@Test
	public void LoginFail_IncorrectPassword() {
		CrmStar_LoginPage login = new CrmStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "123456780");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement warningMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class = 'fl-message' and contains(text(),'Email hoặc mật khẩu không đúng')]")));

		assertTrue(warningMsg.isDisplayed());
	}
	
	// failed login with incorrect email & password
	@Test
	public void LoginFail_IncorrectEmailPassword() {
		CrmStar_LoginPage login = new CrmStar_LoginPage(driver);
		login.LoginFunction("admin123@gmail.com", "123456780");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement warningMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class = 'fl-message' and contains(text(),'Email hoặc mật khẩu không đúng')]")));

		assertTrue(warningMsg.isDisplayed());
	}
	
	
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPageFactory_Practice_Day14;

public class Alada_LoginTest_PageFactory_Day14 extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_ALADA);
	}

	@Test(priority = 1)
	public void LoginSuccessfully() {
		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction("demoemail@gmail.com", "123456");

		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
	}

	@Test(priority = 2)
	public void LoginFail_IncorrectPassword() {
		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction("demoemail@gmail.com", "1234562");

		assertTrue(driver.findElement(By.xpath("//p[text() = 'Mật khẩu sai.']")).isDisplayed());
	}

	@Test(priority = 3)
	public void LoginFail_IncorrectEmail() {
		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction("demo1email@gmail.com", "123456");

		// Error message is displayed
		assertTrue(driver.findElement(By.xpath("//p[text() = 'Email này chưa được đăng ký.']")).isDisplayed());
	}

	@Test(priority = 4)
	public void LogoutSuccessfully() {

		LoginPageFactory_Practice_Day14 login = new LoginPageFactory_Practice_Day14(driver);
		login.LoginFunction("demoemail@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());

		LoginPageFactory_Practice_Day14 logout = new LoginPageFactory_Practice_Day14(driver);
		logout.LogoutFunction();

		assertTrue(driver.findElement(By.xpath("//a[text()='Đăng Nhập']")).isDisplayed());
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}

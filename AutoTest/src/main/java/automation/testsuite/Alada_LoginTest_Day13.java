package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Alada_LoginPage;

public class Alada_LoginTest_Day13 extends CommonBase {
	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser(CT_PageURL.URL_ALADA);
	}

	@Test
	public void LoginSuccessfully() {
		Alada_LoginPage loginPage = new Alada_LoginPage(driver);
		loginPage.LoginFunction("ngan.thdo@gmail.com", "Aa123@");

		// Assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
	}

	@Test
	public void LoginFail_IncorrectPassword() {
		Alada_LoginPage loginPage = new Alada_LoginPage(driver);
		loginPage.LoginFunction("ngan.thdo@gmail.com", "1234567");

		// Error message is displayed
		assertTrue(driver.findElement(By.xpath("//p[text() = 'Mật khẩu sai.']")).isDisplayed());
	}

	@Test
	public void LoginFail_IncorrectEmail() {
		Alada_LoginPage loginPage = new Alada_LoginPage(driver);
		loginPage.LoginFunction("nganthdo@gmail.com", "123456");

		// Error message is displayed
		assertTrue(driver.findElement(By.xpath("//p[text() = 'Email này chưa được đăng ký.']")).isDisplayed());
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.CrmStar_LoginPage;
import automation.pageLocator.CrmStar_LogoutPage;

public class Day13_Homework_CrmStar_LogoutTest extends CommonBase {
	@BeforeMethod
	public void openBrowserTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_CRMSTAR);
	}

	@Test
	public void LogoutSuccessfully() {
		CrmStar_LoginPage login = new CrmStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());

		CrmStar_LogoutPage logout = new CrmStar_LogoutPage(driver);
		logout.LogoutFunction();
		
		assertTrue(driver.findElement(By.xpath("//h4[text() = 'Đăng nhập']")).isDisplayed());
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

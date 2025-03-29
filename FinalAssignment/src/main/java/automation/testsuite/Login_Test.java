package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Login_Page;

public class Login_Test extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CRMSTAR);

	}

	// Login successfully
	@Test(priority = 1)
	public void LoginSuccessfully() {

		Login_Page login = new Login_Page(driver);
		login.loginFunction("admin@gmail.com", "12345678");
		assertTrue(isElementDisplay(By.xpath("//div[contains(text(), 'Đăng nhập thành công')]")));
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

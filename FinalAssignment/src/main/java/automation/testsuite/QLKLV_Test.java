package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Login_Page;
import automation.pageLocator.QLKLV_Page;

public class QLKLV_Test extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CRMSTAR);

	}

	// search KLV
	public String searchKLV(String maKV) {
		QLKLV_Page crm = new QLKLV_Page(driver);
		crm.searchKVLVFunction(maKV);
		WebElement value = driver.findElement(By.xpath("//td[@class='code-work-area']"));
		return value.getText();
	}

	// add KLV successfully
	@Test(priority = 1)
	public void addKLVSuccessfully() {

		Login_Page login = new Login_Page(driver);
		login.loginFunction("admin@gmail.com", "12345678");
		assertTrue(isElementDisplay(By.xpath("//div[contains(text(), 'Đăng nhập thành công')]")));

		QLKLV_Page crm = new QLKLV_Page(driver);

		String maKV;
		String TenKV;
		do {
			maKV = crm.randomDataFunction();
			TenKV = "NgKv" + maKV;
			System.out.println("Mã KV: " + maKV);
			crm.addKVLVFunction(maKV, TenKV);
			
		} while (isElementDisplay(By.xpath("//span[contains(text(),'Mã khu vực đã tồn tại')]")));
		crm.confirm_AddKVLVFunction();

		assertTrue(isElementDisplay(By.xpath("//div[contains(text(), 'Thêm mới khu vực làm việc thành công')]")));

		String actualResult = searchKLV(maKV);
		assertEquals(actualResult, maKV);

	}

	// add KLV unsuccessfully (missing required fields)
	@Test(priority = 2)
	public void addKLVUnsuccessfully_MissingRequiredFields() {

		Login_Page login = new Login_Page(driver);
		login.loginFunction("admin@gmail.com", "12345678");
		assertTrue(isElementDisplay(By.xpath("//div[contains(text(), 'Đăng nhập thành công')]")));

		QLKLV_Page crm = new QLKLV_Page(driver);

		crm.addKVLVFunction("", "");
		assertTrue(isElementDisplay(
				By.xpath("//div[contains(text(),'Không được để trống trường này') and @id='workarea_validate']")));
		assertTrue(isElementDisplay(
				By.xpath("//div[contains(text(),'Không được để trống trường này') and @id='name_validate']")));

	}

	// add KLV unsuccessfully (invalid data)
	@Test(priority = 3)
	public void addKLVUnsuccessfully_InvalidData() {

		Login_Page login = new Login_Page(driver);
		login.loginFunction("admin@gmail.com", "12345678");
		assertTrue(isElementDisplay(By.xpath("//div[contains(text(), 'Đăng nhập thành công')]")));

		QLKLV_Page crm = new QLKLV_Page(driver);

		String[] invalidData = { "Ng Kv", "Ng@Kv" };

		for (String string : invalidData) {
			String maKV = string + crm.randomDataFunction();
			String TenKV = string + maKV;

			System.out.println("Mã KV: " + maKV);

			crm.addKVLVFunction(maKV, TenKV);

			switch (string) {
			case "Ng Kv":
				assertTrue(isElementDisplay(By.xpath(
						"//div[contains(text(),'Dữ liệu nhập vào sai định dạng') and @id='workarea_validate']")));
				break;

			case "Ng@Kv":
				assertTrue(isElementDisplay(By.xpath(
						"//div[contains(text(),'Dữ liệu nhập vào sai định dạng') and @id='workarea_validate']")));
				assertTrue(isElementDisplay(
						By.xpath("//div[contains(text(),'Dữ liệu nhập vào sai định dạng') and @id='name_validate']")));
				break;
			default:
				break;
			}

		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

import automation.pageLocator.Day16_Homework_01__CrmStar_QLKV_Page;

public class Day16_Homework_01__CrmStar_QLKV_Test extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CRMSTAR);

	}

	// case 1: Login successfully
	@Test(priority = 1)
	public void LoginSuccessfully() {

		Day16_Homework_01__CrmStar_QLKV_Page login = new Day16_Homework_01__CrmStar_QLKV_Page(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		isElementDisplay(By.xpath("//div[contains(text(), 'Đăng nhập thành công')]"));
	}

	public String searchKLV(String maKV) {
		Day16_Homework_01__CrmStar_QLKV_Page crm = new Day16_Homework_01__CrmStar_QLKV_Page(driver);
		crm.searchKVLVFunction(maKV);
		WebElement value = driver.findElement(By.xpath("//td[@class='code-work-area']"));
		return value.getText();
	}

	// case 2: add KLV successfully
	@Test(priority = 2)
	public void addKLVSuccessfully() {
		LoginSuccessfully();

		Day16_Homework_01__CrmStar_QLKV_Page crm = new Day16_Homework_01__CrmStar_QLKV_Page(driver);

		String maKV = crm.randomDataFunction();
		String TenKV = "NgKv" + maKV;
		System.out.println("Mã KV: " + maKV);

		crm.addKVLVFunction(maKV, TenKV);
		crm.confirm_AddKVLVFunction();
		isElementDisplay(By.xpath("//div[contains(text(), 'Thêm mới khu vực làm việc thành công')]"));

		String actualResult = searchKLV(maKV);
		assertEquals(actualResult, maKV);

	}

	// case 3: remove KLV (case 2) successfully
	@Test(priority = 3)
	public void removeKLVSuccessfully() {
		addKLVSuccessfully();
		Day16_Homework_01__CrmStar_QLKV_Page crm = new Day16_Homework_01__CrmStar_QLKV_Page(driver);
		crm.removeKVLVFunction();
		isElementDisplay(By.xpath("//div[contains(text(), 'Xóa khu vực làm việc thành công')]"));

	}

	// case 4: add KLV unsuccessfully - input "MaKV" with white space
	@Test(priority = 4)
	public void addKLV_Unsuccessfully() {
		LoginSuccessfully();
		Day16_Homework_01__CrmStar_QLKV_Page crm = new Day16_Homework_01__CrmStar_QLKV_Page(driver);

		String maKV = "Ng Kv " + crm.randomDataFunction();
		String TenKV = "NgKv" + maKV;
		System.out.println("Mã KV: " + maKV);

		crm.addKVLVFunction(maKV, TenKV);
		isElementDisplay(By.xpath("//div[contains(text(), 'Dữ liệu nhập vào sai định dạng')]"));

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

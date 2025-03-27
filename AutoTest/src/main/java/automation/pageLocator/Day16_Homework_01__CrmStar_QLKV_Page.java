package automation.pageLocator;

import java.util.Random;

import org.openqa.selenium.*;

import automation.common.CommonBase;

public class Day16_Homework_01__CrmStar_QLKV_Page extends CommonBase {

	private WebDriver driver;

	public Day16_Homework_01__CrmStar_QLKV_Page(WebDriver _driver) {

		this.driver = _driver;
	}

	public void LoginFunction(String email, String password) {

		type(By.id("email"), email);
		type(By.id("password"), password);
		click(By.xpath("//button[text()='Đăng nhập']"));
	}

	public String randomDataFunction() {
		Random random = new Random();
		return String.valueOf(1000000000 + random.nextInt(900000000));
	}

	public void addKVLVFunction(String maKLV, String tenKLV) {

		click(By.xpath("//a[contains(text(),'Quản lý khu làm việc')]"));
		click(By.xpath("//button[text()='Thêm mới']"));

		type(By.name("work_areas_code"), maKLV);
		type(By.name("name"), tenKLV);
		click(By.xpath("//button[text()='Lưu']"));

	}

	public void confirm_AddKVLVFunction() {
		click(By.xpath("//button[text()='Thêm']"));
	}

	public void searchKVLVFunction(String maKV) {
		type(By.xpath("//input[@name='query']"), maKV);
		click(By.xpath("//button[text()='Tìm kiếm']"));

	}

	public void removeKVLVFunction() {
		click(By.xpath("//a[contains(text(),'Xóa')]"));
		driver.switchTo().alert().accept();
	}

}

package automation.pageLocator;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class QLKLV_Page extends CommonBase {

	private WebDriver driver;

	public QLKLV_Page(WebDriver driver) {
		this.driver = driver;
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

		click(By.xpath("//button[contains(text(),'Thêm')]"));
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

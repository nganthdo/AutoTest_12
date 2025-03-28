package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_iFrameTest extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_CODESTAR2);
	}

	@Test
	public void dangKyNhanTuVan_KhongThanhCong_MissingEmail() {
		scrollToElement(By.xpath(
				"//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
		driver.switchTo().frame(getElementPresentDOM(By.xpath("(//iframe[@title='Khách hàng'])[1]")));
		type(By.id("name"), "AutoTest Name");
		type(By.id("phone_number"), "098877766");
		click(By.xpath("//button[normalize-space()='Gửi ngay']"));

		assertTrue(isElementDisplay(By.xpath("//button[normalize-space()='Gửi ngay']")));
	}

	// find iframe index
	@Test
	public void findIFrame() {
		int soIframe = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Số iframe là: " + soIframe);
		scrollToElement(By.xpath(
				"//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
		for (int i = 0; i < soIframe; i++) {
			driver.switchTo().frame(i);
			
			if (driver.findElements(By.id("name")).size() > 0) {
				System.out.println("Frame chứa thẻ họ và tên ở vị trí thứ: " + i);

			}
			driver.switchTo().defaultContent();

		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

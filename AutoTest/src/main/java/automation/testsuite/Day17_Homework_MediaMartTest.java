package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_Homework_MediaMartTest extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_MEDIAMART);
	}

	@Test()
	public void findZaloIframe() {

		driver.switchTo().frame(getElementPresentDOM(By.xpath("//iframe[contains(@src, 'page.widget.zalo.me')]")));
		click(By.xpath("//div[@class='za-chat__head-box']"));
//		if (checkAlertPresent() == true) {
//			driver.switchTo().alert().accept();
//		}
		assertTrue(isElementDisplay(By.xpath("//h1[text()='Xin chào!']")));

		click(By.xpath("//div[@class='zbtn zbtn-normal welcome text-welcome']"));
		assertTrue(isElementDisplay(
				By.xpath("//div[contains(text(),'Xin chào! Siêu thị điện máy MediaMart rất vui được hỗ trợ bạn.')]")));

		driver.switchTo().defaultContent();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

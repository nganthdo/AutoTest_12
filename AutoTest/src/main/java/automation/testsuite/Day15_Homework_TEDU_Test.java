package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day15_Homework_TEDU_Page;

public class Day15_Homework_TEDU_Test extends CommonBase {

	String password = "1234567";

	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_TEDU);

	}

	@Test(priority = 1)
	public void LoginSuccessfully() throws InterruptedException {
		Thread.sleep(3000);
		Day15_Homework_TEDU_Page tedu = new Day15_Homework_TEDU_Page(driver);
		tedu.LoginFunction("emma@mailinator.com", password);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());

	}

	@Test(priority = 2)
	public void UpdatePassSuccessfully() throws InterruptedException {

		LoginSuccessfully();
		// Thread.sleep(3000);
		Day15_Homework_TEDU_Page tedu = new Day15_Homework_TEDU_Page(driver);
		tedu.ChangePasswordFunction("1234567", "123456");
		password = "123456";

		assertTrue(driver
				.findElement(By.xpath("//div[contains(text(),'Đổi mật khẩu thành công. Mời bạn đăng nhập lại.')]"))
				.isDisplayed());
	}

	@Test(priority = 3)
	public void RecoverPassSuccessfully() throws InterruptedException {

		LoginSuccessfully();
		// Thread.sleep(3000);
		Day15_Homework_TEDU_Page tedu = new Day15_Homework_TEDU_Page(driver);
		tedu.ChangePasswordFunction("123456", "1234567");
		password = "1234567";

		assertTrue(driver
				.findElement(By.xpath("//div[contains(text(),'Đổi mật khẩu thành công. Mời bạn đăng nhập lại.')]"))
				.isDisplayed());
	}

	String keyword = "java";

	public boolean VerifySearchResult() {
		boolean keywordFlag = false;

		List<String> listBodyResult = new ArrayList<>();

		List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='pagination']//li//*"));

		int totalPages = pages.size();
		System.out.println("Total Page is: " + totalPages);

		// case 1: the keyword "ASP NET" => data is shown in one page
		if (pages.size() == 1) {
			List<WebElement> page_1 = driver.findElements(By.xpath("//li[@class='active']"));
			List<WebElement> searchBody = driver.findElements(By.xpath("//div[@class='post-body']"));

			for (WebElement body : searchBody) {
				String textBody = body.getText().toLowerCase();
//				listBodyResult.add(textBody);
//				System.out.println("Body is: " + textBody);
				if (textBody.contains(keyword.toLowerCase())) {
					keywordFlag = true;
				}
			}
		// case 2: the keyword "java" => data is shown in many pages
		} else { 
			for (int i = 0; i < pages.size(); i++) {
				pages = driver.findElements(By.xpath("//ul[@class='pagination']//li//a"));
				pages.get(i).click();
				
				List<WebElement> searchBody = driver.findElements(By.xpath("//div[@class='post-body']"));

				for (WebElement body : searchBody) {
					String textBody = body.getText().toLowerCase();
//					listBodyResult.add(textBody);
//					System.out.println("Body is: " + textBody);
					if (textBody.contains(keyword.toLowerCase())) {
						keywordFlag = true;
					}
				}
			}
		}
		System.out.println("Number of results: " + listBodyResult.size());
		System.out.println("keywordFlag " + keywordFlag);
		return keywordFlag;

	}

	@Test(priority = 4)
	public void SearchSuccessfully() throws InterruptedException {

		LoginSuccessfully();

		Day15_Homework_TEDU_Page search = new Day15_Homework_TEDU_Page(driver);
		search.SearchCourseFunction(keyword);

		assertTrue(VerifySearchResult(), "The body does not contain keyword");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

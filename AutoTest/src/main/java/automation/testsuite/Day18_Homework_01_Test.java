package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day18_Homework_01_Page;

public class Day18_Homework_01_Test extends CommonBase {

	@Parameters("browserTestNG")
	@BeforeMethod
	public void openBrowser(@Optional("firefox") String browserTestNG) {
//		driver = initFireFoxDriver(CT_PageURL.URL_DIENMAYNHAPKHAU);
		driver = setupDriver(browserTestNG);
		driver.get(CT_PageURL.URL_DIENMAYNHAPKHAU);

	}

	@Test
	public void clickZalo() {

		click(By.xpath("//div[@id='zalo-vr']"));

		Day18_Homework_01_Page zaloPage = new Day18_Homework_01_Page(driver);
		zaloPage.handleChildWindow();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("0988169282"));
		
		String actualURL= driver.getCurrentUrl();
		assertTrue(actualURL.contains("0988169282"), "URL không chứa số Zalo mong muốn!");
		

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Homework_02_ALERT extends CommonBase {

	@Parameters("browserTestNG")
	@BeforeMethod
	public void openBrowser(String browserTestNG ) {
		//driver = initBrowser(CT_PageURL.URL_SELENIUMDMO);
		driver = setupDriver(browserTestNG);
		driver.get(CT_PageURL.URL_CRMSTAR);

	}

	@Test
	public void clickAlert() {

		click(By.xpath("//button[text()='Try it']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());

		String alertMessage = driver.switchTo().alert().getText();
		String expectedResult = "Welcome to Selenium WebDriver Tutorials";

		assertEquals(alertMessage, expectedResult);
		
		driver.switchTo().alert().accept();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Homework_03_ALERT extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_GURUDEMO_TEST);

	}

	@Test
	public void clickAlert() {

		type(By.name("cusid"), "ID001");
		click(By.name("submit"));

		WebDriverWait waitAlert01 = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitAlert01.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();

		WebDriverWait waitAlert02 = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitAlert02.until(ExpectedConditions.alertIsPresent());

		String alertMessage = driver.switchTo().alert().getText();
		String expectedResult = "Customer Successfully Delete!";
		assertEquals(alertMessage, expectedResult);

		driver.switchTo().alert().accept();

		isElementDisplay(By.xpath("//td[text()='Delete Customer Form']"));

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

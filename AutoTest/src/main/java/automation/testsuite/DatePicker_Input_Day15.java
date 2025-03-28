package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class DatePicker_Input_Day15 extends CommonBase {

	@Parameters("browserTestNG")
	@BeforeMethod
	public void openBrowser(String browserTestNG) {
		//driver = initFireFoxDriver(CT_PageURL.URL_GURUDEMO);
		driver = setupDriver(browserTestNG);
		driver.get(CT_PageURL.URL_GURUDEMO);

	}

	@Test
	public void typeToDatePicker() {
		WebElement datePickerBday = driver.findElement(By.name("bdaytime"));
		// removing the attribute "read-only" which is in the tag <input>
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly');", datePickerBday);
		datePickerBday.sendKeys("1112AM 12122000");
		datePickerBday.sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		assertTrue(driver.findElement(By.xpath("//div[contains(., 'Your Birth Date is 2000-12-12')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[contains(., 'Your Birth Time is 11:12')]")).isDisplayed());

	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		driver.close();
//	}

}

package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class ALERT_PracticeTest_Day16 extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.URL_ALERTDEMO);
	}
	
	@Test
	public void pressOkButton() {
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		// kiểm tra alert hiện thị đúng
		String actualText = driver.switchTo().alert().getText();
		String expectedMessage = "Please enter your name";
		assertEquals(actualText, expectedMessage);
		
		// nhập "Class 12" và click OK
		driver.switchTo().alert().sendKeys("Class 12");
		driver.switchTo().alert().accept();
		WebElement elementResult = getElementPresentDOM(By.id("demo1"));
		String actualEText = elementResult.getText();
		assertEquals(actualEText, "Hello Class 12 How are you today");
		
	}
	
	@Test
	public void pressCancelButton() {
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		// kiểm tra alert hiện thị đúng
		String actualText = driver.switchTo().alert().getText();
		String expectedMessage = "Please enter your name";
		assertEquals(actualText, expectedMessage);
		
		// nhập "Class 12" và click OK
		driver.switchTo().alert().sendKeys("Class 12");
		driver.switchTo().alert().dismiss();
		assertFalse(isElementDisplay(By.id("demo1")));
//		WebElement elementResult = getElementPresentDOM(By.id("demo1"));
//		String actualEText = elementResult.getText();
//		assertEquals(actualEText, "");
		
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}

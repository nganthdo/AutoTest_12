package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Rise_LoginTest_Day13 extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser(CT_PageURL.URL_RISE_DEMO);
	}

	@Test
	public void LoginSuccessfully() {
		WebElement textEmail = driver.findElement(By.id("email"));
		// clear default data in textbox
		textEmail.clear();
		textEmail.sendKeys("admin@demo.com");

		WebElement textPassword = driver.findElement(By.id("password"));
		// clear default data in textbox
		textPassword.clear();
		textPassword.sendKeys("riseDemo");

		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='Sign in']"));
		btnSignin.click();

		// Assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
	}
	
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

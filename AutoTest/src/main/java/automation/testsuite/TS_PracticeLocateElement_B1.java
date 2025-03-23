package automation.testsuite;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class TS_PracticeLocateElement_B1 extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser("https://selectorshub.com/xpath-practice-page/");
	}

	@Test
	public void submitForm() {
		WebElement txtUserEmail = driver.findElement(By.name("email"));
		System.out.println("Element User Email is: " + txtUserEmail);

		WebElement txtPassword = driver.findElement(By.id("pass"));
		System.out.println("Element Password is: " + txtPassword);

		WebElement txtCompany = driver.findElement(By.name("company"));
		System.out.println("Element Company is: " + txtCompany);

		WebElement txtMobilePhone = driver.findElement(By.name("mobile number"));
		System.out.println("Element Mobile Phone is: " + txtMobilePhone);

	}

}

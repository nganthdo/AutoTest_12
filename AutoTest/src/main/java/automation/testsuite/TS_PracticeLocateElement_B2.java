package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class TS_PracticeLocateElement_B2 extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser("https://automationfc.github.io/basic-form/index.html");
	}

	@Test
	public void submitAndRestForm() {
		WebElement txtName = driver.findElement(By.id("name"));
		System.out.println("Element Name is: " + txtName);

		WebElement txtAddress = driver.findElement(By.id("address"));
		System.out.println("Element Address is: " + txtAddress);

		WebElement txtEmail = driver.findElement(By.id("email"));
		System.out.println("Element Email is: " + txtEmail);

		WebElement txtPassword = driver.findElement(By.id("password"));
		System.out.println("Element Password is: " + txtPassword);

	}

}

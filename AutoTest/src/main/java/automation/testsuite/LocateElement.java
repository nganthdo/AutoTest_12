package automation.testsuite;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class LocateElement extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser("https://alada.vn/tai-khoan/dang-nhap.html");
	}

	@Test
	public void locateById() {

		WebElement textUsername = driver.findElement(By.id("txtLoginUsername"));
		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		System.out.println("Element username is: " + textUsername);
		System.out.println("Element password is: " + textPassword);

	}

	@Test
	public void locateByName() {
		WebElement textUsername = driver.findElement(By.name("txtLoginUsername"));
		WebElement textPassword = driver.findElement(By.name("txtLoginPassword"));
		System.out.println("Element username is: " + textUsername);
		System.out.println("Element password is: " + textPassword);
	}

	@Test
	public void locateByClassName() {
		WebElement btnFacebook = driver.findElement(By.className("btn_face"));
		System.out.println("Element button facebook is: " + btnFacebook);
	}

	@Test
	public void locateByLinkText() {
		WebElement linkForgotPass = driver.findElement(By.linkText("Quên mật khẩu?"));
		System.out.println("Element Link Quên Mật Khẩu is: " + linkForgotPass);

		WebElement linkTrainer = driver.findElement(By.partialLinkText("giảng viên"));
		System.out.println("Element Link Trainer is: " + linkTrainer);
	}

	@Test
	public void locateByTagName() {
		WebElement textInput = driver.findElement(By.tagName("input"));
		System.out.println("Element textInput is: " + textInput);

	}

}

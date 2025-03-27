package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day13_CrmStar_AddNewEmployPage;
import automation.pageLocator.CrmStar_LoginPage;

public class Day13_CrmStar_AddNewEmployeeTest extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initFireFoxDriver(CT_PageURL.URL_CRMSTAR);
		
	}
	
	@Test
	public void AddNew_Employee() {
		CrmStar_LoginPage login = new CrmStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		
		Random random = new Random();
		String randomUserCode = String.valueOf(1000000000 + random.nextInt(900000000));
		
		String randomFullName = "emmatest" + randomUserCode;
		String randomEmail = "emmatest" + randomUserCode + "@test.com";
		
		Day13_CrmStar_AddNewEmployPage addNewEmpployee = new Day13_CrmStar_AddNewEmployPage(driver);
		addNewEmpployee.AddNewEmployeeFunction(randomFullName, randomEmail, "000-234-342", "Công Nghệ", "Admin/IT", "KV0024", randomUserCode);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement succeedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(), 'Thêm mới người dùng thành công')]")));
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

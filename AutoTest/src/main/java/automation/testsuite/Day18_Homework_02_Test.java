package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day18_Homework_02_Page;

public class Day18_Homework_02_Test extends CommonBase {

	@Parameters("browserTestNG")
	@BeforeMethod
	public void openBrowser(String browserTestNG) {
//		driver = initFireFoxDriver(CT_PageURL.URL_BEPANTOAN);
		driver = setupDriver(browserTestNG);
		driver.get(CT_PageURL.URL_BEPANTOAN);

	}
	
	@Test
	public void clickChat() {
		
		
		Day18_Homework_02_Page chat = new Day18_Homework_02_Page(driver);
		chat.handleChildWindow();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Messenger"));
		
		String actualTitle = driver.getTitle();
		System.out.println("Title is: " +actualTitle);
		String expectedTitle = "Messenger";
		
		assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	

}

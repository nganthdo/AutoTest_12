package automation.testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class TS_Practice_Day12_B1 extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser(CT_PageURL.URL_DEMOQA);
	}

	@Test
	public void clickOnCheckbox() {
		WebElement chbSport = driver.findElement(By.xpath("//label[text() = 'Sports']"));

		if (chbSport.isSelected() == false) {
			chbSport.click();
			System.out.println("Checkbox Sports is checked");
		}

		WebElement chbReading = driver.findElement(By.xpath("//label[text() = 'Reading']"));
		if (chbReading.isSelected() == false) {
			chbReading.click();
			System.out.println("Checkbox Reading is checked");
		}

		WebElement chbMusic = driver.findElement(By.xpath("//label[text() = 'Music']"));
		if (chbMusic.isSelected() == false) {
			chbMusic.click();
			System.out.println("Checkbox Music is checked");
		}

	}

	@Test
	public void clickMultiple() {
		List<WebElement> listCheckbox = driver
				.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));

		for (WebElement checkbox : listCheckbox) {

			if (checkbox.isSelected() == false) {
				checkbox.click();
				System.out.println("Checkbox" + checkbox + "is checked");
			}

		}
	}

	@Test
	public void clickRadioButton() {
		WebElement radioMale = driver.findElement(By.xpath("//input[@id='gender-radio-1']/following-sibling::label"));
		// 1 - check that the default value is not clicked
		boolean isClickMale = radioMale.isSelected();
		System.out.println("Radio Male is clicked" + isClickMale);

		// 2- if radio male is enable, then it should be clicked
		if (radioMale.isEnabled() == true) {
			radioMale.click();
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();
	}

}

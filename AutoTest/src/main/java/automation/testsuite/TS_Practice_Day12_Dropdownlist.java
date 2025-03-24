package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class TS_Practice_Day12_Dropdownlist extends CommonBase {

	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser(CT_PageURL.URL_CODESTAR);
	}

	@Test
	public void chooseAWSOption() {
		Select dropdownCourse = new Select(driver.findElement(By.id("product_categories_filter")));
		// check number of options in drop down list
		System.out.println("The number of options: " + dropdownCourse.getOptions().size());
		dropdownCourse.selectByContainsVisibleText("AWS");

		String textAfterSelect = dropdownCourse.getFirstSelectedOption().getText();
		System.out.println("Text is: " + textAfterSelect);

		System.out.println("Is multiple: " + dropdownCourse.isMultiple());
	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();
	}

}

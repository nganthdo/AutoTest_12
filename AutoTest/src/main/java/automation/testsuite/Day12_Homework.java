package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Homework extends CommonBase {
	@BeforeMethod
	public void openBrowserTest() {
		driver = initBrowser(CT_PageURL.URL_GLOBALSQA);
	}

	@Test
	public void chooseCountry() {
		Select chooseCountry = new Select(driver.findElement(By.xpath("//select")));
		// 1. check number of options in drop down list
		System.out.println("The number of options in the Country drop down list: " + chooseCountry.getOptions().size());
		// 2. select the option "Viet Nam"
		chooseCountry.selectByContainsVisibleText("Viet Nam");
		// 3. verify that textAfterSelect is "Viet Nam"
		String txtAfterSelect = chooseCountry.getFirstSelectedOption().getText();
		System.out.println("The text is: " + txtAfterSelect);

		System.out.print("Is multiple: " + chooseCountry.isMultiple());
	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();
	}

}

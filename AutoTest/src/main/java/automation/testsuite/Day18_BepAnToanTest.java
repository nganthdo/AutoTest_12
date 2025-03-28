package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day18_BepAnToanTest extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_BEPANTOAN);

	}

	public boolean verifySearchResult() {
		boolean Flag = false;
		if (isElementDisplay(By.xpath("//div[@class='flex flex-wrap product-list']/a//h4")) == true) {
			List<WebElement> listProduct = driver
					.findElements(By.xpath("//div[@class='flex flex-wrap product-list']/a//h4"));

			System.out.println("Total Product Name: " + listProduct.size());
			for (WebElement product : listProduct) {
				String actualProductName = product.getText().toLowerCase();
				System.out.println("Actual Product Name  is: " + actualProductName );
				if (actualProductName.contains("bosch")) {
					Flag = true;
				}
			}
		}
		return Flag;
	}

	@Test
	public void searchBepTu_Bosch() throws InterruptedException {

		click(By.xpath("//a[text()=' Bếp Từ ']"));
		click(By.xpath("(//a[contains(@href,'bep-tu/bosch')])[1]"));
		Thread.sleep(3000);
		assertTrue(verifySearchResult(), "Error Filter");

	}

}

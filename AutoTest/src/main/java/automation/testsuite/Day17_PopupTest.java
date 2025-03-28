package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day17_PopupPage;

public class Day17_PopupTest extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initBrowser(CT_PageURL.URL_GURUDEMO_POPUP);

	}
	
	@Test
	public void testPopup() {
		Day17_PopupPage popupPage = new Day17_PopupPage(driver);
		popupPage.handleChildWindow();
		
		
		String actualURL= driver.getCurrentUrl();
		String expectedURL = "https://demo.guru99.com/popup.php";
		assertEquals(actualURL, expectedURL);
	}
	

}

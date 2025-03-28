package automation.pageLocator;

import static org.testng.Assert.assertTrue;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Day17_PopupPage extends CommonBase {
	
	private WebDriver driver;

	public Day17_PopupPage(WebDriver commonBaseDriver) {
		this.driver = commonBaseDriver;
	}
	
	public void handleChildWindow() {
		click(By.xpath("//a[text()='Click Here']"));
		
		// lấy ra main window
		String mainWindow = driver.getWindowHandle();
		// lấy tập hợp các window
		Set<String> windows = driver.getWindowHandles();
		for(String childWindow: windows) {
			if(!childWindow.equals(mainWindow)) {
				// switch đến childwindow
				driver.switchTo().window(childWindow);
				type(By.name("emailid"),"test@mailinator.com");
				click(By.name("btnLogin"));
				assertTrue(isElementDisplay(By.xpath("//h2[text()='Access details to demo site.']")));
				driver.close();
				
				System.out.println("Child window has been closed");
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println("Driver has been switched to main window");
		
	}
	

}

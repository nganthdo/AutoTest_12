package automation.pageLocator;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class Day18_Homework_01_Page extends CommonBase {

	private WebDriver driver;

	public Day18_Homework_01_Page(WebDriver _driver) {
		this.driver = _driver;
	}

	public void handleChildWindow() {
//		click(By.xpath("//div[@id='zalo-vr']"));

		// lấy ra main window
		String mainWindow = driver.getWindowHandle();
		// lấy tập hợp các window
		Set<String> windows = driver.getWindowHandles();

		for (String childWindow : windows) {
			if (!childWindow.equals(mainWindow)) {
				// switch đến childwindow
				driver.switchTo().window(childWindow);
				assertTrue(isElementDisplay(By.xpath("//h2[text()='Đăng nhập tài khoản Zalo']")));
//				driver.close();
//
//				System.out.println("Child window has been closed");
			}
		}
//		driver.switchTo().window(mainWindow);
//		System.out.println("Driver has been switched to main window");
	}

}

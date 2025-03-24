package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmStar_LogoutPage {
	private WebDriver driver;

	public CrmStar_LogoutPage(WebDriver _driver) {

		this.driver = _driver;
	}

	public void LogoutFunction() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement menuAdmin = driver.findElement(By.id("dropdownMenuLink"));
		js.executeScript("arguments[0].click();", menuAdmin);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdownMenuLink")));
		//menuAdmin.click();
		
		WebElement menuLogout = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Đăng xuất']")));
		menuLogout.click();
		

		WebElement btnLogout = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Đăng xuất' and @type='submit']")));
		btnLogout.click();

	}

}

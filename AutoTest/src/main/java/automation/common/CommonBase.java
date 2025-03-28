package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class CommonBase {
	public static WebDriver driver; // static: dùng chung cho tất cả các instance của class đó, giúp tránh bị null
									// khi chạy các test case riêng lẻ.
	private int pageLoadTimeout = 30;

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}

	// khởi tạo Chrome Browser
	public WebDriver initBrowser(String URL) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		return driver;
	}

	// khởi tạo Firefox Browser
	public WebDriver initFireFoxDriver(String URL) {
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		return driver;
	}

	// Thay cho hàm findElement(locator)
	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pageLoadTimeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);

	}

	// Thay cho WebElement.click()
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pageLoadTimeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	// Thay cho WebElement sendKeys()
	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.clear();
		element.sendKeys(value);
	}

	// Thay cho isDisplayed
	public boolean isElementDisplay(By locator) {
		try {
			WebElement element = getElementPresentDOM(locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pageLoadTimeout));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (NoSuchElementException ex1) {
			return false;
		} catch (TimeoutException ex2) {
			return false;
		}

	}

	// Các hàm dùng js
	public void type_toElementByValueAttribute(By locator, String value) {
		try {
			WebElement element = getElementPresentDOM(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			type_toElementByValueAttribute(locator, value);
		}
	}

	public void clickJavascript(By locator) {

		WebElement element = getElementPresentDOM(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Scroll to element
	public void scrollToElement(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Check Alert
	public boolean checkAlertPresent() {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(pageLoadTimeout));
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				System.out.println("Yes, Alert presents");
				result = true;

			}
		} catch (Exception ex) {
			result = false;
		}
		return result;

	}

	// khởi tạo Chrome Browser
	private WebDriver initBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		return driver;
	}

	// khởi tạo Firefox Browser
	private WebDriver initFireFoxDriver() {
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		return driver;
	}
	
	// khởi tạo Edge Browser
		private WebDriver initEdgeDriver() {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
			return driver;
		}
		
		public WebDriver setupDriver(String browserName) {
			switch (browserName.trim().toLowerCase()) {
			case "chrome":
				System.out.println("Initializing chrome browser test.....");
				initBrowser();
				break;
			case "firefox":
				System.out.println("Initializing firefox browser test.....");
				initFireFoxDriver();
				break;
			case "edge":
				System.out.println("Initializing ms edge browser test.....");
				initEdgeDriver();
				break;
			default:
				System.out.println("Invalid browser test, choose chrome as default of choice.....");
				initBrowser();
				break;
			}
			return driver;
		}

}

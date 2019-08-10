package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public BrowserFactory(String browserName) {
		this.browser = browserName;
	}

	private  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	
	

	public WebDriver createDriver() {
		System.out.println("yash");
		/*
		 * switch(browser) { case "chrome":
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\yash\\gitub\\seleniumFramework\\arval\\src\\test\\resources\\drivers\\chromedriver.exe"
		 * ); driver.set(new ChromeDriver()); break; case "ie":
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\yash\\gitub\\seleniumFramework\\arval\\src\\test\\resources\\drivers\\chromedriver.exe"
		 * ); driver.set(new InternetExplorerDriver()); break; default :
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\yash\\gitub\\seleniumFramework\\arval\\src\\test\\resources\\drivers\\chromedriver.exe"
		 * ); driver.set(new ChromeDriver()); break; }
		 */
		return driver.get();
		}	
	}

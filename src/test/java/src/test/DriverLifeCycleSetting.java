package src.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {
	protected WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() {
		//System.setProperty("webdriver.chrome.driver", "/home/ale/Downloads/chromedriver");
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
	}
	
	@BeforeEach
	public void beforeEach() {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		//driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
	}
	
	@AfterEach
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}

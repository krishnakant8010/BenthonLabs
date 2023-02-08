package BrowsersSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Website_OpenOn_Browser {
	public static WebDriver driver;
	//String driverPath=System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	@BeforeTest
	public void Open_Browser() {
		// WebDriverManager.chromedriver.setup();
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.benthonlabs.com/");
	}
	
	@AfterTest
	public void Closed_Opened_Browser() throws Exception {
			Thread.sleep(2000);
			driver.close();
	}
	
	
}

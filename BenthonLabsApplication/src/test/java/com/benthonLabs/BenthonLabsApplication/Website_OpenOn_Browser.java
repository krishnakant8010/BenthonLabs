package com.benthonLabs.BenthonLabsApplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Website_OpenOn_Browser {
	public static WebDriver driver;
	@BeforeTest
	public void Open_Browser() {
		// WebDriverManager.chromedriver.setup();
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@Test
	public void Verify_Website_Open() {
		driver.get("https://www.benthonlabs.com/");
		String ExpectedTitle = "Benthon Labs – Cloud-Based DevOps Services and Solutions";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	
	
}

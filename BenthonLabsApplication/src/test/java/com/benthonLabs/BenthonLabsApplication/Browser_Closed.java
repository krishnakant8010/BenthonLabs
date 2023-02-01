package com.benthonLabs.BenthonLabsApplication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Browser_Closed {
	WebDriver driver;
	@AfterTest
	public void Close_Browser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}

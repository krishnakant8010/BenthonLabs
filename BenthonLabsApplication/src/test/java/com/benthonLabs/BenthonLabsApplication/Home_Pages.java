package com.benthonLabs.BenthonLabsApplication;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home_Pages {
	WebDriver driver;

	@BeforeTest
	public void Browser_Lunch() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void HomePage_Open() {
		driver.get("https://www.benthonlabs.com/");
		String ExpectedTitle = "Benthon Labs – Cloud-Based DevOps Services and Solutions";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);

	}

	@Test(priority=2)
	public void Homebanaer_TitleDescription() {
		String ExpectedbanerTitle="“Trusted and Reliable End-to-End Technology Partner”";
		
		
		List<WebElement> ActualbanerTitle=driver.findElements(By.xpath("//h2[contains(text(),'“Trusted and Reliable End-to-End Technology Partner”')]"));
		
		for(int i = 0; i< ActualbanerTitle.size(); i++) {
	         //obtain text
	         String ActualbanerTitle_Final = ActualbanerTitle.get(i).getText();
	         System.out.println(ActualbanerTitle_Final);
	        
	         if(ExpectedbanerTitle.equals(ActualbanerTitle_Final)) {
	        	 System.out.println("Sucess");
	        	 break;
	         }else {
	        	 System.out.println("Not Sucess");
	         }
	         //Assert.assertEquals(ExpectedbanerTitle, ActualbanerTitle_Final);
	      }	
		//
	}
	
	@AfterTest
	public void DearDown() {
		driver.quit();
	}
}

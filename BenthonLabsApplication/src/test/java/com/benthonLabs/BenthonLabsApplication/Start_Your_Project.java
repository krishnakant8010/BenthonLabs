package com.benthonLabs.BenthonLabsApplication;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Start_Your_Project extends Website_OpenOn_Browser {

	@Test(priority = 1)
	public void Verify_Start_Your_Project_Page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.xpath("//a[contains(text(),'I agree')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='btn project'])[1]")).click();
		// For footer area start your profile link
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		// explicit wait condition
//		WebDriverWait w = new WebDriverWait(driver, 3);
//		// presenceOfElementLocated condition
//		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Start your Project']")));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Start your Project']")).click();

		String ExpectedTitle = "Software Development Company | IT Solutions | Development Services";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Test(priority = 2, dependsOnMethods = "Verify_Start_Your_Project_Page")
	public void Verify_Start_Your_project_Form() throws InterruptedException {
		// identify element
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,430)");
//		//Locating element by link text and store in variable "Element"        		
//        WebElement Element = driver.findElement(By.xpath("//h3[text()='Start your project with us!']"));
//        // Scrolling down the page till the element is found		
//        js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(1000);
		// driver.findElement(By.id("name")).click();
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("krishna kant Singh");
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("Quality@indyfin.com");
		driver.findElement(By.xpath("//form[@id='buildTeamFormSubmit']//div[3]//input[1]")).sendKeys("8010666443");
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("testing data by krishna kant");
		
		
		driver.findElement(By.xpath("//body/main[1]/section[4]/div[1]/div[1]/div[2]/div[2]/form[1]/div[5]/div[1]")).click();
		driver.findElement(By.id("start-project-submit")).click();
		
		
		
		}

}

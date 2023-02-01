package com.benthonLabs.BenthonLabsApplication;

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='cookie-consent-section__actions']//a[2]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// identify element and click()
		//WebElement l = driver.findElement(By.linkText("Start your Project"));
		//l.click();
		// explicit wait condition
		WebDriverWait w = new WebDriverWait(driver, 3);
		// presenceOfElementLocated condition
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Start your Project']")));
		// get text of element and print
		//System.out.println("Element present having text:" + l.getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Start your Project']")).click();
		String ExpectedTitle = "Software Development Company | IT Solutions | Development Services";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Test(priority = 2, dependsOnMethods ="Verify_Start_Your_Project_Page")
	public void Verify_Captcha() {
		// identify element
		WebElement l = driver.findElement(By.xpath("//h3[text()='Start your project with us!']"));
		// Actions class with moveToElement()
		Actions a = new Actions(driver);
		a.moveToElement(l);
		a.perform();

		
	}
}

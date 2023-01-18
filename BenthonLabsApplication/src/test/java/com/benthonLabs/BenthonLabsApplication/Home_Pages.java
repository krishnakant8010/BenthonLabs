package com.benthonLabs.BenthonLabsApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home_Pages {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Browser_Lunch() {

		// WebDriverManager.chromedriver.setup();
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void HomePage_Open() {
		driver.get("https://www.benthonlabs.com/");
		String ExpectedTitle = "Benthon Labs – Cloud-Based DevOps Services and Solutions";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);

	}

	@Test(priority = 2, enabled = false)
	public void Homebanaer_TitleDescription() {

		// Verify Banner section Title
		String ExpectedbanerTitle = "“Trusted and Reliable End-to-End Technology Partner”";
		List<WebElement> ActualbanerTitle = driver.findElements(
				By.xpath("//h2[contains(text(),'“Trusted and Reliable End-to-End Technology Partner”')]"));

		for (int i = 0; i < ActualbanerTitle.size(); i++) {
			// obtain text
			String ActualbanerTitle_Final = ActualbanerTitle.get(i).getText();
			// System.out.println(ActualbanerTitle_Final);

			if (ExpectedbanerTitle.equals(ActualbanerTitle_Final)) {
				System.out.println("Banner Title matched Sucessfully");
				break;
			} else {
				System.out.println("Not Matched");
			}
			// Assert.assertEquals(ExpectedbanerTitle, ActualbanerTitle_Final);
		}

		//// Verify Banaer section Title
		String ExpectedbanerDescriptions = "“Trusted and Reliable End-to-End Technology Partner”";
		List<WebElement> ActualbanerDescriptions = driver.findElements(
				By.xpath("//h2[contains(text(),'“Trusted and Reliable End-to-End Technology Partner”')]"));

		for (int i = 0; i < ActualbanerDescriptions.size(); i++) {
			// obtain text
			String ActualbanerDescriptions_Final = ActualbanerTitle.get(i).getText();
			// System.out.println(ActualbanerDescriptions_Final);

			if (ExpectedbanerDescriptions.equals(ActualbanerDescriptions_Final)) {
				System.out.println("Description text matched Sucessfully");
				break;
			} else {
				System.out.println("Not Matched");
			}
			// Assert.assertEquals(ExpectedbanerTitle, ActualbanerTitle_Final);
		}
	}

	@Test(priority = 3,enabled = false)
	public void VerifyALLImages() throws InterruptedException, IOException {

		Thread.sleep(3000);
		List<WebElement> images = driver.findElements(By.tagName("img"));

		System.out.println(images.size());

		for (WebElement image : images) {
			// String imageSrc=image.getAttribute("src");
			// String imageSrc=image.getAttribute("src");

			if (image.getAttribute("src") != null) {
				String imageSrc = image.getAttribute("src");

				try {
					URL url = new URL(imageSrc);
					URLConnection urlConnection = url.openConnection();
					HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
					httpURLConnection.setConnectTimeout(5000);
					httpURLConnection.connect();

					if (httpURLConnection.getResponseCode() == 200) {

						System.out.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> "
								+ httpURLConnection.getResponseMessage());
					} else {
						System.err.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> "
								+ httpURLConnection.getResponseMessage());
					}
					httpURLConnection.disconnect();
				} catch (Exception e) {
					System.out.println(imageSrc);
				}
			}
		}
	}

	@Test(priority = 4, enabled = false)
	public void VerifyAllLinkActive() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links are : " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			// System.out.println(ele);
			String url = ele.getAttribute("href");

			try {
				URL urll = new URL(url);
				HttpURLConnection httpURLConnect = (HttpURLConnection) urll.openConnection();

				httpURLConnect.setConnectTimeout(3000);
				httpURLConnect.connect();

				if (httpURLConnect.getResponseCode() == 200) {
					System.out.println(url + "-" + httpURLConnect.getResponseMessage());
				}
				if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(
							url + "-" + httpURLConnect.getResponseMessage() + "-" + HttpURLConnection.HTTP_NOT_FOUND);
				}

			} catch (Exception e) {
				
			}
		}
	}
	@Test(priority=5, enabled=false)
	public void Verifybannerbelowsection() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
// First section 	
		String ExFirstH4="Custom Software Development";		
		String ExFirstH42 = ExFirstH4.toUpperCase();
		Thread.sleep(2000);
		String ActualFirstH4=driver.findElement(By.xpath("//h4[contains(text(),'Custom Software Development')]")).getText();
		Assert.assertEquals(ExFirstH42, ActualFirstH4);
		
		String EXFirstP="Build a custom solution adaptive to your business requirements by engaging our extensive technical stack and custom development approach.";
		String ActualFirstHP=driver.findElement(By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/a[1]/div[1]/p[1]")).getText();
		Assert.assertEquals(EXFirstP, ActualFirstHP);
// Second section 		
		String ExSecondH4="Hire Dedicated Remote Team";
		String ExSecondH42 = ExSecondH4.toUpperCase();
		Thread.sleep(2000);
		String ActualSecondH4=driver.findElement(By.xpath("//h4[contains(text(),'Hire Dedicated Remote Team')]")).getText();
		Assert.assertEquals(ExSecondH42, ActualSecondH4);

		String EXSecondP="We’re ready to cover any of your team/resource requirements and fulfill with our talent nurturing policies, and structure for managing teams.";
		String ActualSecondP=driver.findElement(By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[2]/a[1]/div[1]/p[1]")).getText();
		
		Assert.assertEquals(EXSecondP, ActualSecondP);
// Third section		
		String ExThirdH4="IT Consultants and Digital Advisor";
		String ExThirdH42 = ExThirdH4.toUpperCase();
		Thread.sleep(2000);
		String ActualThirdH4=driver.findElement(By.xpath("//h4[contains(text(),'IT Consultants and Digital Advisor')]")).getText();
		Assert.assertEquals(ExThirdH42, ActualThirdH4);
		
		String EXThirdP="To collaborate your idea or technology, we run an architecture assessment, and create improvised approaches.";
		String ActualThirdP=driver.findElement(By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[3]/a[1]/div[1]/p[1]")).getText();
		Assert.assertEquals(EXThirdP, ActualThirdP);
		
	}

	@Test(priority=6)
	public void EXTENSIVE_EXPERTISE_H2() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		String EXTENSIVEh2="Extensive Expertise in, Top-Notch Product Development Services";
		Thread.sleep(1000);
		String ActualEXTENSIVEH2=driver.findElement(By.xpath("//body/main[1]/section[2]/div[1]/div[1]/h2[1]")).getText();
		System.out.println(ActualEXTENSIVEH2);
		
		String ActualEXTENSIVEH2=ActualEXTENSIVEH2.concat(ActualEXTENSIVEH2);
		Assert.assertEquals(EXTENSIVEh2, ActualEXTENSIVEH2);
		
	}
	@AfterTest
	public void DearDown() {
		driver.quit();
	}
}

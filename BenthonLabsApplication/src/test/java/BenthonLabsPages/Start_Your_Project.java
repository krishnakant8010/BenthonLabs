package BenthonLabsPages;

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

import BrowsersSetup.Website_OpenOn_Browser;

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
		
		// driver.findElement(By.id("name")).click();
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("krishna kant Singh");
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("Quality@indyfin.com");
		driver.findElement(By.xpath("//form[@id='buildTeamFormSubmit']//div[3]//input[1]")).sendKeys("8010666443");
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("testing data by krishna kant");
		
		Thread.sleep(2000);
//		  int size = driver.findElements(By.tagName("iframe")).size();
//		    //System.out.println("Total Frames --" + size);
//		  //  System.out.println(driver.getTitle());
//		
//		    size = driver.findElements(By.tagName("iframe")).size(); 
//		    
//		  //  System.out.println("Total Frames --" + size);
//		    driver.switchTo().frame(0);
//		    WebDriverWait wait = new WebDriverWait(driver, 5);
//		    WebElement element = wait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/main[1]/section[4]/div[1]/div[1]/div[2]/div[2]/form[1]/div[5]/div[1]/div[1]/div[1]/iframe[1]")));
//
//			// if element found then we will use- In this example I just called isDisplayed method
//			boolean status = element.isDisplayed();
//
//			// if else condition
//			if (status) {
//				System.out.println("===== WebDriver is visible======");
//				driver.findElement(By.xpath("//body/main[1]/section[4]/div[1]/div[1]/div[2]/div[2]/form[1]/div[5]/div[1]/div[1]/div[1]/iframe[1]")).click();
//			} else {
//				System.out.println("===== WebDriver is not visible======");
//			}
//		driver.findElement(By.xpath("//body/main[1]/section[4]/div[1]/div[1]/div[2]/div[2]/form[1]/div[5]/div[1]")).click();
//		driver.findElement(By.id("start-project-submit")).click();
		
		}
	@Test(priority = 3,dependsOnMethods = "Verify_Start_Your_project_Form")
	public void Verify_With_InvalidValue() throws InterruptedException {
		
		String NameError="Invalid Name";
		String EmailError="Invalid email-ID";
		String MobileError="Please enter at least 8 characters.";
		String MessageError="Please enter at least 10 characters.";
		
		// Clear Filled Form
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).clear();
		
		// Fill form with invalid value 
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("123");
		String ActualNameError=driver.findElement(By.id("name-error")).getText();
		Assert.assertEquals(ActualNameError, NameError);
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("quality");
		String ActualEmailError=driver.findElement(By.id("email-error")).getText();
		Assert.assertEquals(ActualEmailError, EmailError);
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("345346");
		String ActualMobileError=driver.findElement(By.id("mobile-error")).getText();
		Assert.assertEquals(ActualMobileError, MobileError);
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("quality");
		String ActualMessageError=driver.findElement(By.id("message-error")).getText();
		Assert.assertEquals(ActualMessageError, MessageError);
		Thread.sleep(2000);
		//driver.findElement(By.id("start-project-submit")).click();
	}
	
	@Test(priority = 4)
	public void Verify_Project_Form_With_EmptyData() throws InterruptedException{
		String NameError="Would you tell us your name?";
		String EmailError="Would you tell us your email?";
		String MobileError="Would you tell us your mobile number?";
		String MessageError="Share brief details, please";
		
		// Clear Filled Form
				driver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
				driver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
				driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
				driver.findElement(By.xpath("//textarea[@placeholder='Message']")).clear();
				
		// Fill form with invalid value
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
		String ActualNameError=driver.findElement(By.id("name-error")).getText();
		Assert.assertEquals(ActualNameError, NameError);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("quality");
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
		String ActualEmailError=driver.findElement(By.id("email-error")).getText();
		Assert.assertEquals(ActualEmailError, EmailError);
		
		
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("345346");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
		String ActualMobileError=driver.findElement(By.id("mobile-error")).getText();
		Assert.assertEquals(ActualMobileError, MobileError);
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("quality");
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).clear();
		String ActualMessageError=driver.findElement(By.id("message-error")).getText();
		Assert.assertEquals(ActualMessageError, MessageError);
		Thread.sleep(2000);
		//driver.findElement(By.id("start-project-submit")).click();
	}
	
	

}

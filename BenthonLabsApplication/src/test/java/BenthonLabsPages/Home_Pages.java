package BenthonLabsPages;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home_Pages {
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Browser_Lunch() {

		// WebDriverManager.chromedriver.setup();
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void HomePage_Open() {
		driver.get("https://www.benthonlabs.com/");
		String ExpectedTitle = "Benthon Labs – Cloud-Based DevOps Services and Solutions";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);

	}

	@Test(priority = 2, enabled=false)
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

	@Test(priority = 3, enabled=false)
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

	@Test(priority = 4, enabled=false)
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
	@Test(priority=6, enabled=false)
	public void EXTENSIVE_EXPERTISE_H2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, 20);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,850)");
				
		
		 WebElement Element1 = driver.findElement(By.xpath("//body/main[1]/section[2]/div[1]/div[1]/h2[1]"));

	        //This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element1);
	        
//EXTENSIVE EXPERTISE IN
		String EXTENSIVEh2="Extensive Expertise in,Top-Notch Product Development Services";
		String  ExpectedH2 = EXTENSIVEh2.toUpperCase();
		WebElement getdata;
		getdata= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/main[1]/section[2]/div[1]/div[1]/h2[1]")));
		String ActualEXTENSIVEH2 =getdata.getText();
		String ActualEXTENSIVEH3 = ActualEXTENSIVEH2.replace("\n","");
		//System.out.println(ActualEXTENSIVEH3);
		Assert.assertEquals(ActualEXTENSIVEH3,ExpectedH2);
//Cloud Services
		String ExpCloudServices ="Cloud Services";
		String ExpCloudServicesUpdate = ExpCloudServices.toUpperCase();
		//System.out.println(ExpCloudServicesUpdate);
		
		WebElement getdataa;
		getdataa= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Cloud Services')]")));
		String ActualCloudServices =getdataa.getText();
		
	//	String ActualCloudServices=driver.findElement(By.xpath("//h4[contains(text(),'Cloud Services')]")).getText();
		//System.out.println(ActualCloudServices);
		ActualCloudServices.toUpperCase();
	
		Assert.assertEquals(ActualCloudServices, ExpCloudServicesUpdate);
		
		String ExpCloudServicesP="Build cloud-based solutions that seamlessly match your specifications and grow with your business.";
		String	ActualCloudServicesP=driver.findElement(By.xpath("//p[contains(text(),'Build cloud-based solutions that seamlessly match ')]")).getText();
		Assert.assertEquals(ActualCloudServicesP, ExpCloudServicesP);	
//Devops 
		String ExpDevops ="Devops";
		String ExpDevopsUpdate = ExpDevops.toUpperCase();
		String ActualDevops=driver.findElement(By.xpath("//h4[contains(text(),'"+ExpDevops+"')]")).getText();
		ActualDevops.toUpperCase();
		Assert.assertEquals(ActualDevops, ExpDevopsUpdate);
		
		String ExpDevopsP="DevOps is a collection of practices that bring together software development and IT operations.";
		String	ActualDevopsP=driver.findElement(By.xpath("//p[contains(text(),'DevOps is a collection of practices that bring tog')]")).getText();
		Assert.assertEquals(ActualDevopsP, ExpDevopsP);
//The Internet of things	
		String ExpInternet ="The Internet of things";
		String ExpDevopsUpdate1 = ExpInternet.toUpperCase();
		String ActualInternet=driver.findElement(By.xpath("//h4[contains(text(),'"+ExpInternet+"')]")).getText();
		ActualInternet.toUpperCase();
		Assert.assertEquals(ActualInternet, ExpDevopsUpdate1);
		
		String ExpInternetP="Industry Focused E2E Iot App Development Services. Software architecture, firmware/sensor integration, Cloud solutions.";
		String	ActualInternetP=driver.findElement(By.xpath("//p[contains(text(),'Industry Focused E2E Iot App Development Services.')]")).getText();
		Assert.assertEquals(ActualInternetP, ExpInternetP);	
//AI/ML		
		
		String ExpAIML ="AI/ML";
		String ExpAIMLUpdate = ExpAIML.toUpperCase();
		
		WebElement ActualExpAIMLW;
		ActualExpAIMLW= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'"+ExpAIML+"')]")));
		String ActualExpAIMLT =ActualExpAIMLW.getText();
		
		//String ActualExpAIML=driver.findElement(By.xpath("//h4[contains(text(),'"+ExpAIML+"')]")).getText();
		ActualExpAIMLT.toUpperCase();
		Assert.assertEquals(ActualExpAIMLT, ExpAIMLUpdate);
		
		String ExpAIMLP="ML and AI Development Services. Customized AI & ML solutions with data analyzing, mining, and visualizing.";
		String	ActualAIMLP=driver.findElement(By.xpath("//p[contains(text(),'ML and AI Development Services. Customized AI & ML')]")).getText();
		Assert.assertEquals(ActualAIMLP, ExpAIMLP);
		
//Data Engineering
		String ExpDataEngineering  ="Data Engineering";
		String ExpExpDataEngineeringUpdate = ExpDataEngineering.toUpperCase();
		String ActualDataEngineering=driver.findElement(By.xpath("//h4[contains(text(),'"+ExpDataEngineering+"')]")).getText();
		ActualDataEngineering.toUpperCase();
		Assert.assertEquals(ActualDataEngineering, ExpExpDataEngineeringUpdate);
		
		String ExpDataEngineeringP="Unbar the embryonic of your Business Specifics.";
		String	ActualDataEngineeringP=driver.findElement(By.xpath("//p[contains(text(),'Unbar the embryonic of your Business Specifics.')]")).getText();
		Assert.assertEquals(ActualDataEngineeringP, ExpDataEngineeringP);
		
//Mobile Application
		String ExpMobileApplication ="Mobile Application";
		String ExpMobileApplicationUpdate = ExpMobileApplication.toUpperCase();
		String ActualExpMobileApplication=driver.findElement(By.xpath("//h4[contains(text(),'"+ExpMobileApplication+"')]")).getText();
		ActualExpMobileApplication.toUpperCase();
		Assert.assertEquals(ActualExpMobileApplication, ExpMobileApplicationUpdate);
		
		String ExpMobileApplicationP="Mobile and TV app development for Android, iOS and wearable technology has been well examined.";
		String	ActualMobileApplicationP=driver.findElement(By.xpath("//p[contains(text(),'Mobile and TV app development for Android, iOS and')]")).getText();
		Assert.assertEquals(ActualMobileApplicationP, ExpMobileApplicationP);
	}
//OUR SUCCESS STORIES
		@Test(priority=7, enabled=false)
		public void Success_Client(){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait=new WebDriverWait(driver, 30);
			//Find element by link text and store in variable "Element"        		
	        WebElement Element = driver.findElement(By.xpath("//body/main[1]/section[4]/div[1]/div[1]/h2[1]"));

	        //This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
			
			String EXSuccess_Client="Our Success Stories,The Work We Did For Our Happy Clients";
			String  ExpectedSuccess_ClientH2 = EXSuccess_Client.toUpperCase();
			System.out.println(ExpectedSuccess_ClientH2);
			WebElement Success_Client;
			
			Success_Client= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/main[1]/section[4]/div[1]/div[1]/h2[1]")));
			String ActualSuccess_ClientH2 =Success_Client.getText();
			//System.out.println(ActualSuccess_ClientH2);
			String ActualSuccess_ClientH3 = ActualSuccess_ClientH2.replace("\n","");
			//System.out.println(ActualSuccess_ClientH3);
			Assert.assertEquals(ActualSuccess_ClientH3,ExpectedSuccess_ClientH2);

			String ExpClinet_name="INDYFIN";
			String Actual_clinet_name=driver.findElement(By.xpath("//h3[contains(text(),'INDYFIN')]")).getText();
			Assert.assertEquals(Actual_clinet_name, ExpClinet_name);
			
			String ExpClinet_Title="A Robust Financial Advisor Matching Solution";
			String ActualClinet_title=driver.findElement(By.xpath("//h4[contains(text(),'"+ExpClinet_Title+"')]")).getText();
			Assert.assertEquals(ActualClinet_title, ExpClinet_Title);
			
			String ExpCLinet_P="Learn how we developed a financial advisor matching platform to digitize processes and create a curated network & connection between Local Retirement Specialists, Financial Planners, and Investment Managers.";
			String Actual_Client_P =driver.findElement(By.xpath("//p[contains(text(),'Learn how we developed a financial advisor matchin')]")).getText();
			Assert.assertEquals(Actual_Client_P, ExpCLinet_P);		
//Team
			String Expteam="Team";
			Expteam=Expteam.toUpperCase();
			String Actual_Team=driver.findElement(By.xpath("(//h6[text()='Team'])[1]")).getText();
			Assert.assertEquals(Actual_Team, Expteam);
			
			String ExpPeaople="10+ people";
			String Actual_Peaople=driver.findElement(By.xpath("(//h4[text()='10+ people'])[1]")).getText();
			Assert.assertEquals(Actual_Peaople, ExpPeaople);
//PERIOD OF COLLABORATION
			String ExpPeriod_of_Collaboration="Period of Collaboration";
			ExpPeriod_of_Collaboration=ExpPeriod_of_Collaboration.toUpperCase();
			String ActualExpPeriod_of_Collaboration=driver.findElement(By.xpath("(//h6[text()='Period of Collaboration'])[1]")).getText();
			Assert.assertEquals(ActualExpPeriod_of_Collaboration, ExpPeriod_of_Collaboration);
			
			String ExpPresent="2019 - present";
			String Actual_Present=driver.findElement(By.xpath("(//h4[text()='2019 - present'])[1]")).getText();
			Assert.assertEquals(Actual_Present, ExpPresent);
//Client's Location
			String ExpLocation="Client's Location";
			ExpLocation=ExpLocation.toUpperCase();
			String ActualLocation=driver.findElement(By.xpath("//body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/h6[1]")).getText();
			Assert.assertEquals(ActualLocation, ExpLocation);
			
			String Exp_USA="USA";
			String Actual_USA=driver.findElement(By.xpath("(//h4[text()='USA'])[1]")).getText();
			Assert.assertEquals(Actual_USA, Exp_USA);	
		}
//SAKEWIZ TOURISM
		@Test(priority=8,enabled =true)
		public void Tourism() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//WebDriverWait wait=new WebDriverWait(driver, 50);
			//Find element by link text and store in variable "Element"        		
	        WebElement Element2 = driver.findElement(By.xpath("//body[1]/main[1]/section[4]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h6[1]"));

	        //This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element2);
			
//			String ExpTourism="SAKEWIZ TOURISM";
//			String ActualTourism=driver.findElement(By.xpath("//h3[contains(text(),'SAKEWIZ TOURISM')]")).getText();
//			System.out.println(ActualTourism);
//			Assert.assertEquals(ActualTourism, ExpTourism);	
//			//H 4
//			String ExpTourismH4="Explore Breweries and Sakes in Japan";
//			String ActualTourismH4=driver.findElement(By.xpath("//h4[contains(text(),'Explore Breweries and Sakes in Japan')]")).getText();
//			Assert.assertEquals(ActualTourismH4, ExpTourismH4);
//			//Paragraph
//			String ExpTourismP="Explore Breweries and Sakes in Japan";
//			String ActualTourismP=driver.findElement(By.xpath("//p[contains(text(),'Sakewiz came with the concept of “Connecting the w')]")).getText();
//			Assert.assertEquals(ActualTourismP, ExpTourismP);
			
		
		}
	@AfterTest
	public void DearDown() {
		driver.quit();
	}
}

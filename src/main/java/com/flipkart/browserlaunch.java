package com.flipkart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class browserlaunch {
	
	@DataProvider(name="mobile")
	public Object[][] mobileName() {
		return new Object[][] {{"realme"}};
	}
	
	static WebDriver driver;
	static long start;
	
	@BeforeClass (groups="default")
	public static void browserLaunch() {
		System.out.println("browserLaunch");
		//WebDriver.Chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	
	
	@AfterClass
	public static void browserquit() {
		System.out.println("BROWSERQUIT");
		driver.quit();
	}
	
	@BeforeMethod
	public  void starttime() {
	 start=System.currentTimeMillis();
		System.out.println("BEFORE");
	}

	@AfterMethod
		public void endTime() {
		long end=System.currentTimeMillis();
		System.out.println("runningtime"+(end-start));
	}
	@Parameters("URL")
	@Test (priority=1)
	public void login(@Optional("https://www.flipkart.com")String url) {
		System.out.println("method1"); 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
	
		@Test(priority=2, dataProvider="mobile")
	//@Test(groups="smoke")
	public void search(String name) {
		System.out.println("method2");
		//hardcode
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name,Keys.ENTER);
			
			//WebElement searchBox=driver.findElement(By.name("q"));
			//searchBox.sendKeys("realme");
		}
		
	
	@Test
	//@Test(priority=3, invocationCount=2)
	public void mobile() {
		System.out.println("method3");
		
	}
	
	@Test
	//@Test(priority=4, groups="smoke")
	public void getproduct() {
		System.out.println("method4");
	}
	
	@Test
	//@Test(priority=5)
	public void validation() {
		System.out.println("method5");

	}
		

	}



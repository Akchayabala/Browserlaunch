package com.flipkart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tvpurchase {
	static WebDriver driver;
	static long start;
	
	@BeforeClass
	public static void browserlaunch() {
		System.out.println("BROWSERLAUNCH");
	    //WebDriverManager.Chromedriver().setup();
			 ChromeDriver driver=new ChromeDriver();
			 driver.get("https://www.flipkart.com/");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));			 			 
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
	
	@Test
	//@Test(groups="smoke")
	public void login() {
		//System.out.println("method1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("realme");
		
		//WebElement searchBox=driver.findElement(By.name("q"));
		//searchBox.sendKeys("realme");
	}
	
	@Test
	//@Test(groups="smoke")
	public void search() {
		System.out.println("method2");
		
	}
	//@Ignore //ignore specific method
	
	@Test
	//@Test(priority=3, enabled=false)
	public void windowshandling() {
		System.out.println("method3");
		
	}
	
	@Test
	//@Test(priority=4, invocationCount=2)
	public void getproduct() {
		System.out.println("method4");
	}
	
	@Test
	//@Test(priority=5)
	public void validation() {
		System.out.println("method5");

	}
		

	}





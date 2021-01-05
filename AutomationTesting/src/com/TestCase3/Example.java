package com.TestCase3;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Example {

		//Created reference of WebDriver
		public static WebDriver driver;
		
		//Execute before test starts
		@BeforeTest
		public void setUp()
		{
			
			//ChromeDriver object is created, it will open the chrome browser window
			driver = new ChromeDriver();
			
			//maximize the browser window
			driver.manage().window().maximize();
			
			//Added implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Added to wait till page gets loaded completely
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			
		}
		
		//Execute after test execution completes
		@AfterTest
		public void tearDown()
		{
			//Closes all driver session
			driver.quit();
		}
		
		@Test
		public void login()
		{
			//Navigate to lambdatest web site landing page
			driver.get("file:///C:/Users/nikit/Desktop/FB(SPRINGBOOT)/Facebook-UI/Facebook-UI/LoginPage.html");

			//On login page, identify email id field and enter registered email id
			WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Id']"));
			emailField.sendKeys("Monika");
			
			//On login page, identify user password field and enter valid password
			WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			passwordField.sendKeys("123");
			
			//On login page, identify login button and click it
			WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn']"));
			loginButton.click();
			
		}

	}


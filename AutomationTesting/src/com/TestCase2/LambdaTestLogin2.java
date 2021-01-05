package com.TestCase2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LambdaTestLogin2 {

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
		driver.get("https://www.lambdatest.com/");
		
		//Identify and Click on Login link present on right top side
		WebElement logInLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
		logInLink.click();
		
		//On login page, identify email id field and enter registered email id
		WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		emailField.sendKeys("username@gmail.com");
		
		//On login page, identify user password field and enter valid password
		WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordField.sendKeys("Test@123");
		
		//On login page, identify login button and click it
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block mt-3']"));
		loginButton.click();
		
		//Expected URL and Title
		String expectedURL = "https://accounts.lambdatest.com/dashboard";
		String expectedPageTitle = "Welcome - LambdaTest";
		
                         //Actual URL and Title
		String actualURL = driver.getCurrentUrl();
		String actualPageTitle = driver.getTitle();
		
                        System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
					
		//Assertion and verification of expected URL and actual URL
		Assert.assertEquals(actualURL, expectedURL);
		
		//Assertion and verification of expected Page Title and actual Page Title
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}

}
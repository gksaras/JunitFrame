package org.test;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitFramework {

	static WebDriver driver;
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
		driver.quit();
	}
	
	@BeforeClass
	public static void beforeClass() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("Before Class");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
		Date d = new Date();
		System.out.println(d);
	}
	
	@After 
	public void after() {
		System.out.println("After");
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void login() {
		System.out.println("Test");
		WebElement txtUser = driver.findElement(By.id("email"));
		txtUser.sendKeys("greens@gmail.com");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("hello@123");
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}
}

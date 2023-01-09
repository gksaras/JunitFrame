package org.test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

public class Flipkart {
	static WebDriver driver;
	@AfterClass

	
	@BeforeClass
	public static void beforeClass() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		WebElement btnX = driver.findElement(By.xpath("//button[text()='✕']"));
		btnX.click();
		
	}
	
	public static void afterClass() {
		driver.quit();
	}
	
	@Before
	public void before() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@After 
	public void after() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void login() {
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
		WebElement btnLogin = driver.findElement(By.xpath("//a[text()='Login']"));
		btnLogin.click();
		
		WebElement txtuser = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		txtuser.sendKeys("henry@gmail.com");
		
		WebElement txtpwd = driver.findElement(By.xpath("//input[@type='password']"));
		txtpwd.sendKeys("paradox");
		
		WebElement clkLogin= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		clkLogin.click();
	}
}

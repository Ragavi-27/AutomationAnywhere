package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AutomationAnywhereHomePages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereLogo_TestNG {
	AutomationAnywhereHomePages homeObj;
	SoftAssert sa;
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		sa=new SoftAssert();
		homeObj= new AutomationAnywhereHomePages(driver);
	}
	
	@Test(priority = 1, enabled = true, timeOut = 60000)
	public void visibilityOfLogo() {
		sa.assertTrue(homeObj.getLogo().isDisplayed(),"Logo is not present on home page");
		System.out.println("Logo is present on home page");
	}
	
	@Test(priority = 2, enabled = true, timeOut = 60000)
	public void verifyingRequestDemoButton() {
		sa.assertTrue(homeObj.getrequestDemoButton().isDisplayed(),"Request demo button is not present on homepage");
		sa.assertTrue(homeObj.getrequestDemoButton().isEnabled(),"Request demo button is not clickable");
		
		System.out.println("Request demo button is present on homepage and is clickable");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}

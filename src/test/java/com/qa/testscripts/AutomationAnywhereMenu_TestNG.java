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

public class AutomationAnywhereMenu_TestNG {
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
	public void verifyingProductsLink() {
		sa.assertTrue(homeObj.getProductLink().isDisplayed());
		
		homeObj.getProductLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/products"));
		System.out.println("Product link is clickable");
	}
	
	@Test(priority = 2, enabled = true, timeOut = 60000)
	public void verifyingSolutionsLink() {
		sa.assertTrue(homeObj.getSolutionsLink().isDisplayed());
		
		homeObj.getSolutionsLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/solutions"));
		System.out.println("Solution link is clickable");
	}
	
	@Test(priority = 3, enabled = true, timeOut = 60000)
	public void verifyingResourcesLink() {
		sa.assertTrue(homeObj.getResourcesLink().isDisplayed());	
		
		homeObj.getResourcesLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/resources"));
		System.out.println("Resources link is clickable");
	}
	
	@Test(priority = 4, enabled = true, timeOut = 60000)
	public void verifyingBeyondRPALink() {
		sa.assertTrue(homeObj.getBeyondRPALink().isDisplayed());
		
		homeObj.getBeyondRPALink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/rpa/robotic-process-automation"));
		System.out.println("Beyond link is clickable");
	}
	
	@Test(priority = 5, enabled = true, timeOut = 60000)
	public void verifyingCompanyLink() {
		sa.assertTrue(homeObj.getCompanyLink().isDisplayed());
	
		homeObj.getCompanyLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/company/about-us"));
		System.out.println("Solution link is clickable");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}

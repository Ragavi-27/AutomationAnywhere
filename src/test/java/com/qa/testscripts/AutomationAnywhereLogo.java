package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AutomationAnywhereHomePages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereLogo {
	
	public static void main(String[] args) { 
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://www.automationanywhere.com/");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	SoftAssert sa=new SoftAssert();
	
	AutomationAnywhereHomePages homeObj= new AutomationAnywhereHomePages(driver);
	
	//checking logo visibility
	sa.assertTrue(homeObj.getLogo().isDisplayed(),"Logo is not present on home page");
	System.out.println("Logo is present on home page");
	
	//checking request demo button
	sa.assertTrue(homeObj.getrequestDemoButton().isDisplayed(),"Request demo button is not present on homepage");
	sa.assertTrue(homeObj.getrequestDemoButton().isEnabled(),"Request demo button is not clickable");
	
	System.out.println("Request demo button is present on homepage and is clickable");
	
	driver.close();

	}
}

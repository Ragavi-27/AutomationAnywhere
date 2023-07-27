package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AutomationAnywhereHomePages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereMenu {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		SoftAssert sa=new SoftAssert();

		AutomationAnywhereHomePages homeObj= new AutomationAnywhereHomePages(driver);
		
		//Verifying presence of element
		sa.assertTrue(homeObj.getProductLink().isDisplayed());
		sa.assertTrue(homeObj.getSolutionsLink().isDisplayed());
		sa.assertTrue(homeObj.getResourcesLink().isDisplayed());	
		sa.assertTrue(homeObj.getBeyondRPALink().isDisplayed());
		sa.assertTrue(homeObj.getCompanyLink().isDisplayed());
		
		System.out.println("All the elements are present on homepage");
		
		
		//verifying the link
		homeObj.getProductLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/products"));
		System.out.println("Product link is clickable");

		homeObj.getSolutionsLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/solutions"));
		System.out.println("Solution link is clickable");
		
		homeObj.getResourcesLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/resources"));
		System.out.println("Resources link is clickable");
		
		homeObj.getBeyondRPALink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/rpa/robotic-process-automation"));
		System.out.println("Beyond link is clickable");
		
		homeObj.getCompanyLink().click();
		sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/company/about-us"));
		System.out.println("Solution link is clickable");
		
		System.out.println("All the Links are navigating to corresponding page");
		
		sa.assertAll();
		driver.close();

	}

}

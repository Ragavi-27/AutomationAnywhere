package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationAnywhereHomePages {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[1]/div/a/img")
	WebElement logo;
	public WebElement getLogo() {
		return logo;
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[2]/div/div/div[1]/div[2]/a")
	WebElement requestDemoButton;
	public WebElement getrequestDemoButton() {
		return requestDemoButton;
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[1]/a")
	WebElement productLink;
	public WebElement getProductLink() {
		return productLink;
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[2]/a")
	WebElement solutionsLink;
	public WebElement getSolutionsLink() {
		return solutionsLink;
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[3]/a")
	WebElement resourcesLink;
	public WebElement getResourcesLink() {
		return resourcesLink;
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[4]/a")
	WebElement beyondRPALink;
	public WebElement getBeyondRPALink() {
		return beyondRPALink;
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[5]/a")
	WebElement companyLink;
	public WebElement getCompanyLink() {
		return companyLink;
	}
	
	public AutomationAnywhereHomePages(WebDriver rDriver) {
		this.driver=rDriver;
		PageFactory.initElements(driver, this);
	}

}

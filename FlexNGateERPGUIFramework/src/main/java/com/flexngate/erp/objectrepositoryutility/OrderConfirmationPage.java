package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

	WebDriver driver;
	
	@FindBy (xpath = "//*[@id = 'dragDropAreaTabBar']/div/div/div[4]")
	private WebElement verifyOrderPageTxt;
	
	public WebElement getVerifyOrderPageTxt() {
		return verifyOrderPageTxt;
	}

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyOrderPage() {
		
		String actOrder = getVerifyOrderPageTxt().getText();
		return actOrder;
	}
	
}

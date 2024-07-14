package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrderPage {

	WebDriver driver;
	
	@FindBy (xpath = "//select[@id = 'select_demand_reason_id']/following-sibling::span")
	private WebElement channelDD;
	
	@FindBy (name = "save")
	private WebElement createOrderBtn;
	
	
	public WebElement getChannelDD() {
		return channelDD;
	}

	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public CreateOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectChannelConfirmOrder(String channelName) {
		getChannelDD().click();
		driver.findElement(By.xpath("//*[@id = 'mainbody']/span/span/span[2]/ul//li[text() = '"+channelName+"']")).click();
		getCreateOrderBtn().click();	
	}
	
}

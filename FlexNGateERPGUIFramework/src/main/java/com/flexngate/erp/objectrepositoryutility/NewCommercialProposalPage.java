package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCommercialProposalPage {

	WebDriver driver;
	
	@FindBy (xpath = "//select[@id = 'select_demand_reason_id']/following-sibling::span")
	private WebElement sourceDD;
	
	@FindBy (name = "save")
	private WebElement proposalSubmitBtn;
	
	
	public WebElement getSourceDD() {
		return sourceDD;
	}

	public WebElement getProposalSubmitBtn() {
		return proposalSubmitBtn;
	}
	
	public NewCommercialProposalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void createProposalDraft(String tpSource) {
		
		getSourceDD().click();
		driver.findElement(By.xpath("//*[@id='mainbody']/span/span/span[2]/ul//li[text() = '"+tpSource+"']")).click();
		getProposalSubmitBtn().click();
	}
}

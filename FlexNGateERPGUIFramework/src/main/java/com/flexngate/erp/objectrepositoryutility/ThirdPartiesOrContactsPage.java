package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class ThirdPartiesOrContactsPage extends WebDriverUtility {

	WebDriver driver;
	
	@FindBy (linkText = "New Third Party")
	private WebElement newThirdPartyLink;
	
	@FindBy (linkText = "List of Customers")
	private WebElement listOfCustomersLink;
	
	@FindBy (name = "search_nom")
	private WebElement thirdPartyNameEdt;
	
	@FindBy (name = "button_search_x")
	private WebElement searchButton;
	
	@FindBy (xpath = "//*[@id = 'id-right']/div/div[2]/div/div[2]/div//tr[2]/td[1]//a")
	private WebElement thirdPartyNameTxt;
	
	@FindBy (linkText = "Full list")
	private WebElement tpFullListLink;
	
	
	public WebElement getListOfCustomersLink() {
		return listOfCustomersLink;
	}

	public WebElement getnewThirdPartyLink() {
		return newThirdPartyLink;
	}

	public WebElement getThirdPartyNameEdt() {
		return thirdPartyNameEdt;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}	

	public WebElement getThirdPartyNameTxt() {
		return thirdPartyNameTxt;
	}
	
	public WebElement getTpFullListLink() {
		return tpFullListLink;
	}

	public ThirdPartiesOrContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}

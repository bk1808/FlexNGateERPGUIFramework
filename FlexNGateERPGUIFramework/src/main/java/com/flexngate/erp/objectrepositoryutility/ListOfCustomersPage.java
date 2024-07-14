package com.flexngate.erp.objectrepositoryutility;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class ListOfCustomersPage extends WebDriverUtility {

	
	WebDriver driver;
	
	@FindBy (name = "search_nom")
	private WebElement tpNameSearchBx;

	@FindBy (xpath = "//*[@id = 'id-right']/../div[2]/div/form/div[2]/table/tbody/tr/td[9]/span/span/span/span[1]")
	private WebElement natureOfThirdPartyDD;
	
	@FindBy (xpath = "//*[@id = 'mainbody']/span/span/span[1]/input")
	private WebElement natureOfThirdPartyInput;
	
	@FindBy (xpath = "//*[@id=\"select2-search_status-container\"]")
	private WebElement statusDD;
	
	@FindBy (xpath = "//*[@id=\"searchFormList\"]/div[2]/table/tbody/tr[1]/td[10]/span[2]/span/span[1]/input")
	private WebElement statusDDInput;
	
	@FindBy (name = "button_search_x")
	private WebElement searchButton;
	
	@FindBy (xpath = "//span[text()='No record found']")
	private WebElement prospectNatureTP;
		
	
	public WebElement getTpNameSearchBx() {
		return tpNameSearchBx;
	}

	public WebElement getNatureOfThirdPartyDD() {
		return natureOfThirdPartyDD;
	}

	public WebElement getNatureOfThirdPartyInput() {
		return natureOfThirdPartyInput;
	}

	public WebElement getStatusDD() {
		return statusDD;
	}

	public WebElement getStatusDDInput() {
		return statusDDInput;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getProspectNatureTP() {
		return prospectNatureTP;
	}

	public ListOfCustomersPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	public void searchCustomerName(String thirdPartyName, String customerType, String custStatus) {
		getTpNameSearchBx().sendKeys(thirdPartyName);
		getNatureOfThirdPartyDD().click();
		getNatureOfThirdPartyInput().sendKeys(customerType+Keys.ENTER);
		getStatusDD().click();
		getStatusDDInput().sendKeys(custStatus+Keys.ENTER);
		getSearchButton().click();
	}
	
	public void searchCustomerAsProspect(String thirdPartyName, String natureOfCust,
			String customerType) {
		getTpNameSearchBx().sendKeys(thirdPartyName);
		getNatureOfThirdPartyDD().click();
		getNatureOfThirdPartyInput().sendKeys(natureOfCust+Keys.ENTER);
		getStatusDD().click();
		getStatusDDInput().sendKeys(customerType+Keys.ENTER);
		getSearchButton().click();
		
	}
	
	public String verifyCustomerOnList(String thirdPartyName) {	
	String actCustomerName= driver.findElement(By.xpath("//*[@id='id-right']/div/form/div[2]/table/tbody/tr[3]/td[1]//a[text()='"+thirdPartyName+"']")).getText();
	return actCustomerName;
	}
	
	public String verifyCustomerOnList() {
		String actResult = getProspectNatureTP().getText();
		return actResult;
		}
	
}

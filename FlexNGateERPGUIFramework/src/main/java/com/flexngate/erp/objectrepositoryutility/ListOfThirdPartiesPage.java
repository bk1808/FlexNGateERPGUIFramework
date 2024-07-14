package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class ListOfThirdPartiesPage extends WebDriverUtility {

WebDriver driver;

@FindBy (id = "checkforselects")
private WebElement selectAllCheckBx;

@FindBy (xpath = "//select[@id = 'massaction']/following-sibling::span/span//span[text() = '-- Select action --']")
private WebElement selectActionDD;

@FindBy (xpath = "//*[@id  = 'mainbody']/span/span/span[2]/ul//li[text() = 'Delete']")
private WebElement deleteAllTP;

@FindBy (name = "confirmmassaction")
private WebElement clickToConfirmBtn;

@FindBy (id = "confirm")
private WebElement selectConfirmDD;

public WebElement getSelectAllCheckBx() {
	return selectAllCheckBx;
}

public WebElement getSelectActionDD() {
	return selectActionDD;
}



public WebElement getDeleteAllTP() {
	return deleteAllTP;
}

public WebElement getClickToConfirmBtn() {
	return clickToConfirmBtn;
}



public ListOfThirdPartiesPage (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	
public void deleteAllThirdParties() {
	
	getSelectAllCheckBx().click();
	getSelectActionDD().click();
	getDeleteAllTP().click();
	getClickToConfirmBtn().click();
	select(clickToConfirmBtn, null);
}
	
}

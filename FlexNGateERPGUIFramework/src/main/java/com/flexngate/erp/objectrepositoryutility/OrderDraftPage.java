package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class OrderDraftPage extends WebDriverUtility {

	WebDriver driver;

	@FindAll({ @FindBy(id = "prod_entry_mode_free"), @FindBy(name = "prod_entry_mode") })
	private WebElement itemTypeRadioBtn;

	@FindBy(xpath = "//*[@id = 'tablelines']/tbody/tr[2]/td/span[1]/span")
	private WebElement itemTypeDD;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span[2]/ul//li[text() = 'Service']")
	private WebElement itemType;

	@FindBy(id = "dp_desc")
	private WebElement serviceName;

	@FindBy(id = "price_ttc")
	private WebElement servicePriceEdt;

	@FindBy(id = "addline")
	private WebElement addBtn;

	@FindBy(xpath = "//div[@id = 'dragDropAreaTabBar']/following-sibling::div//a[text()='Validate']")
	private WebElement validateBtn;

	@FindBy(xpath = "//*[@id = 'dialog-confirm']/../div[3]/div/button[1]")
	private WebElement orderConfirmDialog;

	public WebElement getItemTypeRadioBtn() {
		return itemTypeRadioBtn;
	}

	public WebElement getItemTypeDD() {
		return itemTypeDD;
	}

	public WebElement getItemType() {
		return itemType;
	}

	public WebElement getServiceName() {
		return serviceName;
	}

	public WebElement getServicePriceEdt() {
		return servicePriceEdt;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getValidateBtn() {
		return validateBtn;
	}

	public WebElement getOrderConfirmDialogPopUp() {
		return orderConfirmDialog;
	}

	public OrderDraftPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addServiceToOrder() {
		getItemTypeRadioBtn().click();
		getItemTypeDD().click();
		getItemType().click();

	}

	public void createService(String serviceName, String servicePrice) {
		getServiceName().sendKeys(serviceName);
		getServicePriceEdt().sendKeys(servicePrice);
		getAddBtn().click();
		getValidateBtn().click();
	}

	public void handleDialogOrderPopup() {
		getOrderConfirmDialogPopUp().click();
	}

}

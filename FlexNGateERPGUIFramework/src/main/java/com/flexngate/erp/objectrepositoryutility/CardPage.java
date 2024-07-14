package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class CardPage extends WebDriverUtility {

	WebDriver driver;

	@FindBy(id = "customer")
	private WebElement customerPageLink;

	@FindBy(linkText = "List of Customers")
	private WebElement listOfCustomersLink;

	@FindBy(xpath = "//*[@id = 'dragDropAreaTabBar']/following-sibling::div/div//a[text() = 'Create proposal']")
	private WebElement createNewProposalBtn;

	@FindBy(xpath = "//*[@id = 'dragDropAreaTabBar']/following-sibling::div/div[2]//a[text()='Create order']")
	private WebElement createOrderBtn;

	@FindBy(id = "action-delete")
	private WebElement deleteBtn;

	public WebElement getCustomerPageLink() {
		return customerPageLink;
	}

	public WebElement getListOfCustomersLink() {
		return listOfCustomersLink;
	}

	public WebElement getCreateNewProposalBtn() {
		return createNewProposalBtn;
	}

	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public CardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToProposalDraftPage() {
		getCustomerPageLink().click();
		mousemoveOnElement(driver, createNewProposalBtn);
		getCreateNewProposalBtn().click();

	}

	public void navigateToOrderDraftPage() {
		getCustomerPageLink().click();
		mousemoveOnElement(driver, createOrderBtn);
		getCreateOrderBtn().click();
	}

	public String verifyCustomer(String customerName) {

		String actCustomerName = driver
				.findElement(By.xpath("//div[@id = 'dragDropAreaTabBar']/../div[2]/div[1]/div/div[4]")).getText();

		return actCustomerName;
	}

}

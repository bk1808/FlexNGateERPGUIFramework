package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class ProposalDraftPage extends WebDriverUtility {

	WebDriver driver;

	@FindBy(xpath = "//span[text() = 'Draft (needs to be validated)']")
	private WebElement draftPageTitle;

	@FindBy(id = "prod_entry_mode_free")
	private WebElement productTypeRadioBtn;

	@FindBy(xpath = "//*[@id = 'tablelines']/tbody/tr[2]/td/span[1]/span")
	private WebElement itemTypeDD;

	@FindBy(id = "dp_desc")
	private WebElement addProductEdt;

	@FindBy(id = "price_ttc")
	private WebElement untiPriceEdt;

	@FindBy(id = "remise_percent")
	private WebElement priceDiscountEdt;

	@FindBy(id = "addline")
	private WebElement addBtn;

	@FindBy(xpath = "//*[@id = 'dragDropAreaTabBar']/following-sibling::div//a[text()='Validate']")
	private WebElement validateBtn;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span[2]/ul//li[text() = 'Product']")
	private WebElement itemType;

	@FindBy(xpath = "//*[@id = 'dialog-confirm']/following-sibling::div/div/button[1]")
	private WebElement proposalConfirmAlert;

	public WebElement getDraftPageTitle() {
		return draftPageTitle;
	}

	public WebElement getProductTypeRadioBtn() {
		return productTypeRadioBtn;
	}

	public WebElement getItemTypeDD() {
		return itemTypeDD;
	}

	public WebElement getProposalConfirmAlert() {
		return proposalConfirmAlert;
	}

	public WebElement getItemType() {
		return itemType;
	}

	public WebElement getAddProductEdt() {
		return addProductEdt;
	}

	public WebElement getUntiPriceEdt() {
		return untiPriceEdt;
	}

	public WebElement getPriceDiscountEdt() {
		return priceDiscountEdt;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getValidateBtn() {
		return validateBtn;
	}

	public ProposalDraftPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String verifyProposalDraft() {
		String actualDraft = getDraftPageTitle().getText();
		return actualDraft;
	}

	public void selectItemTypeFromDD() {
		getProductTypeRadioBtn().click();
		getItemTypeDD().click();
		getItemType().click();
//		driver.findElement(By.xpath("//*[@id='mainbody']/span/span/span[2]/ul//li[text() = 'Product']")).click();
	}

	public void handleProposalAlertPopUp() {

		getProposalConfirmAlert().click();

	}

	public void createProduct(String item, String unitPrice, String discount) {
		getAddProductEdt().sendKeys(item);
		getUntiPriceEdt().sendKeys(unitPrice);
		getPriceDiscountEdt().sendKeys(discount);
		getAddBtn().click();
		getValidateBtn().click();
	}
}

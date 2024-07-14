package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

public class NewThirdPartyProspectCustomerVendor extends WebDriverUtility {

	WebDriver driver;

	@FindAll({ @FindBy(id = "name"), @FindBy(name = "name") })
	private WebElement thirdPartyNameEdt;

	@FindBy(id = "name_alias_input")
	private WebElement aliasNameEdt;

	@FindBy(xpath = "//*[@id='customerprospect']/following-sibling::span")
	private WebElement prospectNameEdt;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement inputProspect;

	@FindBy(id = "customerprospect")
	private WebElement selectProspectDD;

	@FindBy(id = "customer_code")
	private WebElement customerCodeAuto;

	@FindBy(id = "address")
	private WebElement addressEdt;

	@FindBy(id = "zipcode")
	private WebElement zipEdt;

	@FindBy(id = "town")
	private WebElement cityEdt;

	@FindBy(xpath = "//td[text()='Country']/../td[2]/span[2]/span/span/span[1]")
	private WebElement countryEdt;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement inputCountry;

	@FindBy(xpath = "//td[text()='State/Province']/../td[2]/span[2]/span/span/span[1]")
	private WebElement stateEdt;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement inputState;

	@FindBy(id = "phone")
	private WebElement phoneEdt;

	@FindBy(id = "fax")
	private WebElement faxEdt;

	@FindBy(id = "email")
	private WebElement emailEdt;

	@FindBy(id = "url")
	private WebElement webEdt;

	@FindBy(xpath = "//td[text()='Prof Id 1 (TIN)']/../td[2]/input")
	private WebElement tinEdt;

	@FindBy(xpath = "//td[text()='Prof Id 2 (PAN)']/../td[4]/input")
	private WebElement panEdt;

	@FindBy(xpath = "//td[text()='Prof Id 3 (SRVC TAX)']/../td[2]/input")
	private WebElement serviceTaxEdt;

	@FindBy(xpath = "//td[text()='Prof Id 4']/../td[4]/input")
	private WebElement proofID4Edt;

	@FindBy(xpath = "//td[text()='Prof Id 5']/../td[2]/input")
	private WebElement proofID5Edt;

	@FindBy(id = "assujtva_value")
	private WebElement salesTaxChkBx;

	@FindBy(id = "intra_vat")
	private WebElement vatIDEdt;

	@FindBy(xpath = "//td[text()='Third-party type']/../td[2]/span/span/span/span/span")
	private WebElement thirdPartyTypeDD;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement thirdPartyTypeDDInput;

	@FindBy(xpath = "//*[text()='Workforce']/../td[4]/span/span/span/span[1]")
	private WebElement workforceDD;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement workforceDDInput;

	@FindBy(xpath = "//*[text()='Business entity type']/../td[2]/div/span/span/span/span[1]")
	private WebElement busEntityTypeDD;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement businessEntityInput;

	@FindBy(id = "capital")
	private WebElement capitalEdt;

	@FindBy(xpath = "//*[text()='Parent company']/../td[2]/span[2]/span/span/span/span")
	private WebElement parentCompanyDD;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span/input")
	private WebElement parentCompanyInput;

	@FindBy(xpath = "//*[text()='Assigned to sales representative']/../td[2]/span[2]/span/span/ul/li/input")
	private WebElement assignSalesRepDD;

	@FindBy(id = "photoinput")
	private WebElement logoUploadPoP;

	@FindBy(name = "save")
	private WebElement createThirdPartyBtn;

	public WebElement getAliasNameEdt() {
		return aliasNameEdt;
	}

	public WebElement getCustomerCodeAuto() {
		return customerCodeAuto;
	}

	public WebElement getAddressEdt() {
		return addressEdt;
	}

	public WebElement getZipEdt() {
		return zipEdt;
	}

	public WebElement getCityEdt() {
		return cityEdt;
	}

	public WebElement getCountryEdt() {
		return countryEdt;
	}

	public WebElement getInputCountry() {
		return inputCountry;
	}

	public WebElement getStateEdt() {
		return stateEdt;
	}

	public WebElement getInputState() {
		return inputState;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getFaxEdt() {
		return faxEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getWebEdt() {
		return webEdt;
	}

	public WebElement getTinEdt() {
		return tinEdt;
	}

	public WebElement getPanEdt() {
		return panEdt;
	}

	public WebElement getServiceTaxEdt() {
		return serviceTaxEdt;
	}

	public WebElement getProofID4Edt() {
		return proofID4Edt;
	}

	public WebElement getProofID5Edt() {
		return proofID5Edt;
	}

	public WebElement getSalesTaxChkBx() {
		return salesTaxChkBx;
	}

	public WebElement getVatIDEdt() {
		return vatIDEdt;
	}

	public WebElement getThirdPartyTypeDD() {
		return thirdPartyTypeDD;
	}

	public WebElement getThirdPartyTypeDDInput() {
		return thirdPartyTypeDDInput;
	}

	public WebElement getWorkforceDD() {
		return workforceDD;
	}

	public WebElement getWorkforceDDInput() {
		return workforceDDInput;
	}

	public WebElement getBusEntityTypeDD() {
		return busEntityTypeDD;
	}

	public WebElement getBusinessEntityInput() {
		return businessEntityInput;
	}

	public WebElement getCapitalEdt() {
		return capitalEdt;
	}

	public WebElement getParentCompanyDD() {
		return parentCompanyDD;
	}

	public WebElement getParentCompanyInput() {
		return parentCompanyInput;
	}

	public WebElement getAssignSalesRepDD() {
		return assignSalesRepDD;
	}

	public WebElement getLogoUploadPoP() {
		return logoUploadPoP;
	}

	public WebElement getInputProspect() {
		return inputProspect;
	}

	public WebElement getThirdPartyNameEdt() {
		return thirdPartyNameEdt;
	}

	public WebElement getProspectNameEdt() {
		return prospectNameEdt;
	}

	public WebElement getCreateThirdPartyBtn() {
		return createThirdPartyBtn;
	}

	public NewThirdPartyProspectCustomerVendor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProspectCustomerDD(String customerType) {
		getProspectNameEdt().click();
		driver.findElement(By.xpath("//*[@id=\"mainbody\"]/span/span/span[2]/ul//li[text()='" + customerType + "']"))
				.click();
	}

	public void thirdPartyCustomerDetails(String thirdPartyName, String aliasName, String customerType) {
		getThirdPartyNameEdt().sendKeys(thirdPartyName);
		getAliasNameEdt().sendKeys(aliasName);
		selectProspectCustomerDD(customerType);
	}

	public void thirdPartyContactDetails(String address, String zipCode, String city, String country, String state,
			String phone, String fax, String email, String web) {
		getAddressEdt().sendKeys(address);
		getZipEdt().sendKeys(zipCode);
		getCityEdt().sendKeys(city);
		getCountryEdt().click();
		getInputCountry().sendKeys(country + Keys.ENTER);
		getStateEdt().click();
		getInputState().sendKeys(state + Keys.ENTER);
		getPhoneEdt().sendKeys(phone);
		getFaxEdt().sendKeys(fax);
		getEmailEdt().sendKeys(email);
		getWebEdt().sendKeys(web);

	}

	public void thirdPartyProfDetails(String tin, String pan, String serviceTax, String profID4, String profID5,
			String vatID) {
		getTinEdt().sendKeys(tin);
		getPanEdt().sendKeys(pan);
		getServiceTaxEdt().sendKeys(serviceTax);
		getProofID4Edt().sendKeys(profID4);
		getProofID5Edt().sendKeys(profID5);
		getSalesTaxChkBx().click();
		getSalesTaxChkBx().click();
		getVatIDEdt().sendKeys(vatID);

	}

	public void thirdPartyBusinessDetails(String tpType, String workforce, String capital, String parentCo) {
		getThirdPartyTypeDD().click();
		getThirdPartyTypeDDInput().sendKeys(tpType + Keys.ENTER);
		getWorkforceDD().click();
		getWorkforceDDInput().sendKeys(workforce + Keys.ENTER);
		getBusEntityTypeDD().click();
		getBusinessEntityInput().sendKeys("" + Keys.ENTER);
		getCapitalEdt().sendKeys(capital);
		getParentCompanyDD().click();
		getParentCompanyInput().sendKeys(parentCo + Keys.ENTER);

	}

	public String verifyThirdParty(String thirdPartyName) {
		String actTPName = driver.findElement(By.xpath("//div[text()='" + thirdPartyName + "']")).getText();
		return actTPName;
	}

	public String verifyThirdParty(String thirdPartyName, int random) {
		String actTPName = driver.findElement(By.xpath("//div[text()='" + thirdPartyName + random + "']")).getText();
		return actTPName;
	}

}

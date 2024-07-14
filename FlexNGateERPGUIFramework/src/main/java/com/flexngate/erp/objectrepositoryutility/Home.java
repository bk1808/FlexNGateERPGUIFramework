package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flexngate.erp.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Praveen
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class Home extends WebDriverUtility {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='Third-parties']")
	private WebElement thirdPartiesTb;

	@FindBy(xpath = "//a[@class='dropdown-toggle login-dropdown-a']")
	private WebElement logoutImg;

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutBtn;

	@FindBy(id = "mainmenua_home")
	private WebElement homeTabIcon;

	@FindBy(xpath = "//*[@id='blockvmenusearch']/span/span[1]/span/span[1]/span")
	private WebElement searchBarDD;

	@FindBy(xpath = "//*[@id='mainbody']/span/span/span[1]/input")
	private WebElement searchBarDDInput;

	@FindBy(xpath = "//*[@id = 'dragDropAreaTabBar']/div/div/div[4]")
	private WebElement verifyCustName;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getThirdPartiesTb() {
		return thirdPartiesTb;
	}

	public WebElement getHomeTabIcon() {
		return homeTabIcon;
	}

	public WebElement getSearchBarDD() {
		return searchBarDD;
	}

	public WebElement getSearchBarDDInput() {
		return searchBarDDInput;
	}

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyTPSearch(String thirdPartyName) {
		String actualCustName = verifyCustName.getText();
		return actualCustName;
	}
	
	public void searchCustomerHomeSearchBar(String thirdPartyName) {
		getHomeTabIcon().click();
		getSearchBarDD().click();
		getSearchBarDDInput().sendKeys(thirdPartyName+Keys.ENTER);
		
	}

	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		getLogoutImg().click();
		mousemoveOnElement(driver, logoutBtn);
		getLogoutBtn().click();
	}

}

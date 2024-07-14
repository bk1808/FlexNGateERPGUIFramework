package com.flexngate.erp.objectrepositoryutility;

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
public class LoginPage extends WebDriverUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameEdt;

	@FindBy(id = "password")
	private WebElement passwordEdt;

	@FindBy(xpath = "//input[@class='button']")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * login to application based on username, password, url argumnets
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToapp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		// driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}

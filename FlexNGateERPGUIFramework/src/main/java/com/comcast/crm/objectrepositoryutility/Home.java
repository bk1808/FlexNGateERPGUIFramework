package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Tushar Gavare
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class Home extends WebDriverUtility {

	WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//span[@class='mainmenuaspan'and .='Third-parties']")
	private WebElement thirdpartymenuLink;

	public WebElement getThirdpartymenuLink() {
		return thirdpartymenuLink;
	}

	@FindBy(id = "topmenu-login-dropdown")
	private WebElement userImg;

	@FindBy(className = "button-top-menu-dropdown")
	private WebElement signoutLink;
	
	
	public void navigateToThirdpartyPage() {
		
		Actions act = new Actions(driver);
		act.moveToElement(thirdpartymenuLink).click().perform();
		
	}

	public void logoutToApp() throws InterruptedException {
		userImg.click();
		signoutLink.click();

	}

}

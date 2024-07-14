package com.flexngate.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProposalConfirmationPage {

	WebDriver driver;

	@FindBy(xpath = "//span[text() = 'Validated (proposal is open)']")
	private WebElement verifyProposal;

	public WebElement getVerifyProposal() {
		return verifyProposal;
	}

	public ProposalConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyProposal() {

		String actTitle = getVerifyProposal().getText();
		return actTitle;
	}

}

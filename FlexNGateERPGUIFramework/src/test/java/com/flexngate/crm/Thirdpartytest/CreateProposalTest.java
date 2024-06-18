package com.flexngate.crm.Thirdpartytest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.ThirdPartyPage;

/**
 * 
 * @author Tushar Gavare
 *
 */
public class CreateProposalTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void CreateProposalWithSourceTest() throws Throwable {

		// read data from excel
		String source = eLib.getDataFromExcel("Createthirdparty", 1, 3);
		System.out.println(source);

		// step 1: Navigate to the THIRD PARTY module
		Home h = new Home(driver);
		h.navigateToThirdpartyPage();

		// step 2 : Navigate to third party name link
		ThirdPartyPage tpp = new ThirdPartyPage(driver);
		tpp.getthirdpartynamelink().click();

		// step 3 : Navigate to Customer link
		tpp.getcustomerlink().click();

		// step 4 : Click on create proposal button
		tpp.getcreateproposalbtn().click();

		// step 5 : Navigate to Source and click on dropdown
		tpp.getsourcedropdown().click();

		// step 6 : Enter the Commercial Contact and press enter
		tpp.getsourceDDEdt().sendKeys(source + Keys.ENTER);

		// step 7 : Click on Create Draft button
		tpp.getcreatedraftbtn().click();

	}
}
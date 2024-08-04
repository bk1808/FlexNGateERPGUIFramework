package com.flexngate.erp.proposal;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.flexngate.erp.generic.basetest.BaseClass;
import com.flexngate.erp.generic.fileutility.ExcelUtility;
import com.flexngate.erp.generic.webdriverutility.UtilityClassObject;
import com.flexngate.erp.objectrepositoryutility.CardPage;
import com.flexngate.erp.objectrepositoryutility.NewCommercialProposalPage;
import com.flexngate.erp.objectrepositoryutility.ProposalDraftPage;
import com.flexngate.erp.objectrepositoryutility.ProposalConfirmationPage;
import com.flexngate.erp.objectrepositoryutility.Home;
import com.flexngate.erp.objectrepositoryutility.NewThirdPartyProspectCustomerVendor;
import com.flexngate.erp.objectrepositoryutility.ThirdPartiesOrContactsPage;

//@Listeners(com.flexngate.erp.generic.listenerutility.ListImpClass.class)
/**
 * this class methods for creating a third party, created proposal and to verify the proposal creation
 * where the test script data has been provided using @Dataprovider method 
 * @author Praveen
 *  02-Jun-2024
 */

public class CreateNewProposalTest extends BaseClass {

	/**
	 * this method is created to enter all parameters and to create proposal of third party
	 * @param testCaseID
	 * @param testCaseName
	 * @param thirdPartyName
	 * @param aliasName
	 * @param customerType
	 * @param address
	 * @param zipCode
	 * @param city
	 * @param country
	 * @param state
	 * @param phone
	 * @param fax
	 * @param email
	 * @param web
	 * @param tin
	 * @param pan
	 * @param serviceTax
	 * @param profID4
	 * @param profID5
	 * @param vatID
	 * @param tpType
	 * @param workforce
	 * @param capital
	 * @param parentCo
	 * @param assignedTo
	 * @param tpSource
	 * @param testCaseStatus
	 * @param item
	 * @param unitPrice
	 * @param discount
	 * @param proposalValidate
	 * @param status
	 */
	@Test(dataProvider = "getData", groups = "regressionTest")
	public void createProposalWithSourceTest(String testCaseID, String testCaseName, String thirdPartyName,
			String aliasName, String customerType, String address, String zipCode, String city, String country,
			String state, String phone, String fax, String email, String web, String tin, String pan, String serviceTax,
			String profID4, String profID5, String vatID, String tpType, String workforce, String capital,
			String parentCo, String assignedTo, String tpSource, String testCaseStatus, String item, String unitPrice,
			String discount, String proposalValidate, String status) {
		
		int random = jLib.getRandomNumber();
		String expectedDraftTitle = testCaseStatus;
		
		/* step-1: Navigate to third parties tab */
		Home hp = new Home(driver);
		hp.getThirdPartiesTb().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties tab");
		
		/* step-2: Navigate to Third Parties/Contacts page */
		ThirdPartiesOrContactsPage tpc = new ThirdPartiesOrContactsPage(driver);
		tpc.getnewThirdPartyLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties/Contacts page");

		/* step-3: Navigate to New Third Party page and select customer type */
		NewThirdPartyProspectCustomerVendor ntpp = new NewThirdPartyProspectCustomerVendor(driver);
		ntpp.thirdPartyCustomerDetails(thirdPartyName+random, aliasName, customerType);
		UtilityClassObject.getTest().log(Status.INFO, " navigated to New Third Party page and selected customer type");
		
		/* step-4: Check whether customer code is auto generated*/
		String customerCode = ntpp.getCustomerCodeAuto().getText();
		
		UtilityClassObject.getTest().log(Status.INFO, customerCode+" customer code auto generated");

		/* step-5: Input customer contact details */
		ntpp.thirdPartyContactDetails(address, zipCode, city, country, state, phone, fax, email, web);
		UtilityClassObject.getTest().log(Status.INFO, " contact details are input");
		
		/* step-6: Input customer profession details */
		ntpp.thirdPartyProfDetails(tin, pan, serviceTax, profID4, profID5, vatID);
		UtilityClassObject.getTest().log(Status.INFO, " entered customer profession details");
		
		/* step-7: Input customer business details */
		ntpp.thirdPartyBusinessDetails(tpType, workforce, capital, parentCo);
		UtilityClassObject.getTest().log(Status.INFO, " entered customer business details");
		
		/* step-8: Input sales rep details and upload logo and create third party*/
		ntpp.getAssignSalesRepDD().sendKeys(assignedTo + Keys.ENTER);
		wLib.fileUploadPopUp(ntpp.getLogoUploadPoP(), "./testdata/Tek_Pyramid_Logo.JPG");
		ntpp.getCreateThirdPartyBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, " entered sales rep details, uploaded the logo and created third party");

		/* step-9: Navigate to Proposal draft page*/
		CardPage cp = new CardPage(driver);
		cp.navigateToProposalDraftPage();
		UtilityClassObject.getTest().log(Status.INFO, " navigated to proposal draft page");

		/* step-10: Create proposal draft*/
		NewCommercialProposalPage cnpdp = new NewCommercialProposalPage(driver);
		cnpdp.createProposalDraft(tpSource);
		UtilityClassObject.getTest().log(Status.INFO, " proposal draft created");

		/* step-11: Verify proposal draft whether created or not*/
		UtilityClassObject.getTest().log(Status.INFO, " proposal draft verified");
		ProposalDraftPage cpdp = new ProposalDraftPage(driver);
		String actualDraft = cpdp.verifyProposalDraft();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualDraft, expectedDraftTitle);

		/* step-12: Select item as 'product' from dropdown*/
		cpdp.selectItemTypeFromDD();
		UtilityClassObject.getTest().log(Status.INFO, " selected item from dropdown");

		/* step-13: Input 'product' name, price, discount and add product*/
		cpdp.createProduct(item, unitPrice, discount);
		UtilityClassObject.getTest().log(Status.INFO, item +" "+ unitPrice + " "+discount +" entered and added");

		/* step-13: Handle proposal dialog box*/
		cpdp.handleProposalAlertPopUp();
		UtilityClassObject.getTest().log(Status.INFO, " proposal dialog box handled");

		/* step-14: Verify whether the proposal is created or not*/
		String expectedProposalTitle = proposalValidate;
		ProposalConfirmationPage cpp = new ProposalConfirmationPage(driver);
		String actTitle = cpp.verifyProposal();
		soft.assertEquals(actTitle, expectedProposalTitle);
		UtilityClassObject.getTest().log(Status.INFO, " proposal created and verified==PASS==");
		
		soft.assertAll();

	}

	/**
	 * this method will provide the test script data in the run-time
	 * @return
	 * @throws Throwable
	 */
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowcount("createTP");
		int cellCount = eLib.getCellCount("createTP");

		Object[][] objArray = new Object[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 1; j < cellCount - 1; j++) {

				objArray[i][j] = eLib.getDataFromExcel("createTP", i + 1, j);
				objArray[i][j] = eLib.getDataFromExcel("createTP", i + 1, j);

			}

		}

		return objArray;
	}

}

package com.flexngate.erp.prospects;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.flexngate.erp.generic.basetest.BaseClass;
import com.flexngate.erp.generic.fileutility.ExcelUtility;
import com.flexngate.erp.generic.webdriverutility.UtilityClassObject;
import com.flexngate.erp.objectrepositoryutility.Home;
import com.flexngate.erp.objectrepositoryutility.NewThirdPartyProspectCustomerVendor;
import com.flexngate.erp.objectrepositoryutility.ThirdPartiesOrContactsPage;

import junit.framework.Assert;

//@Listeners(com.flexngate.erp.generic.listenerutility.ListImpClass.class)
/**
 * this class has methods for creating new prospect and provide the test script data
 * in the run time 
 * @author Praveen
 *  02-Jun-2024
 */
public class CreateNewProspectTest extends BaseClass {

	/**
	 * this method is crated to enter data into all text fields and confirm third party creation 
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
	public void createThirdPartyWithValidInputsTest(String testCaseID, String testCaseName, String thirdPartyName,
			String aliasName, String customerType, String address, String zipCode, String city, String country,
			String state, String phone, String fax, String email, String web, String tin, String pan, String serviceTax,
			String profID4, String profID5, String vatID, String tpType, String workforce, String capital,
			String parentCo, String assignedTo, String tpSource, String testCaseStatus, String item, String unitPrice,
			String discount, String proposalValidate, String status) {

		int random = jLib.getRandomNumber();
		String expectedTPName = thirdPartyName+random;

		/* step-1: Navigate to third parties tab */
		Home hp = new Home(driver);
		hp.getThirdPartiesTb().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties tab");
		
		/* step-2: Navigate to Third Parties/Contacts page */
		ThirdPartiesOrContactsPage tpc = new ThirdPartiesOrContactsPage(driver);
		tpc.getnewThirdPartyLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated Third Parties/Contacts page");
		
		/* step-3: Navigate to New Third Party page and select customer type */
		NewThirdPartyProspectCustomerVendor ntpp = new NewThirdPartyProspectCustomerVendor(driver);
		ntpp.thirdPartyCustomerDetails(thirdPartyName+random, aliasName, customerType);
		UtilityClassObject.getTest().log(Status.INFO, " navigated to New Third Party page and selected customer type");
		
		/* step-4: Check whether customer code is auto generated*/
		String customerCode = ntpp.getCustomerCodeAuto().getText();
		UtilityClassObject.getTest().log(Status.INFO, customerCode + " auto generated");

		/* step-5: Input customer contact details */
		ntpp.thirdPartyContactDetails(address, zipCode, city, country, state, phone, fax, email, web);
		UtilityClassObject.getTest().log(Status.INFO, " contact details are input");
		
		/* step-6: Input customer profession details */
		ntpp.thirdPartyProfDetails(tin, pan, serviceTax, profID4, profID5, vatID);
		UtilityClassObject.getTest().log(Status.INFO, " entered customer profession details");
		
		/* step-7: Input customer business details */
		ntpp.thirdPartyBusinessDetails(tpType, workforce, capital, parentCo);
		UtilityClassObject.getTest().log(Status.INFO, " entered customer business details");
		
		/* step-8: Input sales rep details and upload logo */
		ntpp.getAssignSalesRepDD().sendKeys(assignedTo + Keys.ENTER);		
		wLib.fileUploadPopUp(ntpp.getLogoUploadPoP(), "./testdata/Tek_Pyramid_Logo.JPG");
		UtilityClassObject.getTest().log(Status.INFO, " entered sales rep details and uploaded the logo");
		
		/* step-9: Verify whether third party is created or not */
		ntpp.getCreateThirdPartyBtn().click();
		String actTPName = ntpp.verifyThirdParty(thirdPartyName+random);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName+random + " third party created and verified==PASS==");
		boolean thirdParty = actTPName.contains(expectedTPName);
		Assert.assertTrue(thirdParty);

	}

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

package com.flexngate.erp.thirdparties;

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

/**
 * This class has methods to create new third party and to pass the data in
 * runtime
 * @author Praveen
 * 02-Jun-2024
 */
//@Listeners(com.flexngate.erp.generic.listenerutility.ListImpClass.class)
public class CreateNewThirdPartyTest extends BaseClass {

	/**
	 * this method is used to create third party and to input all the details
	 * 
	 * @param testCaseID
	 * @param testCaseName
	 * @param thirdPartyName
	 * @param customerType
	 * @param customerStatus
	 * @param status
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData", groups = "smokeTest")
	public void createThirdPartyTest(String testCaseID, String testCaseName, String thirdPartyName, String customerType,
			String customerStatus, String status) throws InterruptedException {

		int random = jLib.getRandomNumber();
		String expectedTPName = thirdPartyName;

		/* step-1: Navigate to third parties tab */
		Home hp = new Home(driver);
		hp.getThirdPartiesTb().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties tab");

		/* step-2: Navigate to new third party page */
		ThirdPartiesOrContactsPage tpc = new ThirdPartiesOrContactsPage(driver);
		tpc.getnewThirdPartyLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties/Contacts page");

		/* step-3: Navigate to New Third Party (prospect, customer, vendor) page */
		NewThirdPartyProspectCustomerVendor ntpp = new NewThirdPartyProspectCustomerVendor(driver);
		ntpp.getThirdPartyNameEdt().sendKeys(thirdPartyName+random);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName +random+ " navigated to New Third Party (prospect, customer, vendor) page");

		/* step-4: Input customer type */
		ntpp.selectProspectCustomerDD(customerType);
		UtilityClassObject.getTest().log(Status.INFO, customerType + " selected");

		/* step-4: Verify third party details */
		ntpp.getCreateThirdPartyBtn().click();
		String actTPName = ntpp.verifyThirdParty(thirdPartyName+random);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName+random + " Third Party name and details displayed and verified==PASS==");
		boolean thirdParty = actTPName.contains(expectedTPName);
		Assert.assertTrue(thirdParty);

	}

	/**
	 * this method is created to pass the test script data throught Object[][] array
	 * using @DataProvider annotation
	 * 
	 * @return
	 * @throws Throwable
	 */
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowcount("createPros");
		int cellCount = eLib.getCellCount("createPros");

		Object[][] objArray = new Object[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 1; j <= cellCount - 1; j++) {

				objArray[i][j] = eLib.getDataFromExcel("createPros", i + 1, j);
				objArray[i][j] = eLib.getDataFromExcel("createPros", i + 1, j);

			}

		}

		return objArray;
	}

}

package com.flexngate.erp.thirdparties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.flexngate.erp.generic.basetest.BaseClass;
import com.flexngate.erp.generic.fileutility.ExcelUtility;
import com.flexngate.erp.generic.webdriverutility.UtilityClassObject;
import com.flexngate.erp.objectrepositoryutility.CardPage;
import com.flexngate.erp.objectrepositoryutility.Home;
import com.flexngate.erp.objectrepositoryutility.ListOfCustomersPage;
import com.flexngate.erp.objectrepositoryutility.NewThirdPartyProspectCustomerVendor;
import com.flexngate.erp.objectrepositoryutility.ThirdPartiesOrContactsPage;

//@Listeners(com.flexngate.erp.generic.listenerutility.ListImpClass.class)
/**
 * This class has methods to create new third party as 'customer' and to provide
 * the data through @Dataprovider annotation in the run-time
 * 
 * @author Praveen 02-Jun-2024
 */
public class CreateNewCustomerTest extends BaseClass {

	/**
	 * This method will provide the test-script data in the run-time from
	 * 'createCust.xlsx'
	 * 
	 * @param testCaseID
	 * @param testCaseName
	 * @param thirdPartyName
	 * @param customerType
	 * @param custStatus
	 * @param natureOfCust
	 * @param status
	 */
	@Test(dataProvider = "getData", groups = "regressionTest")
	public void createNewThirdPartyAsCustomerTest(String testCaseID, String testCaseName, String thirdPartyName,
			String customerType, String custStatus, String natureOfCust, String status) {

		int random = jLib.getRandomNumber();

		String expectedCustName = thirdPartyName + random;

		/* step-1: Navigate to third parties tab */
		Home hp = new Home(driver);
		hp.getThirdPartiesTb().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties tab");

		/* step-2: Navigate to Third Parties/Contacts page */
		ThirdPartiesOrContactsPage tpc = new ThirdPartiesOrContactsPage(driver);
		tpc.getnewThirdPartyLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated Third Parties/Contacts page");

		/*
		 * step-3: Navigate to New Third Party page and select customer type
		 */
		NewThirdPartyProspectCustomerVendor ntpp = new NewThirdPartyProspectCustomerVendor(driver);
		ntpp.getThirdPartyNameEdt().sendKeys(thirdPartyName + random);
		ntpp.selectProspectCustomerDD(customerType);
		ntpp.getCreateThirdPartyBtn().click();
		UtilityClassObject.getTest().log(Status.INFO,
				thirdPartyName + random + " navigated to New Third Party page and selected customer type");

		/* step-4: Verify whether the third party is created as 'Customer' or not */
		CardPage cp = new CardPage(driver);
		cp.getCustomerPageLink().click();
		String actCustName = cp.verifyCustomer(thirdPartyName);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName + random + " verified==PASS==");
		boolean thirdParty = actCustName.contains(expectedCustName);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(thirdParty);

		/* step-5: Navigate to list of customers */
		cp.getListOfCustomersLink().click();
		UtilityClassObject.getTest().log(Status.INFO, " navigated to list of customers page");

		/* step-6: Search for 'Customer' name */
		ListOfCustomersPage locp = new ListOfCustomersPage(driver);
		locp.searchCustomerName(thirdPartyName + random, customerType, custStatus);
		UtilityClassObject.getTest().log(Status.INFO, " searched for customer name");

		/* step-7: Verify whether the customer details is displayed or not */
		String actCustomerName = locp.verifyCustomerOnList(thirdPartyName + random);
		boolean actCust = actCustomerName.contains(expectedCustName);
		soft.assertTrue(actCust);
		UtilityClassObject.getTest().log(Status.INFO,
				thirdPartyName + random + " customer details is displayed and verified==PASS==");

		/* step-8: Navigate to List of customers */
		cp.getListOfCustomersLink().click();
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName + random + " navigate to list of customers page");

		/*
		 * step-9: Search for 'Customer' name and choose nature of third party as
		 * 'Prospect'
		 */
		locp.searchCustomerAsProspect(thirdPartyName + random, natureOfCust, customerType);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName + random + " searched customer as 'Prospect'");

		/* step-10: Verify whether the customer details is displayed as 'Prospect' */
		String actCustomer = locp.verifyCustomerOnList();
		soft.assertNotEquals(actCustomer, expectedCustName);
		UtilityClassObject.getTest().log(Status.INFO,
				thirdPartyName + random + " customer details did not display for 'Prospect' and verified==PASS==");

		/* step-11: Search for 'Customer' on Home page seach bar */
		hp.searchCustomerHomeSearchBar(thirdPartyName + random);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName + random + " searched for customer on home page");

		/* step-12: Verify whether the customer details is displayed */
		String actualCustomerName = hp.verifyTPSearch(thirdPartyName + random);
		boolean actCusName = actualCustomerName.contains(expectedCustName);
		soft.assertTrue(actCusName);
		UtilityClassObject.getTest().log(Status.INFO,
				thirdPartyName + random + " customer details displayed and verified==PASS==");

		soft.assertAll();

	}

	/**
	 * this method provides the test script data from 2nd cell onwards till the last
	 * but one cell, the condition is set accordingly in the second for loop [j=1 &
	 * j<cellcount - 1] also, to exclude the first row [i+1] to exclude the frist
	 * row as it has attribute names in the excel file [createCust.xlsx]
	 * 
	 * @return
	 * @throws Throwable
	 */
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowcount("createCust");
		int cellCount = eLib.getCellCount("createCust");

		Object[][] objArray = new Object[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 1; j < cellCount - 1; j++) {

				objArray[i][j] = eLib.getDataFromExcel("createCust", i + 1, j);
				objArray[i][j] = eLib.getDataFromExcel("createCust", i + 1, j);

			}

		}

		return objArray;
	}

}

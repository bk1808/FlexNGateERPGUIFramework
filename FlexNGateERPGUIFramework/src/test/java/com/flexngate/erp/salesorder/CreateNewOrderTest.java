package com.flexngate.erp.salesorder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.flexngate.erp.generic.basetest.BaseClass;
import com.flexngate.erp.generic.fileutility.ExcelUtility;
import com.flexngate.erp.generic.webdriverutility.UtilityClassObject;
import com.flexngate.erp.objectrepositoryutility.CardPage;
import com.flexngate.erp.objectrepositoryutility.CreateOrderPage;
import com.flexngate.erp.objectrepositoryutility.Home;
import com.flexngate.erp.objectrepositoryutility.NewThirdPartyProspectCustomerVendor;
import com.flexngate.erp.objectrepositoryutility.OrderConfirmationPage;
import com.flexngate.erp.objectrepositoryutility.OrderDraftPage;
import com.flexngate.erp.objectrepositoryutility.ThirdPartiesOrContactsPage;

//@Listeners(com.flexngate.erp.generic.listenerutility.ListImpClass.class)
/**
 * this class has methods to create and validate the order and provide the test
 * script @Dataprovider data in the run-time
 * @author Praveen
 *  02-Jun-2024
 */
public class CreateNewOrderTest extends BaseClass {
	/**
	 * this method is used to create the sales order and validate the same
	 * @param testCaseID
	 * @param testCaseName
	 * @param thirdPartyName
	 * @param customerType
	 * @param customerStatus
	 * @param channelName
	 * @param serviceName
	 * @param servicePrice
	 * @param status
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData", groups = "smokeTest")
	public void validateOrderTest(String testCaseID, String testCaseName, String thirdPartyName, String customerType,
			String customerStatus, String channelName, String serviceName, String servicePrice, String status)
			throws InterruptedException {

		int random = jLib.getRandomNumber();
		String expectedTPName = thirdPartyName;
		
		/* step-1: Navigate to third parties tab */
		Home hp = new Home(driver);
		hp.getThirdPartiesTb().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties tab");
		
		/* step-2: Navigate to Third Parties/Contacts page */
		ThirdPartiesOrContactsPage tpc = new ThirdPartiesOrContactsPage(driver);
		tpc.getnewThirdPartyLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to Third Parties/Contacts page");

		/*step-3: Navigate to New Third Party (prospect, customer, vendor)*/
		NewThirdPartyProspectCustomerVendor ntpp = new NewThirdPartyProspectCustomerVendor(driver);
		ntpp.getThirdPartyNameEdt().sendKeys(thirdPartyName+random);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName+random + " navigated New Third Party (prospect, customer, vendor) page");

		/*step:-4: Select 'Prospect' as new third party from dropdown*/
		ntpp.selectProspectCustomerDD(customerType);
		UtilityClassObject.getTest().log(Status.INFO, customerType + " selected prospect");

		/*step-5: Confirm new third party creation and verify the third party on Card details page*/
		ntpp.getCreateThirdPartyBtn().click();
		String actTPName = ntpp.verifyThirdParty(thirdPartyName+random);
		boolean thirdParty = actTPName.contains(expectedTPName);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(thirdParty);
		UtilityClassObject.getTest().log(Status.INFO, thirdPartyName+random + " Third Party name and details displayed verified==PASS==");
		
		/*step-6: Navigate to create sales order page*/
		CardPage cp = new CardPage(driver);
		cp.navigateToOrderDraftPage();
		UtilityClassObject.getTest().log(Status.INFO, " navigated to create sales order page");
		
		/*step-7: Select the channel of source for customer and validate order creation*/
		CreateOrderPage cop = new CreateOrderPage(driver);
		cop.selectChannelConfirmOrder(channelName);
		UtilityClassObject.getTest().log(Status.INFO, channelName+ " selected and validated");

		/*step-8: On the order draft page, select service, price and confirm the order*/
		OrderDraftPage odp = new OrderDraftPage(driver);
		odp.addServiceToOrder();
		odp.createService(serviceName, servicePrice);
		odp.handleDialogOrderPopup();
		UtilityClassObject.getTest().log(Status.INFO, serviceName + servicePrice + " selected and order confirmed");

		/*step-9: Verify the order creation on confrimation page*/
		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		String actOrder = ocp.verifyOrderPage();
		soft.assertNotNull(actOrder);
		UtilityClassObject.getTest().log(Status.INFO, " sales order is verified==PASS==");
		soft.assertAll();
		

	}

	/**
	 * this method will provide the test script data in the run time to
	 * create sales order
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

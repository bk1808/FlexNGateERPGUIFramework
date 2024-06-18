package com.flexngate.crm.Thirdpartytest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.ThirdPartyPage;

/**
 * 
 * @author Tushar Gavare
 * 
 */
public class CreateProspectTest extends BaseClass {

	@Test(groups = { "RegressionTest" })
	public void CreateNewProspectTest() throws Throwable {

		/* read Crmtestscriptdata from excel */
		String thirdpartyname = eLib.getDataFromExcel("Createthirdparty", 1, 2);
		String aliasname = eLib.getDataFromExcel("Createthirdparty", 1, 4);
		String address = eLib.getDataFromExcel("Createthirdparty", 1, 5);
		String zipcode = eLib.getDataFromExcel("Createthirdparty", 1, 6);
		String city = eLib.getDataFromExcel("Createthirdparty", 1, 7);
		String phno = eLib.getDataFromExcel("Createthirdparty", 1, 8);
		String fax = eLib.getDataFromExcel("Createthirdparty", 1, 9);
		String email = eLib.getDataFromExcel("Createthirdparty", 1, 10);
		String web = eLib.getDataFromExcel("Createthirdparty", 1, 11);
		String profid1 = eLib.getDataFromExcel("Createthirdparty", 1, 12);
		String profid2 = eLib.getDataFromExcel("Createthirdparty", 1, 13);
		String profid3 = eLib.getDataFromExcel("Createthirdparty", 1, 14);
		String profid4 = eLib.getDataFromExcel("Createthirdparty", 1, 15);
		String profid5 = eLib.getDataFromExcel("Createthirdparty", 1, 16);
		String vatid = eLib.getDataFromExcel("Createthirdparty", 1, 17);
		String capital = eLib.getDataFromExcel("Createthirdparty", 1, 18);

		// step 1: Navigate to the THIRD PARTY module
		Home h = new Home(driver);
		h.navigateToThirdpartyPage();

		// step 2 : Navigate to New Prospect
		ThirdPartyPage tpp = new ThirdPartyPage(driver);
		tpp.getnewprospectlnk().click();

		// step 3 : Enter valid third party name in the Third-party name textbox
		tpp.createThirdpartyname(thirdpartyname);

		// step 4 : Enter Alias name
		tpp.getaliasnameEdtbx().sendKeys(aliasname);

		// step 5 : Select Prospect or Customer from the drop down
		tpp.getprospectcustomerdd().click();
		tpp.getprospectcustomerseldd().click();

		// step 6 : Enter third party address
		tpp.getaddrestxtbx().sendKeys(address);

		// step 7 : Enter ZIP Code
		tpp.getzipcodetxtbx().sendKeys(zipcode);

		// step 8 : Enter City name
		tpp.getcitytxtbx().sendKeys(city);

		// step 9 : click State from dropdown
		tpp.getstatetxtbx().click();

		// Select State Dropdown
		tpp.getselstatetxtbx().click();
	
		// step 10 : Enter phone number
		tpp.getphnotxtbx().sendKeys(phno);

		//step 11 : Enter fax Number
		tpp.getfaxtxtbx().sendKeys(fax);
		
		//step 12 : Enter email
		tpp.getemailtxtbx().sendKeys(email);
		
		//step 13 : Enter website
		tpp.getwebtxtbx().sendKeys(web);
	
		//step 14 : Enter Prof Id 1 (TIN)
		tpp.getprofid1txtbx().sendKeys(profid1);
	
		//step 15 : Enter Prof Id 2 (PAN)
		tpp.getprofid2txtbx().sendKeys(profid2);

		//step 16 : Enter Prof Id 3 (SRVC TAX)
		tpp.getprofid3txtbx().sendKeys(profid3);
		
		//step 17 : Enter Prof Id 4
		tpp.getprofid4txtbx().sendKeys(profid4);

		//step 18 : Enter Prof Id 5
		tpp.getprofid5txtbx().sendKeys(profid5);
		
		//step 16 : Enter Vat Id 
		tpp.getvatidtxtbx().sendKeys(vatid);
		
		
		//step 17 : Select Third party type from dropdown
		tpp.getthirdpartytypeddclick().click();
		tpp.getthirdpartytypeseldd().click();
		
		//step 18 : Select Workforce from dropdown
        tpp.getworkforceddclick().click();
        tpp.getworkforceddsel().click();
      
       //step 19 : Enter capital income of company in  Indian rupees
        tpp.getcapitaltxtbx().sendKeys(capital);
        Thread.sleep(4000);
		
       //step 20 : Select parent company
        tpp.getparentcompanydd().click();
        tpp.getparentcompanyseldd().click();
        
       //step 21 : Select Assigned to sales representative
        tpp.getassignSalesrepclick().click();
        tpp.getassignSalesrepsel().click();
		
       //step 22 : Click on Choose file Upload Button
        tpp.fileUploadtekpydlogo();
        
       //step 23 : Click on create third party button
        tpp.getcreateThdprtyBtn().click();
		
		
	}
}
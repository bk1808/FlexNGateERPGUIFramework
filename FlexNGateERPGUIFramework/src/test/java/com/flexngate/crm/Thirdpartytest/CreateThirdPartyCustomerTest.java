package com.flexngate.crm.Thirdpartytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.ThirdPartyPage;

/**
 * 
 * @author Tushar Gavare
 * 
 */
public class CreateThirdPartyCustomerTest extends BaseClass {

	@Test
	public void CreateNewThirdPartyAsCustomerTest() throws Throwable {


		/* read Crmtestscriptdata from excel */
		String thirdpartyname = eLib.getDataFromExcel("Createthirdparty", 1, 2);

		// step 1: Navigate to the THIRD PARTY module
		Home h = new Home(driver);
		h.navigateToThirdpartyPage();

		// step 2: navigate to the new THIRD PARTY Page
		ThirdPartyPage tpp = new ThirdPartyPage(driver);
		tpp.getNewthirdpartyLink().click();

		// step 3: Enter third party name in the Third-party name textbox
		tpp.createThirdpartyname(thirdpartyname);

		// step 4: Select Prospect/Customer from the dropdown list
		tpp.getprospectdropdown().click();
		tpp.getselectprospect().click();


		// step 5: Click on create third party button
		tpp.getcreatethirdpartybtn().click();

		// step 6: verify the third party name
		driver.findElement(By.xpath("//div[text()='" + thirdpartyname + "']")).click();
		String actThridpartyname = tpp.gettpn().getText();
		System.out.println(actThridpartyname);
		boolean status = actThridpartyname.contains(thirdpartyname);
		Assert.assertTrue(status);
		System.out.println(thirdpartyname +" information is verified ===>Pass");

		// step 7 : Navigate to the list of Customers
		tpp.getlistcustlnk().click();

		// step 8 : Enter third party name in third party name search box
		tpp.gettpsrchbx().sendKeys(thirdpartyname);

		// step 9 : Click on search icon
	
		tpp.gettpsrchbtbn().click();


		// step 10 : Click on third party name link
		tpp.getthirdpartynamelinkk().click();
		
//		// step 11 : Navigate to the List of the customers
//		tpp.getlistcustlnk().click();
//
//		// step 12 : Enter third party name in third party name search box
//		tpp.gettpsrchbx().sendKeys(thirdpartyname);
//
//		// step 13 : Select nature of third party prospect from dropdown
//		tpp.getthirdpartytypeclick().click();
//		
//		tpp.getthirdpartytypeproclick().click();
//
//		// step 14 : Click on search icon
//	//	tpp.gettpsrchbx().sendKeys(thirdpartyname);
//		tpp.gettpsrchbtbn().click();
//
//		// step 15 : Click on third party name link
//		tpp.getthirdpartynamelinkk().click();
//		Thread.sleep(4000);
//
//		// step 16: verify the third party name
//		driver.findElement(By.xpath("//div[text()='" + thirdpartyname + "']")).click();
//		String actThridpartyname1= tpp.gettpn().getText();
//		System.out.println(actThridpartyname);
//		boolean status1 = actThridpartyname1.contains(thirdpartyname);
//		Assert.assertTrue(status1);
//		System.out.println(thirdpartyname +" information is verified ===>Pass");


		// step 17 : Navigate to Contacts/Addresses tab
		tpp.getconaddtab().click();
		Thread.sleep(9000);

       // step 18 : Navigate to related items tab
		tpp.getrelateditmtab().click();

		// step 19 : Navigate to payment methods page
		tpp.getpaymthdtab().click();
		
		// step 20 : Navigate to Notes tab
        tpp.getnotestab().click();
        
        // step 21 : Navigate to linked files tab
        tpp.getlinkedfilestab().click();
        
        // step 22 : Navigate to events tab
        tpp.geteventstab().click();
        
        // step 23 : Click on back to list link
        tpp.getbacklst().click();
        

	}

}

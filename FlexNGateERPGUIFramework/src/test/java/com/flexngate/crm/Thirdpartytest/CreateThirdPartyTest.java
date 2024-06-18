package com.flexngate.crm.Thirdpartytest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.ThirdPartyPage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

/**
 * 
 * @author Tushar Gavare
 *
 */
public class CreateThirdPartyTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void CreateNewThirdPartyWithProspectTest() throws Throwable {

		/* read Crmtestscriptdata from excel */
		String thirdpartyname = eLib.getDataFromExcel("Createthirdparty", 1, 2);

		// step 2: navigate to the THIRD PARTY module
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

	}

}

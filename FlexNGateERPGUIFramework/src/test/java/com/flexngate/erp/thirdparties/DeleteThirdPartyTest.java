package com.flexngate.erp.thirdparties;

import org.testng.annotations.Test;

import com.flexngate.erp.generic.basetest.BaseClass;
import com.flexngate.erp.objectrepositoryutility.CardPage;
import com.flexngate.erp.objectrepositoryutility.Home;
import com.flexngate.erp.objectrepositoryutility.ThirdPartiesOrContactsPage;

public class DeleteThirdPartyTest extends BaseClass {

	@Test
	public void deleteThirdParty() {
		
		Home hp = new Home(driver);
		hp.getThirdPartiesTb().click();
		
		ThirdPartiesOrContactsPage tpcp = new ThirdPartiesOrContactsPage(driver);
		tpcp.getTpFullListLink().click();
		
		CardPage cp = new CardPage(driver);
		cp.getDeleteBtn().click();
		
	}
	
	
}

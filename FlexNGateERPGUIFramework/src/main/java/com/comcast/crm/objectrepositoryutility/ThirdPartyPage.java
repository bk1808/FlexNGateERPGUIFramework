package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Tushar Gavare
 * 
 */

public class ThirdPartyPage extends WebDriverUtility {

	WebDriver driver;

	public ThirdPartyPage(WebDriver driver) { // Rule 3 : Object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='New Third Party']")
	private WebElement newthirdpartyLink;

	public WebElement getNewthirdpartyLink() {
		return newthirdpartyLink;
	}

	@FindBy(id = "name")
	private WebElement Thirdpartynametxtbx;

	public WebElement getThirdpartynametxtbx() {
		return Thirdpartynametxtbx;
	}

	@FindBy(xpath = "//input[@class='button button-save ']")
	private WebElement createthirdpartybtn;

	public WebElement getcreatethirdpartybtn() {
		return createthirdpartybtn;

	}

	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single flat']")
	private WebElement prospectdropdown;

	public WebElement getprospectdropdown() {
		return prospectdropdown;
	}

	@FindBy(xpath = "//li[text()='Prospect']")
	private WebElement selectprospect;

	public WebElement getselectprospect() {
		return selectprospect;
	}

	@FindBy(xpath = "//div[@class='inline-block floatleft valignmiddle maxwidth750 marginbottomonly refid refidpadding']")
	private WebElement tpn;

	public WebElement gettpn() {
		return tpn;
	}

	@FindBy(xpath = "//a[@class='classfortooltip refurl valignmiddle']")
	private WebElement thirdpartynamelink;

	public WebElement getthirdpartynamelink() {
		return thirdpartynamelink;
	}

	@FindBy(xpath = "//a[@id='customer']")
	private WebElement customerlink;

	public WebElement getcustomerlink() {
		return customerlink;
	}

	@FindBy(xpath = "//a[@class='butAction'and text()='Create proposal']")
	private WebElement createproposalbtn;

	public WebElement getcreateproposalbtn() {
		return createproposalbtn;
	}

	@FindBy(id = "select2-select_demand_reason_id-container")
	private WebElement sourcedropdown;

	public WebElement getsourcedropdown() {
		return sourcedropdown;
	}

	@FindBy(xpath = "//input[@aria-controls='select2-select_demand_reason_id-results']")
	private WebElement sourceDDEdt;

	public WebElement getsourceDDEdt() {
		return sourceDDEdt;
	}

	@FindBy(xpath = "//input [@class='button button-save ']")
	private WebElement createdraftbtn;

	public WebElement getcreatedraftbtn() {
		return createdraftbtn;
	}

	@FindBy(xpath = "//a[@class='vsmenu'and text()='New Prospect' ]")
	private WebElement newprospectlnk;

	public WebElement getnewprospectlnk() {
		return newprospectlnk;
	}

	@FindBy(xpath = "//input[@id='name_alias_input']")
	private WebElement aliasnameEdtbx;

	public WebElement getaliasnameEdtbx() {
		return aliasnameEdtbx;
	}

	@FindBy(xpath = "//span[@id='select2-customerprospect-container']")
	private WebElement prospectcustomerdd;

	public WebElement getprospectcustomerdd() {
		return prospectcustomerdd;
	}

	@FindBy(xpath = "//li[@class='select2-results__option'and text()='Customer']")
	private WebElement prospectcustomerseldd;

	public WebElement getprospectcustomerseldd() {
		return prospectcustomerseldd;
	}

	@FindBy(id = "address")
	private WebElement addrestxtbx;

	public WebElement getaddrestxtbx() {
		return addrestxtbx;
	}

	@FindBy(id = "zipcode")
	private WebElement zipcodetxtbx;

	public WebElement getzipcodetxtbx() {
		return zipcodetxtbx;
	}

	@FindBy(id = "town")
	private WebElement citytxtbx;

	public WebElement getcitytxtbx() {
		return citytxtbx;
	}

	@FindBy(xpath = "//span[@id='select2-state_id-container']")
	private WebElement statetxtbx;

	public WebElement getstatetxtbx() {
		return statetxtbx;
	}

	@FindBy(xpath = "//li[@class='select2-results__option'and text()='GA - Goa']")
	private WebElement selstatetxtbx;

	public WebElement getselstatetxtbx() {
		return selstatetxtbx;
	}

	@FindBy(id = "phone")
	private WebElement phnotxtbx;

	public WebElement getphnotxtbx() {
		return phnotxtbx;
	}

	@FindBy(id="fax")
	private WebElement faxtxtbx;

	public WebElement getfaxtxtbx() {
		return faxtxtbx;
	}

	@FindBy(id="email")
	private WebElement emailtxtbx;

	public WebElement getemailtxtbx() {
		return emailtxtbx;
	}

	@FindBy(id="url")
	private WebElement webtxtbx;

	public WebElement getwebtxtbx() {
		return webtxtbx;
	}

	@FindBy(id="idprof1")
	private WebElement profid1txtbx;

	public WebElement getprofid1txtbx() {
		return profid1txtbx;
	}

	@FindBy(id="idprof2")
	private WebElement profid2txtbx;

	public WebElement getprofid2txtbx() {
		return profid2txtbx;
	}

	@FindBy(id="idprof3")
	private WebElement profid3txtbx;

	public WebElement getprofid3txtbx() {
		return profid3txtbx;
	}

	@FindBy(id="idprof4")
	private WebElement profid4txtbx;

	public WebElement getprofid4txtbx() {
		return profid4txtbx;
	}

	@FindBy(id="idprof5")
	private WebElement profid5txtbx;

	public WebElement getprofid5txtbx() {
		return profid5txtbx;
	}

	@FindBy(id="intra_vat")
	private WebElement vatidtxtbx;

	public WebElement getvatidtxtbx() {
		return vatidtxtbx;
	}

	@FindBy(id="select2-typent_id-container")
	private WebElement thirdpartytypeddclick;

	public WebElement getthirdpartytypeddclick() {
		return thirdpartytypeddclick;
	}
	@FindBy(xpath="//li[@class='select2-results__option'and text()='Large company']")
	private WebElement thirdpartytypeseldd;

	public WebElement getthirdpartytypeseldd() {
		return thirdpartytypeseldd;
	}
	@FindBy(xpath="//span[@id='select2-effectif_id-container']")
	private WebElement workforceddclick;

	public WebElement getworkforceddclick() {
		return workforceddclick;
	}

	@FindBy(xpath="//li[ text()='> 500']")
	private WebElement workforceddsel;

	public WebElement getworkforceddsel() {
		return workforceddsel;
	}

	@FindBy(id="capital")
	private WebElement capitaltxtbx;

	public WebElement getcapitaltxtbx() {
		return capitaltxtbx;
	}

	@FindBy(xpath="//span[@class='placeholder'and text()='Select a third party']")
	private WebElement parentcompanydd;

	public WebElement getparentcompanydd() {
		return parentcompanydd;
	}

	@FindBy(xpath="//li[text()='COBRA INDUSTRIAL SECURITY FORCE (SecurityPlus)']")
	private WebElement parentcompanyseldd;

	public WebElement getparentcompanyseldd() {
		return parentcompanyseldd;
	}

	@FindBy(xpath="//ul[@class='select2-selection__rendered']")
	private WebElement assignSalesrepclick;

	public WebElement getassignSalesrepclick() {
		return assignSalesrepclick;
	}

	@FindBy(xpath="//li[text()='Gavare Tusshar']")
	private WebElement assignSalesrepsel;

	public WebElement getassignSalesrepsel() {
		return assignSalesrepsel;
	}

	@FindBy(id="photoinput")
	private WebElement chosefilebtn;

	public WebElement getchosefilebtn() {
		return chosefilebtn;
	}

	@FindBy(xpath="//input[@class='button button-save ']")
	private WebElement createThdprtyBtn;

	public WebElement getcreateThdprtyBtn() {
		return createThdprtyBtn;
	}

	@FindBy(xpath="//a[@title='List of Customers']")
	private WebElement listcustlnk;

	public WebElement getlistcustlnk() {
		return listcustlnk;
	}

	@FindBy(xpath="//input[@class='flat searchstring maxwidth75imp'and @name='search_nom']")
	private WebElement tpsrchbx;

	public WebElement gettpsrchbx() {
		return tpsrchbx;
	}

	@FindBy(xpath="//button[@name='button_search_x']")
	private WebElement tpsrchbtbn;

	public WebElement gettpsrchbtbn() {
		return tpsrchbtbn;
	}

	@FindBy(xpath="//a[@class='classfortooltip refurl valignmiddle']")
	private WebElement thirdpartynamelinkk;

	public WebElement getthirdpartynamelinkk() {
		return thirdpartynamelinkk;
	}

	@FindBy(xpath="//span[@id='select2-search_type-container']")
	private WebElement thirdpartytypeclick;

	public WebElement getthirdpartytypeclick() {
		return thirdpartytypeclick;
	}

	@FindBy(xpath="//li[text()='Prospect']")
	private WebElement thirdpartytypeproclick;

	public WebElement getthirdpartytypeproclick() {
		return thirdpartytypeproclick;
	}


	@FindBy(id="contact")
	private WebElement conaddtab;

	public WebElement getconaddtab() {
		return conaddtab;
	}


	@FindBy(id="consumption")
	private WebElement relateditmtab;

	public WebElement getrelateditmtab() {
		return relateditmtab;
	}


	@FindBy(id="rib")
	private WebElement paymthdtab;

	public WebElement getpaymthdtab() {
		return paymthdtab;
	}
	

	@FindBy(id="note")
	private WebElement notestab;

	public WebElement getnotestab() {
		return notestab;
	}
	
	@FindBy(id="document")
	private WebElement linkedfilestab;

	public WebElement getlinkedfilestab() {
		return linkedfilestab;
	}
	
	@FindBy(id="agenda")
	private WebElement eventstab;

	public WebElement geteventstab() {
		return eventstab;
	}
	
	
	@FindBy(id="mainbody")
	private WebElement backlst;

	public WebElement getbacklst() {
		return backlst;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void fileUploadtekpydlogo() {
		waitForPageToLoad(driver);
		handlingFileUploadPopup(chosefilebtn,"./resourse/Tek Pyramid Logo.JPG");
	}



	public void createThirdpartyname(String thirdpartyname) {
		getThirdpartynametxtbx().sendKeys(thirdpartyname);

	}

}
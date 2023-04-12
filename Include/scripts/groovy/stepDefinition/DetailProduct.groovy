package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import internal.GlobalVariable

public class DetailProduct {
	@Given("User visit secondhand website")
	public void user_visit_secondhand_website() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://secondhand-store.herokuapp.com')
		WebUI.verifyElementPresent(findTestObject('home page/btn_jual'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_masuk'), 0)
	}

	@When("User click product on list product")
	public void user_click_product_on_list_product() {
		WebUI.click(findTestObject('Detail and Bid Product Page/btn_product_choosen'))
	}

	
	@Then("User can see detail product page")
	public void user_can_see_detail_product_page() {
		WebUI.verifyElementPresent(findTestObject('Detail and Bid Product Page/info_seler'), 0)
		WebUI.verifyElementPresent(findTestObject('Detail and Bid Product Page/desc_product'), 0)
	}
	@When("User click Saya Tertarik dan Ingin Nego button")
	public void user_click_Saya_Tertarik_dan_Ingin_Nego_button() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Detail and Bid Product Page/button_tertarik'))
	}
}


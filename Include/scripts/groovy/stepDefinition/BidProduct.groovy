package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.seleniumhq.jetty9.server.HomeBaseWarning

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

import ch.qos.logback.core.joran.conditional.ElseAction
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.internal.ArrayUtils
import internal.GlobalVariable

public class BidProduct {
	@Given("User visit the website")
	public void user_visit_the_website() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://secondhand-store.herokuapp.com')
		WebUI.verifyElementPresent(findTestObject('home page/btn_jual'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_masuk'), 0)
	}

	@Then("User input original price in Harga Tawar field with (.*)")
	public void user_input_original_price_in_Harga_Tawar_field_with(String price) {
		WebUI.setText(findTestObject('Detail and Bid Product Page/input_harga tawar'), price)
	}

	@Then("User click Kirim button")
	public void user_click_Kirim_button() {
		WebUI.click(findTestObject('Detail and Bid Product Page/btn_Kirim'))
	}


	@Then("User can see (.*) toast message")
	public void user_can_see_toast_message(String result) {
		if(result=="Success") {
			WebUI.verifyElementPresent(findTestObject('Detail and Bid Product Page/toast_berhasil'), 0)
		} else {
			WebUI.verifyAlertNotPresent(0)
		}
	}

	@When("User click added product on list product")
	public void user_click_added_product_on_list_product() {
		List<String> produks = new ArrayList<>()
		produks.addAll(Arrays.asList('home page/item_produk1','home page/item_produk2',
			'home page/item_produk3','home page/item_produk4','home page/item_produk5','home page/item_produk6',
			'home page/item_produk7','home page/item_produk8','home page/item_produk9','home page/item_produk10',
			'home page/item_produk11','home page/item_produk12')) 
		Random rand = new Random()
		int randProduk = rand.nextInt(produks.size())
		WebUI.click(findTestObject(produks.get(randProduk)))
	}

	@Then("User redirected to login page")
	public void user_redirected_to_login_page() {
		WebUI.verifyElementPresent(findTestObject('login page/input_email_login'), 0)
		WebUI.verifyElementPresent(findTestObject('login page/input_password_login'), 0)
		WebUI.verifyElementPresent(findTestObject('login page/btn_masuk_login'), 0)
		WebUI.closeBrowser()
	}
	
}
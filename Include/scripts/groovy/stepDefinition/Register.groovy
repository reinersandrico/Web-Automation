package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ch.qos.logback.core.joran.conditional.ElseAction
import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.apache.commons.lang.RandomStringUtils
import org.assertj.core.api.CharacterAssert

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils


class Register {
	@Given("User already on Home page")
	public void user_already_on_Home_page() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://secondhand-store.herokuapp.com/')
		WebUI.verifyElementPresent(findTestObject('home page/btn_filter-semua'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_filter-baju'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_jual'), 0)
		WebUI.verifyElementVisible(findTestObject('home page/btn_masuk'))
	}

	@When("User clicks the Masuk button on the top right corner of the page")
	public void user_clicks_the_Masuk_button_on_the_top_right_corner_of_the_page(){
		WebUI.click(findTestObject('home page/btn_masuk'))
	}

	@When("User clicks the Daftar di sini link under the Masuk button")
	public void user_clicks_the_daftar_di_sini_link_under_the_masuk_button() {
		WebUI.click(findTestObject('login page/btn_registerpage'))
	}

	@When("User inputs their complete name in the Nama field")
	public void user_inputs_their_complete_name_in_the_Nama_field() {
		WebUI.setText(findTestObject('register page/input_nama'), RandomStringUtils.randomAlphanumeric(5) + " "+RandomStringUtils.randomAlphanumeric(5))
	}

	@When("User inputs a valid password in the Password field")
	public void user_inputs_a_valid_password_in_the_Password_field() {
		WebUI.setText(findTestObject('register page/input_password'), '12345678')
	}

	@When("User clicks the Daftar button")
	public void user_clicks_the_Daftar_button() {
		WebUI.click(findTestObject('register page/btn_daftar'))
	}

	@Then("User should see a flash\\/toast message Silahkan verifikasi email agar dapat menggunakan layanan kami")
	public void user_should_see_a_flash_toast_message_Silahkan_verifikasi_email_agar_dapat_menggunakan_layanan_kami() {
		WebUI.verifyElementVisible(findTestObject('register page/btn_toast_msg_registered'))
	}

	@Then("User should be successfully registered.")
	public void user_should_be_successfully_registered() {
		WebUI.verifyElementVisible(findTestObject('register page/btn_close_msg_registered'))
		WebUI.closeBrowser()
	}


	//start to incorrect Credential
	@When("User skips input complete name in the Nama field")
	public void user_skips_input_complete_name_in_the_Nama_field() {
		WebUI.setText(findTestObject('register page/input_nama'), '')

	}
	@When("User inputs (.*) email address in the Email address field")
	public void user_inputs_email_address_in_the_email_address_field(String email) {
		if(email=="an incorrect") {
			WebUI.setText(findTestObject('register page/input_email'), 'thisemail.email.com');
		} else if(email=="an already registered") {
			WebUI.setText(findTestObject('register page/input_email'), 'hendraa@yopmail.com');
		} else {
			WebUI.setText(findTestObject('register page/input_email'), RandomStringUtils.randomAlphanumeric(10) + "@yopmail.com")
		}
		
	}
	
	@When("User inputs with less than eight characters password in the Password field")
	public void user_inputs_with_less_than_eight_characters_password_in_the_password_field() {
		WebUI.setText(findTestObject('register page/input_password'), '123456')
	}
	
	@Then("User failed to register and should see warning information that (.*)")
		public void user_failed_to_register_and_should_see_warning_information_that(String warning) {
			if(warning =="Password Kurang dari delapan Karakter") {
				WebUI.verifyElementNotPresent(findTestObject('register page/btn_email_already_registered'), 3)
				WebUI.verifyElementNotPresent(findTestObject('register page/btn_close_msg_registered'), 3)
				WebUI.closeBrowser()
			} else if(warning =="Email  format is incorrect") {
				WebUI.getAttribute(findTestObject('register page/input_email'), 'validationMessage')
				WebUI.closeBrowser()
			} else if(warning =="Email sudah digunakan") {
				WebUI.verifyElementPresent(findTestObject('register page/btn_email_already_registered'), 0)
				WebUI.closeBrowser()
			} else {
				WebUI.getAttribute(findTestObject('register page/input_nama'), 'validationMessage')
				WebUI.closeBrowser()
			}
		}


}












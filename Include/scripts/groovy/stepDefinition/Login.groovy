package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.lang.invoke.WrongMethodTypeException

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
import internal.GlobalVariable

public class Login {
	@Given("User already in login page")
	public void user_already_in_login_page() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://secondhand-store.herokuapp.com/login')
		WebUI.verifyElementPresent(findTestObject('login page/verify_login_title'),0)
		WebUI.verifyElementPresent(findTestObject('login page/btn_registerpage'),0)
	}

	@When("User input correct email {string}")
	public void user_input_correct_email(String email) {
		WebUI.setText(findTestObject('login page/input_email_login'),email)
	}

	@When("User input correct password {string}")
	public void user_input_correct_password(String password) {
		WebUI.setText(findTestObject('login page/input_password_login'), password);
	}


	@When("User click login button")
	public void user_click_login_button() {
		WebUI.click(findTestObject('login page/btn_masuk_login'))
	}

	@Then("User successfully login and redirected to home page")
	public void user_successful_login_and_redirected_to_home_page() {
		WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_filter-baju'), 0)
	}


	@When("User input email field with (.*)")
	public void user_input_email_field_with(String email_user) {

		if(email_user=="valid email") {
			WebUI.setText(findTestObject('login page/input_email_login'),'reiner.sandrico@ti.ukdw.ac.id');
		} else if(email_user=="invalid email") {
			WebUI.setText(findTestObject('login page/input_email_login'),'reiner.sandricoo@ti.ukdw.ac.id');
		}
		else if(email_user=="new email") {
			WebUI.setText(findTestObject('login page/input_email_login'),'reiner@gmail.com');
		}else {
			WebUI.setText(findTestObject('login page/input_email_login'),'');
		}
	}

	@When("User input password field with (.*)")
	public void user_input_password_field_with(String password_user) {

		if(password_user=="valid password" || password_user == "correct password") {
			WebUI.setText(findTestObject('login page/input_password_login'),'123456789');
		} else if(password_user=="invalid password" || password_user == "incorrect password") {
			WebUI.setText(findTestObject('login page/input_password_login'),'11111111');
		}else  {
			WebUI.setText(findTestObject('login page/input_password_login'),'');
		}
	}

	@Then("User unsuccessfully login and get (.*) toast message")
	public void user_unsuccessfully_login_and_get_toast_message(String result) {

		if(result=="successfully") {
			WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
			WebUI.verifyElementPresent(findTestObject('home page/btn_filter-baju'),0)
			WebUI.closeBrowser()
		} else if (result=="failed empty email") {
			WebUI.getAttribute(findTestObject('login page/input_email_login'), 'validationMessage')
			WebUI.closeBrowser()
		}else if (result=="failed empty password") {
			WebUI.getAttribute(findTestObject('login page/input_password_login'), 'validationMessage')
			WebUI.closeBrowser()
		}else if (result=="wrong password"){
			WebUI.verifyElementPresent(findTestObject('login page/error_message_wrong_password'), 0)
			WebUI.closeBrowser()
		}
		else if (result=="check email verification"){
			WebUI.verifyElementPresent(findTestObject('login page/message_check_email_verification'), 0)
			WebUI.closeBrowser()
		}else if (result=="account not found"){
			WebUI.verifyElementPresent(findTestObject('login page/error_message_account_not_found'), 0)
			WebUI.closeBrowser()
		}
	}
}

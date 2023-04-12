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
import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils

public class Profile {

	@When("User click profile icon")
	public void user_click_profile_icon() {
		WebUI.click(findTestObject('edit profile page/btn_profile'))
	}

	@When("User click profile")
	public void user_click_profile() {
		WebUI.click(findTestObject('edit profile page/btn_namaprofile'))
	}

	@When("User edit Nama")
	public void user_edit_Nama() {
		WebUI.setText(findTestObject('edit profile page/input_nama'), 'Ayu Mawar')
	}

	@When("User edit Kota")
	public void user_edit_Kota() {
		WebUI.selectOptionByValue(findTestObject('edit profile page/select_kota'), 'Bandung', true)
	}

	@When("User edit Alamat")
	public void user_edit_Alamat() {
		WebUI.setText(findTestObject('edit profile page/input_alamat'), 'Jalan Sukaduka 76')
	}

	@When("User edit No Handphone")
	public void user_edit_No_Handphone() {
		WebUI.setText(findTestObject('edit profile page/input_no.handphone'), '086514232526')
	}

	@When("User edit incorrect Alamat")
	public void user_edit_incorrect_Alamat() {
		WebUI.setText(findTestObject('edit profile page/input_alamat'), RandomStringUtils.randomAlphanumeric(545))
	}

	@When("User click Submit button")
	public void user_click_Submit_button() {
		WebUI.click(findTestObject('edit profile page/btn_submit'),)
	}
	@Then("User successfully edit profile")
	public void user_successfully_edit_profile() {
		WebUI.verifyElementPresent(findTestObject('edit profile page/toast_msg_berhasil_update_profile'), 0)
		WebUI.closeBrowser()
	}

	@Then("User unsuccessfully edit profile")
	public void user_unsuccessfully_edit_profile() {
		WebUI.verifyAlertNotPresent(0)
		WebUI.closeBrowser()
	}
}


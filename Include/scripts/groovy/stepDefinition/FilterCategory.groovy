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

import ch.qos.logback.core.joran.conditional.ElseAction
import internal.GlobalVariable

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils



public class FilterCategory {
	
	@When("User clicks on (.*) Filter under Telusuri Kategori selection")
	public void user_clicks_on_Filter_under_telusuri_kategori_selection(String kategori) {
		if(kategori == "Semua") {
			WebUI.click(findTestObject('home page/btn_filter-semua'))
		} else if (kategori == "Hoby") {
			WebUI.click(findTestObject('home page/btn_filter-hoby'))
		} else if (kategori == "Kendaraan") {
			WebUI.click(findTestObject('home page/btn_filter-kendaraan'))
		} else if (kategori == "Baju") {
			WebUI.click(findTestObject('home page/btn_filter-baju'))
		} else if (kategori == "Elektronik") {
			WebUI.click(findTestObject('home page/btn_filter-elektro'))
		} else {
			WebUI.click(findTestObject('home page/btn_filter-kesehatan'))
		}
		
	}
	
	@Then("Products with (.*) category will be displayed")
	public void products_with_category_will_be_displayed(String kategori) {
		if(kategori == "Semua") {
			WebUI.verifyElementPresent(findTestObject('home page/label_baju_kemeja'), 7)
			WebUI.verifyElementPresent(findTestObject('home page/label_kesehatan_obat'), 7)
			WebUI.verifyElementPresent(findTestObject('home page/label_elektro_kamera'), 7)
			WebUI.verifyElementPresent(findTestObject('home page/label_hoby_AFAnime'), 7)
			WebUI.verifyElementPresent(findTestObject('home page/label_kendaraan_sepeda'), 7)
			WebUI.closeBrowser()
		} else if (kategori == "Hoby") {
			WebUI.verifyElementPresent(findTestObject('home page/label_hoby_AFAnime'), 7)
			WebUI.closeBrowser()
		} else if (kategori == "Kendaraan") {
			WebUI.verifyElementPresent(findTestObject('home page/label_kendaraan_sepeda'), 7)
			WebUI.closeBrowser()
		} else if (kategori == "Baju") {
			WebUI.verifyElementPresent(findTestObject('home page/label_baju_kemeja'), 7)
			WebUI.closeBrowser()
		} else if (kategori == "Elektronik") {
			WebUI.verifyElementPresent(findTestObject('home page/label_elektro_kamera'), 7)
			WebUI.closeBrowser()
		} else {
			WebUI.verifyElementPresent(findTestObject('home page/label_kesehatan_tensi'), 7)
			WebUI.closeBrowser()
		}
		
	}


}

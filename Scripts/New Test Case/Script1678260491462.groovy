import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://secondhand-store.herokuapp.com/')

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('null'), '18102221@ittelkom-pwt.ac.id')

WebUI.setEncryptedText(findTestObject('null'), 'yCR+7cEhMvOC+fIBcFifIQ==')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('null'), 'Alya Fanny')

WebUI.selectOptionByValue(findTestObject('null'), 'Pilih kota', true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 'Bandung', true)

WebUI.setText(findTestObject('null'), 'J')

WebUI.setText(findTestObject('null'), 'Ja')

WebUI.setText(findTestObject('null'), 'Jal')

WebUI.setText(findTestObject('null'), 'Jala')

WebUI.setText(findTestObject('null'), 'Jalan')

WebUI.setText(findTestObject('null'), 'Jalan ')

WebUI.setText(findTestObject('null'), 'Jalan N')

WebUI.setText(findTestObject('null'), 'Jalan Na')

WebUI.setText(findTestObject('null'), 'Jalan Nag')

WebUI.setText(findTestObject('null'), 'Jalan Naga')

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('null'), '082753577272')

WebUI.click(findTestObject('null'))

WebUI.closeBrowser()

WebUI.selectOptionByLabel(findTestObject('edit profile page/select_kota'), '', false)


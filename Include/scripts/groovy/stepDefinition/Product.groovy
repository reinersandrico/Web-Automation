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
import org.openqa.selenium.Keys as Keys

public class Product {

	@When("User click three dots menu on the navigation menu")
	public void user_click_three_dots_menu_on_the_navigation_menu() {
		WebUI.click(findTestObject('home page/menu_list_product'))
	}

	@When("User select (.*) product from list product")
	public void user_select_product_from_list_product(String cardNum) {
		if(cardNum == "3rd") {
			WebUI.click(findTestObject('my product page/3rd_product_card'))
		} else {
			WebUI.click(findTestObject('edit product page/product_edit'))
		}
	}

	@When("User click edit button")
	public void user_click_edit_button() {
		WebUI.verifyElementPresent(findTestObject('edit product page/btn_edit_product'), 0)
		WebUI.click(findTestObject('edit product page/btn_edit_product'))
	}

	@When("User change name product {string}")
	public void user_change_name_product (String nameproduct) {
		WebUI.setText(findTestObject('edit product page/input_edit_name_product'),nameproduct)
	}


	@When("User change the price product {string}")
	public void user_change_the_price_product (String priceproduct) {
		WebUI.setText(findTestObject('edit product page/input_edit_price_product'),priceproduct)
	}


	@When("User select the new category product {string}")
	public void user_select_the_new_category_product (String category) {
		WebUI.selectOptionByLabel(findTestObject('edit product page/dropdown_edit_category_product'), category, false)
	}

	@When("User input new description product {string}")
	public void user_input_new_description_product (String descriptionproduct) {
		WebUI.setText(findTestObject('edit product page/description_edit_product'),descriptionproduct)
	}


	@When("User click Terbitkan button")
	public void user_click_Terbitkan_button() {
		WebUI.click(findTestObject('edit product page/btn_edit_product_terbitkan'))
	}


	@Then("User successfully update product and will be directed to the home page")
	public void user_successfully_update_product_and_will_be_directed_to_the_home_page() {
		WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_filter-hoby'), 0)
	}


	@Then("User edit the product back to the initial value")
	public void user_edit_the_product_back_to_the_initial_value() {
		WebUI.delay(2)
		WebUI.click(findTestObject('home page/menu_list_product'))
		WebUI.click(findTestObject('edit product page/product_edit'))
		WebUI.click(findTestObject('edit product page/btn_edit_product'))
		WebUI.setText(findTestObject('edit product page/input_edit_name_product'), 'penjualbanrdm')
		WebUI.setText(findTestObject('edit product page/input_edit_price_product'), '1000')
		WebUI.selectOptionByLabel(findTestObject('edit product page/dropdown_edit_category_product'), 'Hoby', false)
		WebUI.setText(findTestObject('edit product page/description_edit_product'), 'bulat ')
		WebUI.click(findTestObject('edit product page/btn_edit_product_terbitkan'))
		WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
		WebUI.closeBrowser()
	}



	@When("User edit product (.*)")
	public void user_edit_product (String data_product) {

		if(data_product=="delete name product") {
			WebUI.doubleClick(findTestObject('edit product page/input_edit_name_product'))
			WebUI.sendKeys(findTestObject('edit product page/input_edit_name_product'), Keys.chord(Keys.BACK_SPACE))
		} else if(data_product=="delete description") {
			WebUI.click(findTestObject('edit product page/description_edit_product'))
			WebUI.sendKeys(findTestObject('edit product page/description_edit_product'), Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(findTestObject('edit product page/description_edit_product'), Keys.chord(Keys.BACK_SPACE))
		}else if(data_product=="minus price product") {
			WebUI.setText(findTestObject('edit product page/input_edit_price_product'),'-200');
		}
		else  {
			WebUI.verifyAlertNotPresent(0)
		}
	}


	@Then("User get result (.*) update product")
	public void user_get_result_update_product(String result) {

		if(result=="successfully") {
			WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
		} else {
			//do nothing not have error message

		}
	}

	@Then("User edit the product back to the initial value (.*)")
	public void user_edit_the_product_back_to_the_initial_value_product(String value) {
		if (value == "name product") {
			WebUI.click(findTestObject('home page/menu_list_product'))
			WebUI.click(findTestObject('edit product page/product_edit'))
			WebUI.click(findTestObject('edit product page/btn_edit_product'))
			WebUI.setText(findTestObject('edit product page/input_edit_name_product'), 'penjualbanrdm')
			WebUI.click(findTestObject('edit product page/btn_edit_product_terbitkan'))
			WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
			WebUI.closeBrowser()
		} else if (value == "price product") {
			WebUI.click(findTestObject('home page/menu_list_product'))
			WebUI.click(findTestObject('edit product page/product_edit'))
			WebUI.click(findTestObject('edit product page/btn_edit_product'))
			WebUI.setText(findTestObject('edit product page/input_edit_price_product'), '1000')
			WebUI.click(findTestObject('edit product page/btn_edit_product_terbitkan'))
			WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
			WebUI.closeBrowser()
		} else if (value == "category") {
			WebUI.click(findTestObject('home page/menu_list_product'))
			WebUI.click(findTestObject('edit product page/product_edit'))
			WebUI.click(findTestObject('edit product page/btn_edit_product'))
			WebUI.selectOptionByLabel(findTestObject('edit product page/dropdown_edit_category_product'), 'Hoby', false)
			WebUI.click(findTestObject('edit product page/btn_edit_product_terbitkan'))
			WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
			WebUI.closeBrowser()
		} else {
			WebUI.click(findTestObject('home page/menu_list_product'))
			WebUI.click(findTestObject('edit product page/product_edit'))
			WebUI.click(findTestObject('edit product page/btn_edit_product'))
			WebUI.setText(findTestObject('edit product page/description_edit_product'), 'bulat ')
			WebUI.click(findTestObject('edit product page/btn_edit_product_terbitkan'))
			WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
			WebUI.closeBrowser()
		}
	}

	@Given("User already has 4 products")
	public void user_already_has_4_products() {
		WebUI.verifyElementPresent(findTestObject('my product page/4th_product_card'), 0)
	}

	@When("User click + Tambah Produk")
	public void user_click_Tambah_Produk() {
		WebUI.verifyElementPresent(findTestObject('my product page/btn_add_product'), 0)
		WebUI.click(findTestObject('my product page/btn_add_product'))
	}

	@When("User input product name")
	public void user_input_product_name() {
		WebUI.setText(findTestObject('edit product page/input_edit_name_product'), 'D4N1Y')
	}

	@When("User input product price with (.*)")
	public void user_input_product_price_with(String price) {
		if(price) {
			WebUI.setText(findTestObject('edit product page/input_edit_price_product'), price)
		}else {
			WebUI.setText(findTestObject('edit product page/input_edit_price_product'), '2000')
		}
	}

	@When("User choose the (.*) category")
	public void user_choose_the_category(String cat) {
		if(cat == "empty category" || cat == "empty") {
			WebUI.selectOptionByLabel(findTestObject('edit product page/dropdown_edit_category_product'), 'Pilih Kategori', false)
			println(cat)
		} else {
			WebUI.selectOptionByLabel(findTestObject('edit product page/dropdown_edit_category_product'), 'Hoby', false)
		}
	}

	@When("User input description")
	public void user_input_description() {
		WebUI.setText(findTestObject('edit product page/description_edit_product'), ' ')
	}


	@Then("User will be directed to the home page")
	public void user_will_be_directed_to_the_home_page() {
		WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_masuk'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_filter-hoby'), 0)
	}

	@When("User already on home page")
	public void user_already_on_home_page() {
		WebUI.verifyElementPresent(findTestObject('home page/logo_app'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_masuk'), 0)
		WebUI.verifyElementPresent(findTestObject('home page/btn_filter-hoby'), 0)
	}


	@Then("User should be redirected to Daftar Jual Saya page")
	public void user_should_be_redirected_to_Daftar_Jual_Saya_page() {
		WebUI.verifyElementPresent(findTestObject('my product page/title_my_product_page') ,0)
	}

	@When("User should be able to see warning")
	public void user_should_be_able_to_see_warning() {
		WebUI.verifyElementPresent(findTestObject('edit product page/error_4_product') ,0)
	}

	@When("User should be able to see error toast")
	public void user_should_be_able_to_see_error_toast() {
		WebUI.verifyAlertNotPresent(0)
	}

	@Then("User input product with (.*)")
	public void user_intput_product_with(String var) {
		if(var=="empty category") {
			// Do Nothing
		} else {
			WebUI.setText(findTestObject('edit product page/input_edit_name_product'), '')
		}
	}

	@Then("User click delete button")
	public void user_click_delete_button() {
		WebUI.click(findTestObject('Detail and Bid Product Page/btn_hapus'))
	}
}

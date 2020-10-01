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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('market.cardinalhealth.com')

WebUI.navigateToUrl('market.cardinalhealth.com')

WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Login_Page/Page_/input_Username_username'), 5)

WebUI.setText(findTestObject('Object Repository/Market_Login_Page/Page_/input_Username_username'), 'mktnrsyn_int')

WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Login_Page/Page_/input_ Case Sensitive_password'), 
    5)

WebUI.setText(findTestObject('Object Repository/Market_Login_Page/Page_/input_ Case Sensitive_password'), 'Btbms4us!')

'Click on \'Login\' button'
WebUI.click(findTestObject('Object Repository/Market_Login_Page/Page_/button_Sign In'))

'Market Main Page'
WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Main_Page/Page_Home/ul_Products'), 5)

'Market Search Page'
WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Search_Page/Page_Home/button_Logout_home-search-button'), 
    5)

WebUI.setText(findTestObject('Object Repository/Market_Search_Page/Page_Home/input_Logout_col-xs-12 home-search-box ng-untouched ng-pristine ng-invalid'), 
    'isolation gown yellow')

'Click on \'Search\' button'
WebUI.click(findTestObject('Object Repository/Market_Search_Page/Page_Home/button_Logout_home-search-button'))

'Market Add To Cart'
WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Add_To_Cart/Page_Search/h4_Category'), 5)

WebUI.waitForElementVisible(findTestObject('Market_Add_To_Cart/Page_Search/span_Add to Cart'), 5)

WebUI.click(findTestObject('Object Repository/Market_Add_To_Cart/Page_Search/span_Add to Cart'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Add_To_Cart/Page_Search/span_1 Items'), 5)

WebUI.click(findTestObject('Object Repository/Market_Add_To_Cart/Page_Search/span_Cart_full'))

'Market Checkout Page'
WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/span_Cart'), 5)

WebUI.setText(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/input_ PO_poNumber'), 'PerfT0001')

WebUI.setText(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/textarea_PO Memo_poMemo'), 'BSM Test')

WebUI.click(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/span_Packing Slip_checkbox-icon large'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/button_Update Cart'))

WebUI.click(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/button_Update Cart'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/button_Checkout'))

WebUI.click(findTestObject('Object Repository/Market_Checkout_Page/Page_Cart/button_Checkout'))

'Market Clear Cart'
WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Clear_Cart/Page_Checkout/span_Previous Page'), 5)

WebUI.click(findTestObject('Object Repository/Market_Clear_Cart/Page_Checkout/span_Previous Page'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/span_Packing Slip_checkbox-icon large'), 
    5)

WebUI.click(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/span_Packing Slip_checkbox-icon large'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/span_Delete'))

WebUI.click(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/span_Delete'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/button_Confirm'), 5)

WebUI.click(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/button_Confirm'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Market_Clear_Cart/Page_Cart/div_The selected item(s) were deleted'), 
    5)

'Market Logout Page'

'Click on \'Logout\' button'
WebUI.click(findTestObject('Object Repository/Market_Logout_Page/Page_Search/span_Logout'))

WebUI.closeBrowser()


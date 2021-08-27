package DemoMidTrans;

import Pages.BasePage;
import Pages.CheckoutPage;
import Pages.OrderSummaryPage;
import Pages.SelectPaymentPage;
import Utilities.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends Setup {

    public WebDriver driver;
    BasePage basePage;
    CheckoutPage checkoutPage;
    OrderSummaryPage orderSummaryPage;
    SelectPaymentPage selectPaymentPage;

    @BeforeClass
    public void launchBrowser() {
        driver = launchBrowser("chrome");
        basePage = new BasePage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        selectPaymentPage = new SelectPaymentPage(driver);
    }

    @BeforeMethod
    public void tearUp() {
        driver.get("https://demo.midtrans.com/");
    }

    @Test(priority = 1, groups = {"regression"})
    public void verifyShoppingCartDetailsArePresent() {
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(checkoutPage.shoppingCartDetailsAreCorrect());
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void verifyClickingOnBuyNowUserGetsRedirectedToCheckoutPopUp() {
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(checkoutPage.checkoutPopUpIsDisplayed());
    }

    @Test(priority = 3, groups = {"regression"})
    public void verifyCustomerDetailsArePresent() {
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(checkoutPage.CustomerDetailsAreCorrect());
    }

    @Test(priority = 4, groups = {"regression"})
    public void verifyUserCanEnterCustomerDetails() {
        basePage.clickOnBuyNowButton();
        checkoutPage.enterCustomerDetails();
    }

    @Test(priority = 5, groups = {"smoke", "regression"})
    public void verifyUserRedirectsToOrderSummaryPopUpOnClickingCheckoutButton() {
        basePage.clickOnBuyNowButton();
        checkoutPage.clickOnCheckoutButton();
        orderSummaryPage.switchToOrderSummaryFrame();
        Assert.assertTrue(orderSummaryPage.orderSummaryPopUpIsVisible());
    }

    @Test(priority = 6, groups = {"regression"})
    public void verifyProductOrderDetailsOnOrderSummaryPopUpPage() {
        basePage.clickOnBuyNowButton();
        checkoutPage.clickOnCheckoutButton();
        orderSummaryPage.switchToOrderSummaryFrame();
        Assert.assertTrue(orderSummaryPage.orderDetailsArePresent());
    }

    @Test(priority = 7, groups = {"smoke", "regression"})
    public void verifyUserGetsRedirectedToSelectPaymentPageOnClickingContinueInOrderSummaryPage() {
        basePage.clickOnBuyNowButton();
        checkoutPage.clickOnCheckoutButton();
        orderSummaryPage.switchToOrderSummaryFrame();
        orderSummaryPage.clickOnContinueButton();
        Assert.assertTrue(selectPaymentPage.selectPaymentPageIsDisplayed());
    }

    @Test(priority = 8, groups = {"regression"})
    public void verifyAllThePaymentOptionsAreListedOnSelectPaymentPage() {
        basePage.clickOnBuyNowButton();
        checkoutPage.clickOnCheckoutButton();
        orderSummaryPage.switchToOrderSummaryFrame();
        orderSummaryPage.clickOnContinueButton();
        Assert.assertTrue(selectPaymentPage.paymentOptionsAreDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

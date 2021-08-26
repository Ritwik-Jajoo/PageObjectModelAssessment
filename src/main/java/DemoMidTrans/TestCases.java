package DemoMidTrans;

import Pages.BasePage;
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

    @BeforeClass
    public void launchBrowser() {
        driver = launchBrowser("chrome");
        basePage = new BasePage(driver);
    }

    @BeforeMethod
    public void tearUp() {
        driver.get("https://demo.midtrans.com/");
    }

    @Test(priority = 1, groups = {"regression"})
    public void verifyShoppingCartDetailsArePresent() {
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(basePage.shoppingCartDetailsAreCorrect());
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void verifyClickingOnBuyNowUserGetsRedirectedToCheckoutPopUp() {
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(basePage.checkoutPopUpIsDisplayed());
    }

    @Test(priority = 3, groups = {"regression"})
    public void verifyCustomerDetailsArePresent() {
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(basePage.CustomerDetailsAreCorrect());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

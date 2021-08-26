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

    @Test(priority = 1)
    public void verifyShoppingCartDetails() {
        basePage.clickOnBuyNowButton();
        System.out.println("Hey");
        Assert.assertTrue(basePage.shoppingCartDetailsAreCorrect());
    }

    @Test(priority = 2)
    public void verifyClickingOnBuyNowUserGetsRedirectedToCheckoutPopUp(){
        basePage.clickOnBuyNowButton();
        Assert.assertTrue(basePage.shoppingCartDetailsAreCorrect());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

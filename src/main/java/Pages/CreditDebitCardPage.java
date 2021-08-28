package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreditDebitCardPage extends BasePage {

    public CreditDebitCardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='app-container']")
    WebElement CreditDebitCardDetailsContainer;

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement OrderAmount;

    @FindBy(xpath = "//div[@class='checkbox checkbox-left']//input[@type='checkbox']")
    List<WebElement> CouponCodes;

    public boolean CreditDebitCardDetailsDisplayed() {
        return isDisplayed(CreditDebitCardDetailsContainer);
    }

    public boolean clickOnFirstCouponCodeAndValidateOrderAmount(){
        scrollTillTheElementIsVisible(CouponCodes.get(0));
        click(CouponCodes.get(0));
        holdExecution(1);
        scrollTillTheElementIsVisible(OrderAmount);
        holdExecution(1);
        return isPresent(OrderAmount,"19,990");
    }

    public boolean clickOnSecondCouponCodeAndValidateOrderAmount(){
        scrollTillTheElementIsVisible(CouponCodes.get(1));
        click(CouponCodes.get(1));
        holdExecution(1);
        scrollTillTheElementIsVisible(OrderAmount);
        holdExecution(1);
        return isPresent(OrderAmount,"18,000");
    }

    public boolean clickOnThirdCouponCodeAndValidateOrderAmount(){
        scrollTillTheElementIsVisible(CouponCodes.get(2));
        click(CouponCodes.get(2));
        holdExecution(1);
        scrollTillTheElementIsVisible(OrderAmount);
        holdExecution(1);
        return isPresent(OrderAmount,"19,000");
    }

}

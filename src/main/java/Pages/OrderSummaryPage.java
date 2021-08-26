package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePage {

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='app-container']")
    WebElement OrderSummaryPopUp;

    String id = "snap-midtrans";

    public void switchToOrderSummaryFrame() {
        switchToFrame(id);
    }

    public boolean orderSummaryPopUpIsVisible() {
        return isDisplayed(OrderSummaryPopUp);
    }

}

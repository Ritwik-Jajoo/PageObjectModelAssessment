package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectPaymentPage extends BasePage {

    public SelectPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement SelectPaymentTitleText;

    @FindBy(xpath = "//div[@class='list-content']")
    List<WebElement> PaymentOptions;

    public boolean selectPaymentPageIsDisplayed() {
        return isDisplayed(SelectPaymentTitleText);
    }

    public boolean paymentOptionsAreDisplayed(){
        return areDisplayed(PaymentOptions);
    }
}

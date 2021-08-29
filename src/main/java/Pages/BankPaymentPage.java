package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BankPaymentPage extends BasePage {

    public BankPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='acsForm']//div")
    List<WebElement> BankPaymentDetails;

    @FindBy(xpath = "//div[@class=\"page-container scroll\"]//iframe")
    WebElement IframeElement;

    public List<String> bankPaymentDetailsToBeDisplayed() {
        List<String> elements = new ArrayList<>();
        elements.add("Merchant Name:");
        elements.add("Rubicon Store ");
        elements.add("Amount:");
        elements.add("18000.00");
        elements.add("Transaction Time:");
        elements.add(getCurrentDateAndTime());
        elements.add("Card Number:");
        elements.add("481111-1114");
        return elements;
    }

    public void switchToBankPaymentPageFrame() {
        switchToFrame(IframeElement);
    }

    public boolean detailsAreDisplayedOnBankPaymentScreen() {
        return arePresent(BankPaymentDetails, bankPaymentDetailsToBeDisplayed());
    }
}

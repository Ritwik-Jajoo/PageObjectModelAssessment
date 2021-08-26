package Pages;

import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasePage<elements1> extends Utils {

    public WebDriver driver;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn buy']")
    WebElement BuyNowButton;

    @FindBy(xpath = "(//div[@class='cart-section']/table//tbody)[1]/tr/td")
    List<WebElement> ShoppingCartTableDetails;

    @FindBy(xpath = "//div[@class='cart-content buying']")
    WebElement CheckoutPopUp;

    public List<String> listOfShoppingCartElements() {
        List<String> elements = new ArrayList<>();
        elements.add("Midtrans Pillow");
        elements.add("× 1");
        elements.add("");
        elements.add("");
        elements.add("Total");
        elements.add("20,000");
        return elements;
    }

    public void clickOnBuyNowButton() {
        click(BuyNowButton);
    }

    public boolean shoppingCartDetailsAreCorrect() {
        return arePresent(ShoppingCartTableDetails, listOfShoppingCartElements());
    }

    public boolean checkoutPopUpIsDisplayed(){
        return isDisplayed(CheckoutPopUp);
    }
}

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

    public void clickOnBuyNowButton() {
        click(BuyNowButton);
        holdExecution(2);
    }


}

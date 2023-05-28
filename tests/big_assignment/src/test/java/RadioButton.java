import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class RadioButton extends BasePage {
    private By putItemInTheCartLocator = By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div[2]/div/button");
    private By continueToTheOrderLocator = By.xpath("//*[@id='js-cart-sidebar']/div/div[2]/div[3]/div/a");
    private By continueToTheOrderRadioLocator = By.xpath("//*[@id='main']/div/div[2]/div[1]/div[2]/div/a");
    private By radioLocator = By.xpath("//*[@id='id-address-delivery-address-6819']/header/label/span[1]");

    public RadioButton(WebDriver driver) {
        super(driver);
        this.driver.get("https://koreaimaszkok.hu/fenyvedo/710-isntree-hyaluronic-acid-natural-sun-cream.html");
    }

    public void fillARadioButton() {
        WebElement putItemInTheCartButton = waitAndReturnElement(putItemInTheCartLocator);
        putItemInTheCartButton.click();
        
        WebElement continueToTheOrderButton = waitAndReturnElement(continueToTheOrderLocator);
        continueToTheOrderButton.click();

        WebElement continueToTheOrderRadioButton = waitAndReturnElement(continueToTheOrderRadioLocator);
        continueToTheOrderRadioButton.click();

        WebElement radioButton = waitAndReturnElement(radioLocator);
        radioButton.click();
    }
}

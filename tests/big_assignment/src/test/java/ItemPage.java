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

public class ItemPage extends BasePage {
    private By quantityWantedLocator = By.id("quantity_wanted");

    public ItemPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://koreaimaszkok.hu/fenyvedo/710-isntree-hyaluronic-acid-natural-sun-cream.html");
    }

    public void fillTextInput() {
        WebElement quantityWanted = this.driver.findElement(quantityWantedLocator);
        quantityWanted.clear();
        quantityWanted.sendKeys("2");
    }
}
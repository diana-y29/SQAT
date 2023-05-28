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

public class DropDown extends BasePage {
    private By dropDownLocator = By.xpath("//*[@id='js-product-list-top']/div[2]/div/div[1]");
    private By dropDownMenuLocator = By.xpath("//*[@id='js-product-list-top']/div[2]/div/div[1]/div");
    private By dropDownRelevanceLocator = By.xpath("//*[@id='js-product-list-top']/div[2]/div/div[1]/div/a[1]");

    public DropDown(WebDriver driver) {
        super(driver);
        this.driver.get("https://koreaimaszkok.hu/61-hidrogel-arcmaszk");
    }

    public void readAndClickOnADropDownMenuItem() {
        WebElement dropDownButton = waitAndReturnElement(dropDownLocator);
        dropDownButton.click();
        WebElement dropDownElement = waitAndReturnElement(dropDownMenuLocator);
        Assert.assertTrue(dropDownElement.getText().contains("Relevancia"));
        Assert.assertTrue(dropDownElement.getText().contains("New products first"));
        WebElement dropDownItem = waitAndReturnElement(dropDownRelevanceLocator);
        dropDownItem.click();
    }
}

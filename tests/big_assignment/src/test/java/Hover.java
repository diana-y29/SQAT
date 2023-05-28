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
import org.openqa.selenium.interactions.Actions;

public class Hover extends BasePage {
    private By menuKozmetikumLocator = By.xpath("//*[@id='amegamenu']/div/ul/li[3]/a");
    private By menuTonerLocator = By.xpath("//*[@id='amegamenu']/div/ul/li[3]/div/div[2]/div/div[6]/h5/a");
    private By menuArckremLocator = By.xpath("//*[@id='amegamenu']/div/ul/li[3]/div/div[2]/div/div[6]/h5/a");

    public Hover(WebDriver driver) {
        super(driver);
        this.driver.get("https://koreaimaszkok.hu/");
    }

    public void hoverCheck() {
        Actions actions = new Actions(driver);
    	WebElement menuOption = driver.findElement(menuKozmetikumLocator);
    	actions.moveToElement(menuOption).perform();
    	WebElement subMenuOption = driver.findElement(menuTonerLocator); 
    	actions.moveToElement(subMenuOption).perform();
    	WebElement selectMenuOption = driver.findElement(menuArckremLocator);
    	selectMenuOption.click();
    }
}

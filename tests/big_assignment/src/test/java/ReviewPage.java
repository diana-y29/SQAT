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

public class ReviewPage extends BasePage {
    private By reviewsLocator = By.xpath("//*[@id='idTab777-my']");
    private By writeAReviewLocator = By.xpath("//*[@id='shopify-product-reviews']/div/div[1]/span/a/span");
    private By writeAReviewTextLocator = By.xpath("//*[@id='text-review']");

    public ReviewPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://koreaimaszkok.hu/fatyolmaszkok/553-elizavecca-tea-tree-deep-power-ringer-mask.html");
    }

    public void createAReview() {
        WebElement reviewsButton = waitAndReturnElement(reviewsLocator);
        reviewsButton.click();
        WebElement writeAReviewButton = waitAndReturnElement(writeAReviewLocator);
        writeAReviewButton.click();
        WebElement writeAReviewTextArea = this.driver.findElement(writeAReviewTextLocator);
        writeAReviewTextArea.sendKeys("Very good product.");
        writeAReviewTextArea.clear();
    }
}

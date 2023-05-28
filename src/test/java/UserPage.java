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

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;

import java.util.Random;   

public class UserPage extends BasePage {
    private By emailLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.id("submit-login");
    private By logoutButtonLocator = By.xpath("//*[@id='exit-link']");

    private By addressesButtonLocator = By.id("addresses-link");
    private By addNewAddressButtonLocator = By.xpath("//a[@href='https://koreaimaszkok.hu/address']");

    private By addressTextLocator = By.name("address1");
    private By postcodeTextLocator = By.name("postcode");
    private By cityTextLocator = By.name("city");
    private By saveButtonLocator = By.xpath("//*[@id='content']/div/div/form/footer/button");

    private By backToMyProfileLocator = By.xpath("//*[@id='main']/footer/a[1]/span");

    public UserPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://koreaimaszkok.hu/login?back=my-account");
    }

    public void login() {
        WebElement email = this.driver.findElement(emailLocator);
        WebElement password = this.driver.findElement(passwordLocator);
        email.sendKeys("yoodiana2@gmail.com");
        password.sendKeys("h3p5KTA");
        WebElement loginButton = waitAndReturnElement(loginButtonLocator);
        loginButton.click();
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(logoutButtonLocator);
        logoutButton.click();
    }

    public void addressButtonClick() {
        WebElement addressesButton = waitAndReturnElement(addressesButtonLocator);
        addressesButton.click();
    }
    public void addNewAddressesButtonClick() {
        WebElement addNewAddressesButton = waitAndReturnElement(addNewAddressButtonLocator);
        addNewAddressesButton.click();
    }
    public void saveButtonClick() {
        WebElement saveButton = waitAndReturnElement(saveButtonLocator);
        saveButton.click();
    }
    public void backToMyProfileButtonClick() {
        WebElement backToMyProfileButton = waitAndReturnElement(backToMyProfileLocator);
        backToMyProfileButton.click();
    }


    public void addNewAddress() {
        addressButtonClick();
        addNewAddressesButtonClick();

        WebElement address = this.driver.findElement(addressTextLocator);
        WebElement postcode = this.driver.findElement(postcodeTextLocator);
        WebElement city = this.driver.findElement(cityTextLocator);
        address.sendKeys("Baranyai utca 2");
        postcode.sendKeys("1117");
        city.sendKeys("Budapest");

        saveButtonClick();
        backToMyProfileButtonClick();
    }

    public void addNewAddressWithRandomValues() {
        Fairy fairy = Fairy.create();
		Person person = fairy.person();
        addressButtonClick();
        addNewAddressesButtonClick();

        this.driver.findElement(addressTextLocator).sendKeys(person.getAddress().getAddressLine1());
        // generate random postalcode
        Random random = new Random(); 
        String a = Integer.toString(random.nextInt(10));
        String b = Integer.toString(random.nextInt(10));
        String c = Integer.toString(random.nextInt(10));
        String d = Integer.toString(random.nextInt(10));

        this.driver.findElement(cityTextLocator).sendKeys(person.getAddress().getCity());
        this.driver.findElement(postcodeTextLocator).sendKeys(a+b+c+d);

        saveButtonClick();
        backToMyProfileButtonClick();
    }
}
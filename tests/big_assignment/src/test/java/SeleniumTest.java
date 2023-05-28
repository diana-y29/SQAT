import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class SeleniumTest {
    private WebDriver driver;
    private String[] urls = {"https://koreaimaszkok.hu/10-arcmaszkok", "https://koreaimaszkok.hu/marka/26-cosrx", "https://koreaimaszkok.hu/marka/28-jayjun", "https://koreaimaszkok.hu/marka/29-heimish"};

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "67");
        options.setCapability("platformName", "Windows XP");
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    // Load the main page
    @Test
    public void loadMainPageTest() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getBodyText().contains("A koreai arcmaszkok"));
    }

    // Login with correct email address and password and logout
    @Test
    public void loginAndLogoutTest() {
        UserPage userPage = new UserPage(this.driver);
        userPage.login();
        Assert.assertTrue(userPage.getBodyText().contains("KUPONOK"));
        userPage.logout();
    }

    // Add new address
    @Test
    public void addNewAddressTest() {
        UserPage userPage = new UserPage(this.driver);
        userPage.login();
        userPage.addNewAddress();
        userPage.logout();
    }

    // Add new address with random values
    @Test
    public void addNewAddressWithRandomValuesTest() {
        UserPage userPage = new UserPage(this.driver);
        userPage.login();
        userPage.addNewAddressWithRandomValues();
        userPage.logout();
    }

    // Fill the text box with the wanted quantity of the item
    @Test
    public void quantityWantedTest() {
        ItemPage itemPage = new ItemPage(this.driver);
        itemPage.fillTextInput();
    }

    // Open a static page and check the body content
    @Test
    public void openStaticPageTest() {
        BasePage basePage = new BasePage(this.driver);
        basePage.setDriver("https://koreaimaszkok.hu/18-szemmaszkok");
        Assert.assertTrue(basePage.getBodyText().contains("Szemmaszk"));
    }

    // Read the page's title
    @Test
    public void readThePageTitleTest() {
        BasePage basePage = new BasePage(this.driver);
        basePage.setDriver("https://koreaimaszkok.hu/51-tonerek");
        Assert.assertEquals("Toner", basePage.getTitleName());
    }

    // Create a review of a product
    @Test
    public void addReviewFunctionalityTest() {
        ReviewPage reviewPage = new ReviewPage(this.driver);
        reviewPage.createAReview();
    }

    // Reading a dropdown and clicking to an item of the dropdown menu.
    @Test
    public void readAndFillDropDownTest() {
        DropDown dropdown = new DropDown(this.driver);
        dropdown.readAndClickOnADropDownMenuItem();
    }
    
    // Filling a radio button
    @Test
    public void fillRadioButtonTest() {
        UserPage userPage = new UserPage(this.driver);
        userPage.login();
        RadioButton radioButton = new RadioButton(this.driver);
        radioButton.fillARadioButton();
    }

    // Testing multiple pages, it loads urls from 'urls' array and it will check the content
    // of the page to verify that we are on the correct page.
    @Test
    public void multiplePageTest() {
        BasePage basePage = new BasePage(this.driver);
        for (int i = 0; i < urls.length; i++) {
            basePage.setDriver(urls[i]);
            String[] expectedString = urls[i].split("-", 2);
            expectedString[1] = expectedString[1].substring(0, 1).toUpperCase() + expectedString[1].substring(1);
            Assert.assertTrue(basePage.getBodyText().contains(expectedString[1]));
        }
    }

    // Testing the hover functionality on this webpage
    @Test
    public void hoverTest() {
        Hover hover = new Hover(this.driver);
        hover.hoverCheck();
    }

    // Testing the scroll down on this webpage
    @Test
    public void scrollDownTest() {
        BasePage basePage = new BasePage(this.driver);
        basePage.setDriver("https://koreaimaszkok.hu/");
        basePage.scrollDown();
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
} 
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by oclimova on 12/9/2016.
 */
public class TestSteps {
    private WebDriver driver;
    HomePage homePage;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @After
    public void close() {
        if (driver != null)
            driver.quit();
    }

    @Given("^I am an unsigned user$")
    public void unsignIfNecessary() {
        homePage
                .navigate()
                .logout();
    }

    @When("^I navigated? to the '(.*)'@")
    public void navigate(String destination) {
        if (destination.equals("home page")) {
            homePage.navigate();
        }
    }

    @Then("^the '(.*)' is displayed$")
    public void displayed(String pageName) {
        if (pageName.equals("home page")) {
            assertTrue(homePage.weAreHere());
        }
    }

    @When("^I click on 'create an account' link$")
}

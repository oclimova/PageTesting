import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LogoutPage;
import pages.RegisterAccountPage;
import pages.WhateverPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestSteps {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterAccountPage registerAccountPage;
    private LogoutPage logoutPage;
    private WhateverPage whateverPage;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        if (driver != null)
            driver.quit();
    }

    @Given("^I am an unsigned user$")
    public void iAmUnsigned() {
        logoutPage = new LogoutPage(driver);
        logoutPage.navigate();
    }

    @When("^I navigated? to the '(.*)'@")
    public void navigate(String destination) {
        if (destination.equals("home page")) {
            homePage = new HomePage(driver);
            homePage.navigate();
        }
    }

    @Then("^the '(.*)' is displayed$")
    public void displayed(String pageName) {
        if (pageName.equals("home page")) {
            homePage = new HomePage(driver);
            assertTrue("Home page isn't displayed", homePage.isActive());
        }
    }

    @When("^I click on '(.*)' link$")
    public void clickLink(String linkName) {
        if (linkName.equals("create an account")) {
            whateverPage = new WhateverPage(driver);
            assertTrue("Out of the site", whateverPage.isActive());
            whateverPage.clickCreateAccount();
        }
    }

    @Then("^I am redirected to the '(.*)'$")
    public void redirectedTo(String pageTitle) {
        if (pageTitle.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
            assertTrue("I wasn't redirected to Register Account page", registerAccountPage.isActive());
        }
    }

    @And("all text fields or the '(.*)' are clear")
    public void testFieldsAreClear(String pageName) {
        if (pageName.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
        }
    }
}
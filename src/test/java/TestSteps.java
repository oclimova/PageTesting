import cucumber.api.java.en.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LogoutPage;
import pages.RegisterAccountPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestSteps {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterAccountPage registerAccountPage;
    private LogoutPage logoutPage;

    @Before
    public void init() throws Throwable {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        new HomePage(driver).navigate();
    }

    @After
    public void close() throws Throwable {
        if (driver != null)
            driver.quit();
    }

    @Given("^I am an unsigned user$")
    public void iAmUnsigned() throws Throwable {
        logoutPage = new LogoutPage(driver);
        logoutPage.navigate();
    }

    @When("^I navigated? to the '(.*)'$")
    public void navigate(String destination) throws Throwable {
//        if (destination.equals("home page")) {
//            homePage = new HomePage(driver);
//            homePage.navigate();
//        }
        Class pageClass;
    }

    @Then("^the '(.*)' is displayed$")
    public void displayed(String pageName) throws Throwable {
        if (pageName.equals("home page")) {
            homePage = new HomePage(driver);
            assertTrue("Home page isn't displayed", homePage.isCurrentPage());
        }
    }

    @When("^I click on '(.*)' link$")
    public void clickLink(String linkName) throws Throwable {
        if (linkName.equals("create an account")) {
            whateverPage = new WhateverPage(driver);
            assertTrue("Out of the site", whateverPage.isCurrentPage());
            whateverPage.clickCreateAccount();
        }
    }

    @Then("^I am redirected to the '(.*)'$")
    public void redirectedTo(String pageTitle) throws Throwable {
        if (pageTitle.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
            assertTrue("I wasn't redirected to Register Account page", registerAccountPage.isCurrentPage());
        }
    }

    @And("^all text fields on the '(.*)' are clear$")
    public void textFieldsAreClear(String pageName) throws Throwable {
        if (pageName.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
            assertTrue("Text Fields are not clear", registerAccountPage.textFieldsAreClear());
        }
    }

    @But("^'(.*)' field on the '(.*)' is filled with '(.*)' value$")
    @And("^'(.*)' field on the '(.*)' is filled with '(.*)' value$")
    public void fieldIsFilled(String fieldName, String pageName, String value) throws Throwable {
        if (pageName.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
            if (fieldName.equals("Country")) {
                assertTrue("Country field value doesn't match", registerAccountPage.getCountry().equals(value));
            } else if (fieldName.equals("Region / State")) {
                assertTrue("Region / State field value doesn't match", registerAccountPage.getRegion().equals(value));
            }
        }
    }

    @And("^'Subscribe' radio-group on the 'Register Account page' is set to 'No' value$")
    public void radioGroupHasValue(String radiogroupName, String pageName, String value) throws Throwable {
        if (pageName.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
            if (radiogroupName.equals("Subscribe")) {
                assertTrue("Radio-group value doesn't match", registerAccountPage.getSubscribe().equals(value));
            }
        }
    }
}
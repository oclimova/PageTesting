import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AbstractPage;
import pages.HomePage;
import pages.LogoutPage;
import pages.RegisterAccountPage;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
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
        new LogoutPage(driver).navigate();
    }

    @When("^I navigate(?:d?) to the (.*) page$")
    public void navigate(String pageName) throws Throwable {
        Class<?> pageClass = Class.forName("pages." + pageName + "Page");
        Object pageObject = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        Method navigate = pageClass.getMethod("navigate");
        navigate.invoke(pageObject);
    }

    @Then("^the (.*) page is displayed$")
    public void displayed(String pageName) throws Throwable {
        Class<?> pageClass = Class.forName("pages." + pageName + "Page");
        Object pageObject = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        Method isCurrentPage = pageClass.getMethod("isCurrentPage");
        assertTrue(pageName + " page isn't displayed correctly", (Boolean)isCurrentPage.invoke(pageObject));
    }

    @When("^I click on (.*) link from the (.*) page$")
    public void clickLink(String linkName, String pageName) throws Throwable {
        Class<?> pageClass = Class.forName("pages." + pageName + "Page");
        Object pageObject = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        Method clickLink = pageClass.getMethod("click" + linkName);
        clickLink.invoke(pageObject);
    }

    @Then("^all text fields on the (.*) page are clear$")
    public void textFieldsAreClear(String pageName) throws Throwable {
        Class<?> pageClass = Class.forName("pages." + pageName + "Page");
        Object pageObject = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        Method textFieldsAreClear = pageClass.getMethod("textFieldsAreClear");
        assertTrue("Not all fields from " + pageName + " page are clear", (Boolean)textFieldsAreClear.invoke(pageObject));
    }

    @Then("^(.*) field on the (.*) page is filled with '(.*)' value$")
    public void fieldIsFilled(String fieldName, String pageName, String value) throws Throwable {
//        if (pageName.equals("Register Account page")) {
//            registerAccountPage = new RegisterAccountPage(driver);
//            if (fieldName.equals("Country")) {
//                assertTrue("Country field value doesn't match", registerAccountPage.getCountry().equals(value));
//            } else if (fieldName.equals("Region / State")) {
//                assertTrue("Region / State field value doesn't match", registerAccountPage.getRegion().equals(value));
//            }
//        }
        Class<?> pageClass = Class.forName("pages." + pageName + "Page");
        Object pageObject = pageClass.getConstructor(WebDriver.class).newInstance(driver);
        Method getFieldValue = pageClass.getMethod("get" + fieldName);
        assertTrue(fieldName + " value doesn't match", ((String)getFieldValue.invoke(pageObject)).equals(value));
    }

    @Then("^'Subscribe' radio-group on the 'Register Account page' is set to 'No' value$")
    public void radioGroupHasValue(String radiogroupName, String pageName, String value) throws Throwable {
        if (pageName.equals("Register Account page")) {
            registerAccountPage = new RegisterAccountPage(driver);
            if (radiogroupName.equals("Subscribe")) {
                assertTrue("Radio-group value doesn't match", registerAccountPage.getSubscribe().equals(value));
            }
        }
    }
}
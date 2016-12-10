package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by oclimova on 12/10/2016.
 */
public abstract class AbstractPage {
    private WebDriver driver;

    private By login = By.xpath(".//*[text()='login']/.."),
            createAccount = By.xpath(".//*[text()='create an account']/.."),
            logout = By.xpath(".//*[text()='Logout']/..");

    public abstract AbstractPage navigate();
    public abstract boolean isActive();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public AbstractPage logout() {
        WebElement logoutLink = driver.findElement(logout);
        if (logoutLink != null)
            logoutLink.click();
        return this;
    }

    public AbstractPage clickLogin() {
        logout();
        getDriver().findElement(login).click();
        return this;
    }

    public AbstractPage clickCreateAccount() {
        logout();
        getDriver().findElement(createAccount).click();
        return this;
    }
}

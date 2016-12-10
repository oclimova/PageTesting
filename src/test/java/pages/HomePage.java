package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
    private WebDriver driver;
    private By login = By.xpath(".//*[text()='login']/.."),
            createAccount = By.xpath(".//*[text()='create an account']/.."),
            logout = By.xpath(".//*[text()='Logout']/..");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage navigate() {
        driver.get("http://172.16.44.49/oc/");
        return this;
    }

    public HomePage logout() {
        WebElement logoutLink = driver.findElement(logout);
        if (logoutLink != null)
            logoutLink.click();
        return this;
    }

    public HomePage clickLogin() {
        logout();
        driver.findElement(login).click();
        return this;
    }

    public HomePage clickCreateAccount() {
        logout();
        driver.findElement(createAccount).click();
        return this;
    }

    public boolean weAreHere() {
        return driver.getTitle().equals("Your Store");
    }
}
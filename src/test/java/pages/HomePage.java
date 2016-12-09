package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oclimova on 12/9/2016.
 */
public class HomePage {
    private WebDriver driver;
    private By loginLink = By.xpath(".//*[text()='login']/..");
    private By createAccountLink = By.xpath(".//*[text()='create an account']/..");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }
}

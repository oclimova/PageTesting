package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class StoreAbstractPage extends AbstractPage {
    private By login = By.xpath(".//*[text()='login']/.."),
            createAccount = By.xpath(".//*[text()='create an account']/.."),
            logout = By.xpath(".//*[text()='Logout']/..");

    public StoreAbstractPage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage logout() {
        WebElement logoutLink = getDriver().findElement(logout);
        if (logoutLink != null)
            logoutLink.click();
        return this;
    }

    public AbstractPage clickLogin() {
        getDriver().findElement(login).click();
        return this;
    }

    public AbstractPage clickCreateAccount() {
        getDriver().findElement(createAccount).click();
        return this;
    }
}

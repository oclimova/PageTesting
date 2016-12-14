package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLoginPage extends StoreAbstractPage {
    private static final String PATH = "index.php?route=account/login";

    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;

    public AccountLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPath() {
        return super.getPath() + PATH;
    }

    public AccountLoginPage navigate() {
        getDriver().get(getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return isCurrentPage(getDriver());
    }

    public static boolean isCurrentPage(WebDriver driver) {
        return driver.getTitle().equals("Account Login");
    }

    public boolean textFieldsAreClear() {
        return getEmail().equals("")
                && getPassword().equals("");
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public AccountLoginPage setEmail(String value) {
        email.sendKeys(value);
        return this;
    }

    public AccountLoginPage setPassword(String value) {
        password.sendKeys(value);
        return this;
    }
}

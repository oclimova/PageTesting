package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Path;

public abstract class StoreAbstractPage extends AbstractPage {
    @FindBy(xpath = ".//*[text()='login']")
    private WebElement login;
    @FindBy(xpath = ".//*[text()='create an account']")
    private WebElement createAccount;
    @FindBy(xpath = ".//*[text()='Logout']")
    private WebElement logout;

    private static final String PATH = "http://172.16.44.49/oc/";

    public String getPath() {
        return PATH;
    }

    public StoreAbstractPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AbstractPage clickLogout() {
        if (logout != null)
            logout.click();
        else
            System.out.println("LOGOUT LINK == NULL");
        return this;
    }

    public AbstractPage clickLogin() {
        if (login != null)
            login.click();
        else
            System.out.println("LOGIN LINK == NULL");
        return this;
    }

    public AbstractPage clickCreateAccount() {
        if (createAccount != null)
            createAccount.click();
        else
            System.out.println("CLICK CREATE ACCOUNT LINK == NULL");
        return this;
    }

    public boolean isCurrentPage() {
        return getDriver().getCurrentUrl().contains(PATH);
    }

    public static boolean isCurrentPage(WebDriver driver) {
        return driver.getCurrentUrl().contains(PATH);
    }
}

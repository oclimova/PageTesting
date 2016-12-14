package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by oclimova on 12/14/2016.
 */
public class AccountCreatedPage extends StoreAbstractPage {
    private static final String PATH = "index.php?route=account/success";

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getPath() {
        return super.getPath() + PATH;
    }

    public AccountCreatedPage navigate() {
        getDriver().get(getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return isCurrentPage(getDriver());
    }

    public static boolean isCurrentPage(WebDriver driver) {
        return driver.getTitle().equals("Your Account Has Been Created!");
    }
}

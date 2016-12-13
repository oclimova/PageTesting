package pages;

import org.openqa.selenium.WebDriver;

public class LogoutPage extends StoreAbstractPage {
    private static final String LOGOUT_PAGE_PATH = "index.php?route=account/logout";

    public LogoutPage(WebDriver webdriver) {
        super(webdriver);
    }

    public String getPath() {
        return super.getPath() + LOGOUT_PAGE_PATH;
    }

    public LogoutPage navigate() {
        getDriver().get(getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return isCurrentPage(getDriver());
    }

    public static boolean isCurrentPage(WebDriver driver) {
        return driver.getTitle().equals("Account Logout");
    }
}
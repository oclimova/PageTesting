package pages;

import org.openqa.selenium.WebDriver;

public class LogoutPage extends StoreAbstractPage {
    private static final String PATH = "index.php?route=account/logout";

    public LogoutPage(WebDriver webdriver) {
        super(webdriver);
    }

    public String getPath() {
        return super.getPath() + PATH;
    }

    public LogoutPage navigate() {
        getDriver().get(getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return getDriver().getTitle().equals("Account Logout");
    }
}
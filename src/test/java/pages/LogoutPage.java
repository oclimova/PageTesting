package pages;

import org.openqa.selenium.WebDriver;

public class LogoutPage extends StoreAbstractPage {
    public LogoutPage(WebDriver webdriver) {
        super(webdriver);
    }

    public LogoutPage navigate() {
        getDriver().get("http://172.16.44.49/oc/index.php?route=account/logout");
        return this;
    }

    public boolean isActive() {
        return getDriver().getTitle().equals("Account Logout");
    }
}
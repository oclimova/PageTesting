package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by oclimova on 12/10/2016.
 */
public class LogoutPage extends AbstractPage {
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
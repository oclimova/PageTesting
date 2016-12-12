package pages;

import org.openqa.selenium.WebDriver;

public interface Page {
    AbstractPage navigate();
    boolean isActive();
    WebDriver getDriver();
}

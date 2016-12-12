package pages;

import org.openqa.selenium.WebDriver;

public interface Page {
    AbstractPage navigate();
    boolean isCurrentPage();
    WebDriver getDriver();
}

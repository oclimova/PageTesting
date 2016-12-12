package pages;

import org.openqa.selenium.WebDriver;

public interface Page {
    AbstractPage navigate();
    String getPath();
    boolean isCurrentPage();
    WebDriver getDriver();
}

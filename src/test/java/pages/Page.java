package pages;

import org.openqa.selenium.WebDriver;

public interface Page {
    Page navigate();
    String getPath();
    boolean isCurrentPage();
    static boolean isCurrentPage(WebDriver driver);
    WebDriver getDriver();
}

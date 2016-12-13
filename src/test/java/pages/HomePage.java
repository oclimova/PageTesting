package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends StoreAbstractPage {
    private static final String PATH = "index.php?route=common/home";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPath() {
        return super.getPath() + PATH;
    }

    public HomePage navigate() {
        getDriver().get(getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return isCurrentPage(getDriver());
    }

    public static boolean isCurrentPage(WebDriver driver) {
        return driver.getTitle().equals("Your Store");
    }
}
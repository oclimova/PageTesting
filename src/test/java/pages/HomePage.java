package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends StoreAbstractPage {
    private static final String PATH = "index.php?route=common/home";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static String getPath() {
        return PATH;
    }

    public HomePage navigate() {
        getDriver().get(super.getPath() + this.getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return getDriver().getTitle().equals("Your Store");
    }
}
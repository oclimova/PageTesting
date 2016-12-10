package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigate() {
        getDriver().get("http://172.16.44.49/oc/");
        return this;
    }

    public boolean weAreHere() {
        return getDriver().getTitle().equals("Your Store");
    }
}
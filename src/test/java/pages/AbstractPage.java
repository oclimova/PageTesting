package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage implements Page {
    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    protected AbstractPage setElementText(By element, String value) {
        driver.findElement(element).sendKeys(value);
        return this;
    }
}

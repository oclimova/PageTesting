package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.xpath("//*[@id=\"welcome\"]/a[1]"),
        createAccountLink = By.xpath("//*[@id=\"welcome\"]/a[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigate() {
        driver.get("http://172.16.44.49/oc/");
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }
}

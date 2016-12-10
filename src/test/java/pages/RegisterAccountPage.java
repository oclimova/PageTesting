package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterAccountPage extends AbstractPage {
    private WebDriver driver;
    private By
            firstName = By.name("firstname"),
            lastName = By.name("lastname"),
            email = By.name("email"),
            telephone = By.name("telephone"),
            address1 = By.name("address_1"),
            city = By.name("city"),
            postcode = By.name("postcode"),
            country = By.name("country_id"),
            region = By.name("zone_id"),
            password = By.name("password"),
            passwordConfirm = By.name("confirm"),
            yesRadio = By.xpath("//*[@id=\"content\"]/form/div[4]/table/tbody/tr/td[2]/input[1]"),
            noRadio = By.xpath("//*[@id=\"content\"]/form/div[4]/table/tbody/tr/td[2]/input[2]"),
            privacyPolicy = By.xpath("//*[@id=\"content\"]/form/div[5]/div/input[1]");

    public RegisterAccountPage setFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setEmail(String value) {
        driver.findElement(email).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setTelephone(String value) {
        driver.findElement(telephone).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setAddress1(String value) {
        driver.findElement(address1).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setCity(String value) {
        driver.findElement(city).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setPostcode(String value) {
        driver.findElement(postcode).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setRandomCountry() {
        Select select = new Select(driver.findElement(country));
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
        return this;
    }

    public RegisterAccountPage setRandomRegion() {
        Select select = new Select(driver.findElement(region));
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
        return this;
    }

    public RegisterAccountPage setPassword(String value) {
        driver.findElement(password).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setPasswordConfirm(String value) {
        driver.findElement(passwordConfirm).sendKeys(value);
        return this;
    }

    public RegisterAccountPage setYesRadio() {
        driver.findElement(yesRadio).click();
        return this;
    }

    public RegisterAccountPage setNoRadio() {
        driver.findElement(noRadio).click();
        return this;
    }

    public RegisterAccountPage setPrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
        return this;
    }
}

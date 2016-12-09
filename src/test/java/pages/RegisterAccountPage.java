package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterAccountPage {
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

    public void setFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void setLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void setEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void setTelephone(String value) {
        driver.findElement(telephone).sendKeys(value);
    }

    public void setAddress1(String value) {
        driver.findElement(address1).sendKeys(value);
    }

    public void setCity(String value) {
        driver.findElement(city).sendKeys(value);
    }

    public void setPostcode(String value) {
        driver.findElement(postcode).sendKeys(value);
    }

    public void setRandomCountry() {
        Select select = new Select(driver.findElement(country));
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
    }

    public void setRandomRegion() {
        Select select = new Select(driver.findElement(region));
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
    }

    public void setPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void setPasswordConfirm(String value) {
        driver.findElement(passwordConfirm).sendKeys(value);
    }

    public void setYesRadio() {
        driver.findElement(yesRadio).click();
    }

    public void setNoRadio() {
        driver.findElement(noRadio).click();
    }

    public void setPrivacyPolicy() {
        driver.findElement(privacyPolicy).click();
    }
}

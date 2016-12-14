package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterAccountPage extends StoreAbstractPage {
    private static final String PATH = "index.php?route=account/register";

    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "telephone")
    private WebElement telephone;
    @FindBy(name = "fax")
    private WebElement fax;
    @FindBy(name = "company")
    private WebElement company;
    @FindBy(name = "company_id")
    private WebElement companyID;
    @FindBy(name = "address_1")
    private WebElement address1;
    @FindBy(name = "address_2")
    private WebElement address2;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(name = "postcode")
    private WebElement postcode;
    @FindBy(name = "country_id")
    private WebElement country;
    @FindBy(name = "zone_id")
    private WebElement region;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "confirm")
    private WebElement passwordConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div[4]/table/tbody/tr/td[2]/input[1]")
    private WebElement yesRadio;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div[4]/table/tbody/tr/td[2]/input[2]")
    private WebElement noRadio;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div[5]/div/input[1]")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div[5]/div/input[2]")
    private WebElement continueButton;

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPath() {
        return super.getPath() + PATH;
    }

    public RegisterAccountPage navigate() {
        getDriver().get(getPath());
        return this;
    }

    public boolean isCurrentPage() {
        return isCurrentPage(getDriver());
    }

    public static boolean isCurrentPage(WebDriver driver) {
        return driver.getTitle().equals("Register Account");
    }

    public boolean textFieldsAreClear() {
        return getFirstName().equals("")
                && getLastName().equals("")
                && getEmail().equals("")
                && getTelephone().equals("")
                && getFax().equals("")
                && getCompany().equals("")
                && getCompanyID().equals("")
                && getAddress1().equals("")
                && getAddress2().equals("")
                && getCity().equals("")
                && getPostcode().equals("")
                && getPassword().equals("")
                && getPasswordConfirm().equals("");
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getTelephone() {
        return telephone.getText();
    }

    public String getFax() {
        return fax.getText();
    }

    public String getCompany() {
        return company.getText();
    }

    public String getCompanyID() {
        return companyID.getText();
    }

    public String getAddress1() {
        return address1.getText();
    }

    public String getAddress2() {
        return address2.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getPostcode() {
        return postcode.getText();
    }

    public String getCountry() {
        Select countrySelect = new Select(country);
        return countrySelect.getFirstSelectedOption().getText();
    }

    public String getRegion() {
        Select regionSelect = new Select(region);
        return regionSelect.getFirstSelectedOption().getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getPasswordConfirm() {
        return passwordConfirm.getText();
    }

    public String getSubscribe() {
        if (yesRadio.isSelected())
            return "Yes";
        else
            return "No";
    }

    public RegisterAccountPage setFirstName(String value) {
        firstName.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setLastName(String value) {
        lastName.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setEmail(String value) {
        email.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setTelephone(String value) {
        telephone.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setFax(String value) {
        fax.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setCompany(String value) {
        company.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setCompanyID(String value) {
        companyID.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setAddress1(String value) {
        address1.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setAddress2(String value) {
        address2.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setCity(String value) {
        city.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setPostcode(String value) {
        postcode.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setRandomCountry() {
        Select select = new Select(country);
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
        return this;
    }

    public RegisterAccountPage setRandomRegion() {
        Select select = new Select(region);
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
        return this;
    }

    public RegisterAccountPage setPassword(String value) {
        password.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setPasswordConfirm(String value) {
        passwordConfirm.sendKeys(value);
        return this;
    }

    public RegisterAccountPage setYesRadio() {
        yesRadio.click();
        return this;
    }

    public RegisterAccountPage setNoRadio() {
        noRadio.click();
        return this;
    }

    public RegisterAccountPage setPrivacyPolicy() {
        privacyPolicy.click();
        return this;
    }

    public void pressContinue() {
        continueButton.click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterAccountPage extends StoreAbstractPage {
    private static Map<String, By> fields;

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
        fields = new HashMap<String, By>();
        fields.put("firstName", By.name("firstname"));
        fields.put("lastName", By.name("lastname"));
        fields.put("email", By.name("email"));
        fields.put("telephone", By.name("telephone"));
        fields.put("fax", By.name("fax"));
        fields.put("company", By.name("company"));
        fields.put("companyID", By.name("company_id"));
        fields.put("address1", By.name("address_1"));
        fields.put("address2", By.name("address_2"));
        fields.put("city", By.name("city"));
        fields.put("postcode", By.name("postcode"));
        fields.put("country", By.name("country_id"));
        fields.put("region", By.name("zone_id"));
        fields.put("password", By.name("password"));
        fields.put("passwordConfirm", By.name("confirm"));
        fields.put("yesRadio", By.xpath("//*[@id=\"content\"]/form/div[4]/table/tbody/tr/td[2]/input[1]"));
        fields.put("noRadio", By.xpath("//*[@id=\"content\"]/form/div[4]/table/tbody/tr/td[2]/input[2]"));
        fields.put("privacyPolicy", By.xpath("//*[@id=\"content\"]/form/div[5]/div/input[1]"));
    }

    public RegisterAccountPage navigate() {
        getDriver().get("http://172.16.44.49/oc/index.php?route=account/register");
        return this;
    }

    public boolean isActive() {
        return getDriver().getTitle().equals("Register Account");
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
        return getElementText(firstName);
    }

    public String getLastName() {
        return getElementText(lastName);
    }

    public String getEmail() {
        return getElementText(email);
    }

    public String getTelephone() {
        return getElementText(telephone);
    }

    public String getFax() {
        return getElementText(fax);
    }

    public String getCompany() {
        return getElementText(company);
    }

    public String getCompanyID() {
        return getElementText(companyID);
    }

    public String getAddress1() {
        return getElementText(address1);
    }

    public String getAddress2() {
        return getElementText(address2);
    }

    public String getCity() {
        return getElementText(city);
    }

    public String getPostcode() {
        return getElementText(postcode);
    }

    public String getCountry() {
        return getElementText(country);
    }

    public String getRegion() {
        return getElementText(region);
    }

    public String getPassword() {
        return getElementText(password);
    }

    public String getPasswordConfirm() {
        return getElementText(passwordConfirm);
    }

    public String getSubscribe() {
        if (getDriver().findElement(yesRadio).isSelected())
            return "Yes";
        else
            return "No";
    }

    public RegisterAccountPage setFirstName(String value) {
        return (RegisterAccountPage)setElementText(firstName, value);
    }

    public RegisterAccountPage setLastName(String value) {
        return (RegisterAccountPage)setElementText(lastName, value);
    }

    public RegisterAccountPage setEmail(String value) {
        return (RegisterAccountPage)setElementText(email, value);
    }

    public RegisterAccountPage setTelephone(String value) {
        return (RegisterAccountPage)setElementText(telephone, value);
    }

    public RegisterAccountPage setFax(String value) {
        return (RegisterAccountPage)setElementText(fax, value);
    }

    public RegisterAccountPage setCompany(String value) {
        return (RegisterAccountPage)setElementText(company, value);
    }

    public RegisterAccountPage setCompanyID(String value) {
        return (RegisterAccountPage)setElementText(companyID, value);
    }

    public RegisterAccountPage setAddress1(String value) {
        return (RegisterAccountPage)setElementText(address1, value);
    }

    public RegisterAccountPage setAddress2(String value) {
        return (RegisterAccountPage)setElementText(address2, value);
    }

    public RegisterAccountPage setCity(String value) {
        return (RegisterAccountPage)setElementText(city, value);
    }

    public RegisterAccountPage setPostcode(String value) {
        return (RegisterAccountPage)setElementText(postcode, value);
    }

    public RegisterAccountPage setRandomCountry() {
        Select select = new Select(getDriver().findElement(country));
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
        return this;
    }

    public RegisterAccountPage setRandomRegion() {
        Select select = new Select(getDriver().findElement(region));
        select.selectByIndex((int)(Math.random()*select.getOptions().size()));
        return this;
    }

    public RegisterAccountPage setPassword(String value) {
        return (RegisterAccountPage)setElementText(password, value);
    }

    public RegisterAccountPage setPasswordConfirm(String value) {
        return (RegisterAccountPage)setElementText(passwordConfirm, value);
    }

    public RegisterAccountPage setYesRadio() {
        getDriver().findElement(yesRadio).click();
        return this;
    }

    public RegisterAccountPage setNoRadio() {
        getDriver().findElement(noRadio).click();
        return this;
    }

    public RegisterAccountPage setPrivacyPolicy() {
        getDriver().findElement(privacyPolicy).click();
        return this;
    }
}

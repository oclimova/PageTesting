package pages;

import org.openqa.selenium.WebDriver;

public class WhateverPage extends AbstractPage {
    public WhateverPage(WebDriver driver) {
        super(driver);
    }

    public WhateverPage navigate() {
        return this;
    }

    public boolean isActive() {
        return getDriver().getCurrentUrl().contains("http://172.16.44.49/oc/");
    }
}

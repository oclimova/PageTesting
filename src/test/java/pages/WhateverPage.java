package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by oclimova on 12/10/2016.
 */
public class WhateverPage extends AbstractPage {
    public WhateverPage(WebDriver driver) {
        super(driver);
    }

    public WhateverPage navigate() {
        return this;
    }

    public boolean isActive() {
        return true;
    }
}

package pages;

import org.openqa.selenium.WebDriver;

public class WhateverPage extends StoreAbstractPage {
    public WhateverPage(WebDriver driver) {
        super(driver);
    }

    public WhateverPage navigate() {
        return this;
    }

    public String getPath() {
        return super.getPath();
    }

    public boolean isCurrentPage() {
        return getDriver().getCurrentUrl().contains(getPath());
    }
}

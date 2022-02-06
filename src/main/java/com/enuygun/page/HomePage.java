package com.enuygun.page;

import com.enuygun.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static By UCAK_BILETI = By.xpath("(//a[text()='Uçak Bileti'])[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        navigate("https://www.enuygun.com/");
    }

    public void clickFlightTicketTab() {
        clickWithJs(UCAK_BILETI);
    }

    public void submitHomePage() {
        navigate();
        clickFlightTicketTab();
    }
}

package com.enuygun.page;

import com.enuygun.Log4j;
import com.enuygun.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class HomePage extends BasePage {
    private static By UCAK_BILETI = By.xpath("(//a[text()='Uçak Bileti'])[1]");
    private static By LOGIN = By.xpath("//a[text()='Giriş Yap']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        navigate("https://www.enuygun.com/");
    }

    public void isHomePage() {
        String loginText = getText(LOGIN);
        Assert.assertEquals(loginText,"Giriş Yap");
        Log4j.info("Home page");
    }

    public void clickFlightTicketTab() {
        clickWithJs(UCAK_BILETI);
        Log4j.info("Clicked flight tab");
    }
}

package com.enuygun.page;

import com.enuygun.Log4j;
import com.enuygun.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightDetailPage extends BasePage {
    private static By DETAIL_TEXT = By.xpath("//div[text()='Lütfen Gidiş Uçuşunuzu Seçin']");

    public FlightDetailPage(WebDriver driver) {
        super(driver);
    }

    public void isDetailPage() {
        String detailText = getText(DETAIL_TEXT);
        Assert.assertEquals(detailText,"Lütfen Gidiş Uçuşunuzu Seçin");
        Log4j.info("Detail page");
    }
}

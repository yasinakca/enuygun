package com.enuygun.page;

import com.enuygun.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightDetailPage extends BasePage {
    private static By DETAIL_TEXT = By.xpath("//div[text()='Lütfen Gidiş Uçuşunuzu Seçin']");

    public FlightDetailPage(WebDriver driver) {
        super(driver);
    }
}
